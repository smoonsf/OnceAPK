package com.onceteam.adapter;

import java.util.List;

import com.onceteam.model.Event;
import com.onceteam.once.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	List<Event> data;
	Event resultp;

	public ListViewAdapter(List<Event> events) {
		data = events;
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

	public View getView(final int position, View convertView, ViewGroup parent) {
	    final Context context = parent.getContext();
		
		// Holder 패턴을 이용해서 뷰 넘겨주
		TextView title = null;
		TextView subtitle = null;
		TextView date = null;
		ImageView poster = null;
		CustomHolder holder = null;
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.item_listview, parent, false);
	        
	        title = (TextView) convertView.findViewById(R.id.title);
	        subtitle = (TextView) convertView.findViewById(R.id.subtitle);
	        date = (TextView) convertView.findViewById(R.id.date);
	        poster = (ImageView) convertView.findViewById(R.id.poster);
	        
	        holder = new CustomHolder();
	        holder.m_title = title;
	        holder.m_subtitle = subtitle;
	        holder.m_date = date;
	        holder.m_poster = poster;
	        convertView.setTag(holder);
		}
		else {
			holder = (CustomHolder)convertView.getTag();
			title = holder.m_title;
			subtitle = holder.m_subtitle;
			date = holder.m_date;
			poster = holder.m_poster;
		}
		

		resultp = data.get(position);

		
		title.setText(resultp.getTitle());
		subtitle.setText(resultp.getSubtitle());
		date.setText(resultp.getDate());
		
		Picasso.with(context)
				.load(resultp.getImage())
				.placeholder(R.drawable.temp)
				.into(poster);
		
		return convertView;
	}
	
	private class CustomHolder{
		TextView m_title;
		TextView m_subtitle;
		TextView m_date;
		ImageView m_poster;
	}
}
