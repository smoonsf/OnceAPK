package com.onceteam.once;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
		
		TextView text;
		minf = LayoutInflater.from(context);
		View itemView;
		
		
		if(convertView == null){
			itemView = minf.inflate(resource, parent, false);
		} else{
			itemView = convertView;
		}
		
		text = (TextView) itemView.findViewById(mFieldId);
		text.setText(arrayData[position]);
		if(position == 1){
			text.setPadding(10,10,10,10);
			text.setTextSize(16);
			text.setTypeface(null, Typeface.ITALIC);
			text.setTextColor(Color.parseColor("#8F8F8F"));
		} else if(position == 2 || position == 3 || position == 4){
			itemView.setPadding(45, 25, 25, 25);
			text.setTextSize(20);
		} else {
			itemView.setPadding(30, 30, 30, 30);
			text.setTextSize(25);
			
		}
		
		
		
		return itemView;
	}

}
