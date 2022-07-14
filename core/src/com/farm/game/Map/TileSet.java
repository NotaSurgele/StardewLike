package com.farm.game.Map;

import com.badlogic.gdx.graphics.Texture;
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

    Texture _tileSetImage = null;
    String _tileSetConfig = null;
    JSONObject _jsonFile = null;
    TextureRegion[] _textures = null;

    public TileSet(String tileSetConfig) {
        _tileSetConfig = tileSetConfig;
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
        };
        int[] results = new int[3];
        int index = 0;

        while (scanner.hasNext()) {
            String data = scanner.next();

            for (String s : matchingElem) {
                if (data.contains(s)) {
                    String[] buffer = data.split("=");

                    results[index++] = Integer.parseInt(buffer[1].replace("\"", ""));
                }
            }
        }
        _tileWidth = results[0];
        _tileHeight = results[1];
        _tileCount = results[2];
        scanner.close();
    }

    private void loadTexture() {

    }

    private void loadImageInfo() {
        String path = "maps/" + getXMLFile();

        try {
            Scanner scanner = new Scanner(new File(path));

            parseXML(scanner);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void load() {
        loadImageInfo();
    }

    public boolean create() {
        if (_tileSetImage == null)
            return false;/*
        TextureRegion[][] tmp = TextureRegion.split(_tileSetImage,)*/
        return true;
    }
}
