package com.onceteam.adapter;

import java.util.List;

import com.onceteam.model.Event;
import com.onceteam.once.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
	
	public int getItemPosition(Object object){
	     return POSITION_NONE;
	}
 
	
	public Object instantiateItem(View pager, final int position) {
		View v = null;
		int resId = R.layout.item_pvlist;
		v = mInflater.inflate(resId, null);
		
		TextView title = (TextView) v.findViewById(R.id.title);
		TextView subtitle = (TextView) v.findViewById(R.id.subtitle);
		TextView date = (TextView) v.findViewById(R.id.date);
		ImageView poster = (ImageView) v.findViewById(R.id.poster);
		
		resultp = data.get(position);
		
		title.setText(resultp.getTitle());
		subtitle.setText(resultp.getSubtitle());
		date.setText(resultp.getDate());
		
		Picasso.with(context)
		.load(resultp.getImage_pv())
		.placeholder(R.drawable.temp)
		.into(poster);
		
		((ViewPager) pager).addView(v, null);
		
		return v;
	}
	
	public void destroyItem(View pager, int position, Object view) {
		((ViewPager) pager).removeView((View) view);
	}
}
