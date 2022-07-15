package com.farm.game.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TileSet {

    int _tileWidth = 0;
    int _tileHeight = 0;
    int _tileCount = 0;
    int _column = 0;

    Texture _tileSetImage = null;
    String _tileSetConfig = null;
    JSONObject _jsonFile = null;
    TextureRegion[] _textures = null;
    TextureRegion _tileSet = null;

    SpriteBatch batch = null;

    public TileSet(String tileSetConfig) {
        _tileSetConfig = tileSetConfig;
        batch = new SpriteBatch();
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
                "source="
        };
        int[] results = new int[4];
        int index = 0;

        while (scanner.hasNext()) {
            String data = scanner.next();

            for (String s : matchingElem) {
                if (data.contains(s)) {
                    if (!s.contains("source=")) {
                        String[] buffer = data.split("=");

                        results[index++] = Integer.parseInt(buffer[1].replace("\"", "").replace(">", ""));
                    } else {
                        String[] buffer = data.split("=");

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
        scanner.close();
    }

    private void loadTexture() {
        _textures = new TextureRegion[_tileCount];
        int x = 0;
        int y = _tileHeight;

        for (int i = 0; i < _tileCount; i++) {
            _tileSet.setRegion(x, y, _tileWidth, _tileHeight);
            _textures[i] = _tileSet;
            if (y % _column == 0) {
                y += _tileHeight;
                x = 0;
            }
            x += _tileWidth;
        }
    }

    private void loadImageInfo() {
        String path = getXMLFile();

        System.out.println(path);
        if (path == null)
            return;
        try {
            Scanner scanner = new Scanner(new File(path));

            parseXML(scanner);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void load() {
        loadImageInfo();
        loadTexture();
    }

    public boolean create() {
        if (_tileSetImage == null)
            return false;

        load();
        return true;
    }

    public void draw() {
        batch.begin();
        int x = 0;
        int y = 16;

        float posX = 0;
        float posY = 0x00f;
        for (int i = 0; i < _tileCount; i++) {
            _textures[i].setRegion(x, y, _tileWidth, _tileHeight);
            batch.draw(_textures[i], posX, posY);
            if (i > 0 && i % _column == 0) {
                y += _tileHeight;
                x = 0;
                posX = 0;
                posY += _tileHeight;
            }
            x += _tileWidth;
            posX += _tileWidth;
        }
        batch.end();
    }
}
