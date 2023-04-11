package com.br.appback.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import jakarta.inject.Inject;

import java.io.StringWriter;

public class Json {

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
       Gson gson = new Gson();
       return (T) gson.fromJson(jsonString, clazz.getClass());
    }

    public static String toJson(Object json) {
        Gson gson = new Gson();
        return gson.toJson(json);
    }

}
