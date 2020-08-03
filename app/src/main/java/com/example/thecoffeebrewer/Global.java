package com.example.thecoffeebrewer;

import java.util.HashMap;

public class Global {
    private HashMap<String, Integer> NamesAndPhotosIDsMap = new HashMap<String, Integer>();

    Global() {
        NamesAndPhotosIDsMap.put("Aeropress", R.drawable.aeropressicon);
        NamesAndPhotosIDsMap.put("Hario V60", R.drawable.hariov60icon);
        NamesAndPhotosIDsMap.put("French Press", R.drawable.frenchpressicon);
        NamesAndPhotosIDsMap.put("Chemex", R.drawable.chemexicon);
        NamesAndPhotosIDsMap.put("Cupping", R.drawable.cuppingicon);
        NamesAndPhotosIDsMap.put("Kalita", R.drawable.kalitaiocn);
        NamesAndPhotosIDsMap.put("Moka pot", R.drawable.mokapoticon);
    }

    public Integer getMethodId(String key) {
        return NamesAndPhotosIDsMap.get(key);
    }
}
