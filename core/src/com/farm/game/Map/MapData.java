package com.farm.game.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class MapData {

    int _tileWidth = 0;
    int _tileHeight = 0;
    int _tileCount = 0;
    int _imageHeight = 0;
    int _imageWidth = 0;
    int _column = 0;

    String _tileSetConfig = null;
    JSONObject _jsonFile = null;
    TextureRegion _tileSet = null;
    SpriteBatch batch = null;
    HashMap<Integer, AbstractMap.SimpleEntry<Integer, Integer>> _values = null;

    public MapData(String tileSetConfig) {
        _tileSetConfig = tileSetConfig;
        batch = new SpriteBatch();
        _values = new HashMap<>();
    }

    private String getXMLFile() {
        try {
            _jsonFile = (JSONObject) new JSONParser().parse(new FileReader(_tileSetConfig));
            JSONArray map = ((JSONArray) _jsonFile.get("tilesets"));
            Iterator it = map.iterator();

            while (it.hasNext()) {
                Iterator itMap = ((Map) it.next()).entrySet().iterator();

                while (itMap.hasNext()) {
                    String value = String.valueOf(itMap.next());

                    if (value.contains("source")) {
                        String[] infos = value.split("=");

                        return infos[1];
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void parseXML(Scanner scanner) {

        String[] matchingElem = {
                "tilewidth=",
                "tileheight=",
                "tilecount=",
                "columns=",
                "source=",
                "height=",
                "width="
        };
        int[] results = new int[6];
        int index = 0;

        while (scanner.hasNext()) {
            String data = scanner.next();

            for (String s : matchingElem) {
                if (data.startsWith(s)) {
                    String[] buffer = data.split("=");

                    if (!s.contains("source=")) {

                        results[index++] = Integer.parseInt(buffer[1].replace("\"", "").replace(">", "").replace("/", ""));
                    } else {
                        String cleared = buffer[1].replace("..", "").replace("\"", "");

                        _tileSet = new TextureRegion(new Texture("." + cleared));
                    }
                }
            }
        }
        _tileWidth = results[0];
        _tileHeight = results[1];
        _tileCount = results[2];
        _column = results[3];
        _imageWidth = results[4];
        _imageHeight = results[5];
        scanner.close();
    }

    public int getTileWidth() {
        return _tileWidth;
    }

    public int getTileHeight() {
        return _tileHeight;
    }

    private void loadImageInfo() {
        String path = getXMLFile();

        if (path == null)
            return;
        try {
            Scanner scanner = new Scanner(new File(path));

            parseXML(scanner);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public TextureRegion getTextureRegionFromId(int id) {
        AbstractMap.SimpleEntry<Integer, Integer> coord = _values.get(id);

        _tileSet.setRegion(coord.getKey(), coord.getValue(), _tileWidth, _tileHeight);
        return _tileSet;
    }

    private void load() {
        loadImageInfo();
    }

    public boolean create() {
        load();
        int x = 0;
        int y = 0;

        for (int i = 1; i <= _tileCount; i++) {
            if (x == _imageWidth) {
                y += _tileHeight;
                x = 0;
            }
            _values.put(i, new AbstractMap.SimpleEntry<>(x, y));
            x += _tileWidth;
        }
        return true;
    }

    public void draw() {
        batch.begin();
        float posX = 0;
        float posY = 0;

        for (int i = 0; i < _tileCount ; i++) {
            if (i % _column == 0) {
                posY += _tileHeight;
                posX = 0;
            }
            batch.draw(getTextureRegionFromId(i), posX, posY);
            posX += _tileWidth;
        }
        batch.end();
    }
}