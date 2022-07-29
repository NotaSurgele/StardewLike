package com.farm.game.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class GMap implements IGMap {

    String _config = null;
    String _name = null;

    ArrayList<int[][]> layersArray = null;

    public GMap(String configFile, String name) {
        _config = configFile;
        _name = name;
        layersArray = new ArrayList<>();
    }

    private GMap() {}

    @Override final
    public String getMapName() {
        return _name;
    }

    @Override
    public abstract void create();

    private AbstractMap.SimpleEntry<Integer, Integer> retrieveLayerSize(JSONObject layerData) {
        long width = 0;
        long height = 0;

        width = (long) layerData.get("width");
        height = (long) layerData.get("height");
        return new AbstractMap.SimpleEntry<>(Integer.parseInt(String.valueOf(width)), Integer.parseInt(String.valueOf(height)));
    }

    @Override final
    public void createLayer() {
        try {
            JSONObject jsonFile = (JSONObject) new JSONParser().parse(new FileReader(_config));
            JSONArray layers = ((JSONArray) jsonFile.get("layers"));
            Iterator it = layers.iterator();

            for ( ; it.hasNext(); ) {
                JSONObject layerData = (JSONObject) it.next();
                AbstractMap.SimpleEntry<Integer, Integer> layerSize = retrieveLayerSize(layerData);
                JSONArray layerJSON = (JSONArray) layerData.get("data");
                Iterator it2 = layerJSON.iterator();
                int[][] layer = new int[layerSize.getValue()][layerSize.getKey()];

                for (int i = 0, j = 0 ; it2.hasNext(); ) {
                    if (j == layerSize.getKey()) {
                        j = 0;
                        i++;
                    }
                    layer[i][j++] = Integer.parseInt(String.valueOf(it2.next()));
                }
                layersArray.add(layer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public abstract void draw();

    @Override
    public abstract void dispose();
}
