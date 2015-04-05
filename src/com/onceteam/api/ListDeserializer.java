package com.onceteam.api;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ListDeserializer<List> implements JsonDeserializer<List> {

    @Override
    public List deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
            throws JsonParseException
    {
        JsonElement objects = je.getAsJsonObject().get("objects");
        return new Gson().fromJson(objects,type);
    }
}
