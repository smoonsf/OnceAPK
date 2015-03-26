package com.onceteam.api;

import java.util.List;
import com.onceteam.model.Event;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface EventService {

    @GET("/event/?format=json")
    void getEventList(Callback<List<Event>> callback);
    
    @GET("/event/?premium=true&format=json")
    void getPremiumEventList(Callback<List<Event>> callback);

    @GET("/event/{event_id}/?format=json")
    void getEvent(@Path("event_id") Integer event_id, Callback<Event> callback);
    
}