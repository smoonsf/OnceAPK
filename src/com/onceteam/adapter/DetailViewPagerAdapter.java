package com.onceteam.adapter;

import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import com.onceteam.model.Event;
import com.onceteam.model.EventImage;
import com.onceteam.once.DetailEventActivity;
import com.onceteam.once.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailViewPagerAdapter extends PagerAdapter {
	
	Event event;
	LayoutInflater mInflater;
	Context context;
	
	
	
	public DetailViewPagerAdapter(Context c, Event evt){
		event = evt;
		context = c;
	}

	@Override
	public int getCount() {
		
		return event.getEventimage().size();
	}

	@Override
	public boolean isViewFromObject(View v, Object obj) {
		
		return v == obj;
	}
	
	public int getItemPosition(Object object){
	     return POSITION_NONE;
	}

	
	public Object instantiateItem(View pager, final int position) {
		int resId = R.layout.item_pvlist;
		View v = mInflater.inflate(resId, null);
		ImageView poster = (ImageView) v.findViewById(R.id.poster);
		
		
		Picasso.with(context)
		.load(event.getEventimage().get(position).getImage())
		.placeholder(R.drawable.temp)
		.into(poster);
		
		
		
		((AutoScrollViewPager) pager).addView(v, null);
		
		return v;
	}
	
	public void destroyItem(View pager, int position, Object view) {
		((AutoScrollViewPager) pager).removeView((View) view);
	}

}
