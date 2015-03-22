package com.onceteam.api;

import java.util.List;
import java.util.Map;

import com.onceteam.model.Event;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

public interface EventService {

    @GET("/api/once/event/?format=json")
    void getEventList(Callback<List<Event>> callback);

    @GET("/api/once/event/{event_id}/?format=json")
    void getEvent(@Path("event_id") Integer event_id, Callback<Event> callback);
    
}