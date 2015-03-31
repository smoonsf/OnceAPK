package com.onceteam.adapter;

import com.onceteam.once.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {
	Context context;
	String[] arrayData;
	LayoutInflater minf;
	int resource;
	int mFieldId;
	
	public DrawerAdapter(Context ctx, int rId, int mFId, String[] arrayD){
		context = ctx;
		arrayData = arrayD;
		resource = rId;
		mFieldId = mFId;
	}
	
	@Override
	public boolean isEnabled(int position) {
//		if(position==7)
//			return false;
		return true;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayData.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrayData[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView text = null;
		ImageView logo = null;
		CustomHolder holder = null;
		minf = LayoutInflater.from(context);
		
		
		
		if(convertView == null){
			convertView = minf.inflate(resource, parent, false);
			text = (TextView) convertView.findViewById(mFieldId);
			logo = (ImageView) convertView.findViewById(R.id.logo);
			holder = new CustomHolder();
			holder.m_text=text;
			holder.m_logo=logo;
			convertView.setTag(holder);
			
		} else{
			holder = (CustomHolder) convertView.getTag();
			text = holder.m_text;
			logo = holder.m_logo;
			
		}
		
		
		RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) logo.getLayoutParams();
		if(position==0){
			params.width = 270;
			params.height = 270;
			logo.setImageResource(R.drawable.once_logo);
			logo.setLayoutParams(params);

		}
		
		text.setText(arrayData[position]);
		
		
		convertView.setPadding(120, 30, 30, 30);
		text.setTextSize(20);
		text.setTextColor(Color.parseColor("#A6A9AB"));
		
		
		return convertView;
	}
	
	private class CustomHolder{
		TextView m_text;
		ImageView m_logo;
	}
	
}
