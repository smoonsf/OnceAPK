package com.onceteam.adapter;

import java.util.List;

import com.onceteam.model.Notice;
import com.onceteam.once.DetailNoticeActivity;
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

	
	List<Notice> data;
	Notice resultp;
	
	public NoticeListAdapter(List<Notice> arraylist){
		data = arraylist;
	}
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
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
		
		title.setText(resultp.getTitle());
		date.setText(resultp.getUpdated_at());
		
		convertView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, DetailNoticeActivity.class);
				intent.putExtra("title", resultp.getTitle());
				intent.putExtra("date", resultp.getUpdated_at());
				intent.putExtra("content", resultp.getContent());
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
