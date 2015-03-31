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
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NoticeListAdapter extends BaseExpandableListAdapter {

	
	List<Notice> data;
	Notice resultp;
	
	public NoticeListAdapter(List<Notice> arraylist){
		data = arraylist;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return data.get(groupPosition).getTitle();
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return data.get(groupPosition).getContent();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		final Context context = parent.getContext();
		
		TextView title = null;
		TextView date = null;
		ImageView arrow = null;
		CustomHolder holder = null;
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.item_noticelist, parent, false);
	        
	        title = (TextView) convertView.findViewById(R.id.title_notice);
	        date = (TextView) convertView.findViewById(R.id.date_notice);
	        arrow = (ImageView) convertView.findViewById(R.id.arrow);
	        
	        
	        holder = new CustomHolder();
	        holder.m_title = title;
	        holder.m_date = date;
	        holder.m_arrow = arrow;
	        convertView.setTag(holder);
		}
		else{
			holder = (CustomHolder) convertView.getTag();
			title = holder.m_title;
			date = holder.m_date;
			arrow = holder.m_arrow;
		}
		
		resultp = data.get(groupPosition);
		
		title.setText(resultp.getTitle());
		date.setText(resultp.getUpdated_at());
		
		if(isExpanded){
			
		}else{
			
		}
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		final Context context = parent.getContext();
		TextView content = null;
		CustomHolder holder = null;
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.item_noticecontent, parent, false);
	        content = (TextView) convertView.findViewById(R.id.notice_content);
	        holder = new CustomHolder();
	        holder.m_content = content;
	        convertView.setTag(holder);
		}
		else{
			holder = (CustomHolder) convertView.getTag();
			content = holder.m_content;
		}
		
		
		resultp = data.get(groupPosition);
		content.setText(resultp.getContent());
		
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private class CustomHolder{
		ImageView m_arrow;
		TextView m_title;
		TextView m_date;
		TextView m_content;
	}
}
