package com.farm.game.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

public class MapData {
    ArrayList<TilesetData> _tilesetData = null;
    ArrayList<TextureRegion> _tileSet = null;
    ArrayList<Integer> _gid = null;
    String _tileSetConfig = null;
    JSONObject _jsonFile = null;
    SpriteBatch batch = null;
    HashMap<Integer, AbstractMap.SimpleEntry<Integer, Integer>> _values = null;

    public MapData(String tileSetConfig) {
        _tileSetConfig = tileSetConfig;
        batch = new SpriteBatch();
        _values = new HashMap<>();
        _tilesetData = new ArrayList<>();
        _gid = new ArrayList<>();
        _tileSet = new ArrayList<>();
    }

    private ArrayList<String> getXMLFile() {
        try {
            ArrayList<String> data = new ArrayList<>();

            _jsonFile = (JSONObject) new JSONParser().parse(new FileReader(_tileSetConfig));
            JSONArray map = ((JSONArray) _jsonFile.get("tilesets"));
            Iterator it = map.iterator();

            while (it.hasNext()) {
                Iterator itMap = ((Map) it.next()).entrySet().iterator();

                while (itMap.hasNext()) {
                    String value = String.valueOf(itMap.next());

                    if (value.contains("source")) {
                        String[] infos = value.split("=");

                        data.add(infos[1]);
                        break;
                    }
                    if (value.contains("firstgid")) {
                        String[] gid = value.split("=");

                        _gid.add(Integer.parseInt(gid[1]));
                    }
                }
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private int parseCollider(String data, int id, ArrayList<Integer> collidingMap)
    {
        if (data.contains("id="))
            return Integer.parseInt(data.split("\"")[1]);
        if (id != -1 && data.contains("value=")) {
            String[] buffer = data.split("\"");

            if (Integer.parseInt(data.split("\"")[1]) == 1) {
                collidingMap.add(id + 1);
                return -1;
            }
        }
        return id;
    }

    private void parseXML(Scanner scanner, int currentTileSet, int oldTc) {

        String[] matchingElem = {
                "tilewidth=",
                "tileheight=",
                "tilecount=",
                "columns=",
                "source=",
                "height=",
                "width=",
        };
        int[] results = new int[6];
        int index = 0;
        int id = -1;
        ArrayList<Integer> collidingMap = new ArrayList<>();

        while (scanner.hasNext()) {
            String data = scanner.next();

            id = parseCollider(data, id, collidingMap);
            for (String s : matchingElem) {
                if (data.startsWith(s)) {
                    String[] buffer = data.split("=");

                    if (!s.contains("source=")) {
                        results[index++] = Integer.parseInt(buffer[1].replace("\"", "").replace(">", "").replace("/", ""));
                    } else {
                        String cleared = buffer[1].replace("..", "").replace("\"", "");

                        _tileSet.add(new TextureRegion(new Texture("." + cleared)));
                    }
                }
            }
        }
        System.out.println("hello wolrd");
        _tilesetData.add(new TilesetData(results[0], results[1], oldTc + results[2], results[3], results[4], results[5], _gid.get(currentTileSet), _tileSet.get(currentTileSet)).setCollidingCells(collidingMap));
    }

    public int getTileWidth() {
        return _tilesetData.get(0).tileWidth;
    }

    public int getTileHeight() {
        return _tilesetData.get(0).tileHeight;
    }

    private void loadImageInfo() {
        ArrayList<String> path = getXMLFile();
        int index = 0;
        int oldTc = 0;

        if (path == null)
            return;
        for (String s : path) {
            try {
                Scanner scanner = new Scanner(new File(s));

                parseXML(scanner, index, oldTc);
                scanner.close();
                oldTc = _tilesetData.get(index).tileCount;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            index++;
        }
        _tileSet.clear();
        _gid.clear();
    }

    public TextureRegion getTileTextureByID(int id) {
        AbstractMap.SimpleEntry<Integer, Integer> coord = _values.get(id);
        int old = 1;

        for (TilesetData data : _tilesetData) {

            if (data.contain(old, id)) {
                data.tileSet.setRegion(coord.getKey(), coord.getValue(), data.tileWidth, data.tileHeight);
                return data.tileSet;
            }
            old = data.tileCount;
        }
        return null;
    }

    private void load() {
        loadImageInfo();
    }

    public boolean isCollidingCells(int id) {
        int old = 1;
        int test = 0;

        for (TilesetData data : _tilesetData) {

            if (data.contain(old, id)) {
                return data.collidingCells.contains(id - old);
            }
            old = data.tileCount;
        }
        return false;
    }

    public boolean create() {
        load();
        for (TilesetData data : _tilesetData) {

            int x = 0;
            int y = 0;

            for (int i = data.gid; i <= data.tileCount; i++) {
                if (x == data.imageWidth) {
                    y += data.tileHeight;
                    x = 0;
                }
                _values.put(i, new AbstractMap.SimpleEntry<>(x, y));
                x += data.tileWidth;
            }
        }
        return true;
    }

    public void draw() {
        batch.begin();
        for (TilesetData data : _tilesetData) {

            float posX = 0;
            float posY = 0;

            for (int i = 0; i < data.tileCount ; i++) {
                if (i % data.column == 0) {
                    posY += data.tileHeight;
                    posX = 0;
                }
                batch.draw(getTileTextureByID(i), posX, posY);
                posX += data.tileWidth;
            }
        }
        batch.end();
    }
}