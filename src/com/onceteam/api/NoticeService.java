package com.onceteam.api;

import java.util.List;

import com.onceteam.model.Notice;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


public interface NoticeService {
	
	@GET("/notice/?format=json&order_by=-updated_at&limit=10")
    void getNoticeList(@Query("offset") Integer offset, Callback<List<Notice>> callback);

    @GET("/notice/{notice_id}/?format=json")
    void getNotice(@Path("notice_id") Integer notice_id, Callback<Notice> callback);
}
