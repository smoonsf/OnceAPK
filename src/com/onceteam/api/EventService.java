package com.onceteam.api;

import java.util.List;
import com.onceteam.model.Event;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface EventService {

    @GET("/event/?format=json&order_by=date&limit=10")
    void getEventList(@Query("offset") Integer offset, Callback<List<Event>> callback);
    
    @GET("/event/?format=json&limit=10")
    void getCatEventList(@Query("category") Integer cat, @Query("offset") Integer offset, @Query("order_by") String order, 
    		Callback<List<Event>> callback);
    
    @GET("/event/?premium=true&order_by=date&format=json")
    void getPremiumEventList(Callback<List<Event>> callback);

    @GET("/event/{event_id}/?format=json")
    void getEvent(@Path("event_id") Integer event_id, Callback<Event> callback);
    
}