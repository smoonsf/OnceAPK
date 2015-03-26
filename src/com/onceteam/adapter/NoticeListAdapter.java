package com.onceteam.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.onceteam.once.DetailViewActivity;
import com.onceteam.once.MainActivity;
import com.onceteam.once.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NoticeListAdapter extends BaseAdapter {

	
	ArrayList<HashMap<String, String>> data;
	HashMap<String, String> resultp = new HashMap<String, String>();
	
	public NoticeListAdapter(ArrayList<HashMap<String, String>> arraylist){
		data = arraylist;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    final Context context = parent.getContext();
		
		TextView title = null;
		TextView date = null;
		CustomHolder holder = null;
		

		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.item_noticelist, parent, false);
	        
	        title = (TextView) convertView.findViewById(R.id.title_notice);
	        date = (TextView) convertView.findViewById(R.id.date_notice);
	        
	        holder = new CustomHolder();
	        holder.m_title = title;
	        holder.m_date = date;
	        convertView.setTag(holder);
		}
		else{
			holder = (CustomHolder) convertView.getTag();
			holder.m_title = title;
			holder.m_date = date;
		}
		
		resultp = data.get(position);
		
		title.setText(resultp.get("title"));
		date.setText(resultp.get("date"));
		
		convertView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, DetailViewActivity.class);
				// Pass all data title
				intent.putExtra("title", resultp.get("title"));
				// Pass all data content
				intent.putExtra("content", resultp.get("content"));
				// Pass all data date
				intent.putExtra("date", resultp.get("date"));
				// Start SingleItemView Class
				context.startActivity(intent);
			}
			
		});
		
		return convertView;
	}

	private class CustomHolder{
		TextView m_title;
		TextView m_date;
	}
}
