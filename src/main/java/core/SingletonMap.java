package core;

import java.util.HashMap;

public class SingletonMap {
    private HashMap<String, Double> mapConvert;
    private static SingletonMap instance;

    public static SingletonMap getInstance() {

        if (instance == null) {
            instance = new SingletonMap();
        }
        return instance;

    }
    private SingletonMap() {
        mapConvert = new HashMap<>();
        mapConvert.put("m", 1.0);
        mapConvert.put("cm", 0.01);
        mapConvert.put("in", 0.0254);
        mapConvert.put("ft", 0.3048);
    }

    public HashMap<String, Double> getMapConvert() {
        return mapConvert;
    }

    public void setMapConvert(HashMap<String, Double> mapConvert) {
        this.mapConvert = mapConvert;
    }

    @Override
    public String toString() {
        return "SingletonMap{" +
                "mapConvert=" + mapConvert +
                '}';
    }
}
