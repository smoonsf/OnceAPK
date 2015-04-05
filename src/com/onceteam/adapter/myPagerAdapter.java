package com.onceteam.adapter;

import java.util.List;

import com.onceteam.model.Event;
import com.onceteam.once.DetailEventActivity;
import com.sinchontycoon.once.R;
import com.squareup.picasso.Picasso;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class myPagerAdapter extends PagerAdapter {

	private LayoutInflater mInflater;
	
	Context context;
	List<Event> data;
	Event resultp = new Event();
	
	public myPagerAdapter(Context c, List<Event> pl){
		context = c;
		mInflater = LayoutInflater.from(context);
		data = pl;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public boolean isViewFromObject(View v, Object obj) {
		// TODO Auto-generated method stub
		return v == obj;
	}
	
	@Override
	public int getItemPosition(Object object){
	     return POSITION_NONE;
	}
 
	@Override
	public Object instantiateItem(View pager, final int position) {
		View v = null;
		int resId = R.layout.item_pvlist;
		v = mInflater.inflate(resId, null);
		
		ImageView poster = (ImageView) v.findViewById(R.id.poster);
		
		resultp = data.get(position);
		
		Picasso.with(context)
		.load(resultp.getImage_pv())
		.placeholder(R.drawable.temp)
		.into(poster);
		
		v.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, DetailEventActivity.class);
				intent.putExtra("id", resultp.getId());
				context.startActivity(intent);
			}
		});
		
		((AutoScrollViewPager) pager).addView(v, null);
		
		return v;
	}
	
	@Override
	public void destroyItem(View pager, int position, Object view) {
		((AutoScrollViewPager) pager).removeView((View) view);
	}
}
