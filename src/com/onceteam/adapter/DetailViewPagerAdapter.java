package com.onceteam.adapter;

import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import com.onceteam.model.Event;
import com.onceteam.model.Eventimage;
import com.onceteam.once.DetailEventActivity;
import com.sinchontycoon.once.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailViewPagerAdapter extends PagerAdapter {
	
	Event event;
	LayoutInflater mInflater;
	Context context;
	
	
	
	public DetailViewPagerAdapter(Context c, Event evt){
		event = evt;
		context = c;
		mInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		
		return event.getEventimage().size();
	}

	@Override
	public boolean isViewFromObject(View v, Object obj) {
		
		return v == obj;
	}
	@Override
	public int getItemPosition(Object object){
	     return POSITION_NONE;
	}

	@Override
	public Object instantiateItem(View pager, final int position) {
		
		View v = null;
		
		v = mInflater.inflate(R.layout.item_pvdetail, null);
		ImageView image = (ImageView) v.findViewById(R.id.image);
		
	
		
		Picasso.with(context)
		.load(event.getEventimage().get(position).getImage())
		.placeholder(R.drawable.temp)
		.into(image);
		
		
		
		((AutoScrollViewPager) pager).addView(v, null);
		
		return v;
	}
	
	@Override
	public void destroyItem(View pager, int position, Object view) {
		((AutoScrollViewPager) pager).removeView((View) view);
	}

}
