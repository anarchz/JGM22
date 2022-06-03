package com.dao;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Storage {
    private static Map<String, List<?>> storage;
    private static Storage st;

    private Storage() {
        storage = new HashMap<String, List<?>>();
    }

    public static Map<String, List<?>> getStorage() {
        if(st == null) {
            return new Storage().storage;
        }
        return storage;
    }
}
