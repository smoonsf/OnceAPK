package com.onceteam.json;

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
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public ListViewAdapter(Context context,
			ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables
		TextView id;
		TextView subtitle;
		TextView date;
		ImageView poster;

		inflater = LayoutInflater.from(context);

		View itemView = inflater.inflate(R.layout.item_listview, parent, false);
		// Get the position
		resultp = data.get(position);

		// Locate the TextViews in item_listview.xml
		id = (TextView) itemView.findViewById(R.id.id);
		subtitle = (TextView) itemView.findViewById(R.id.subtitle);
		date = (TextView) itemView.findViewById(R.id.date);

		// Locate the ImageView in item_listview.xml
		poster = (ImageView) itemView.findViewById(R.id.poster);

		// Capture position and set results to the TextViews
		id.setText(resultp.get(MainActivity.ID));
		subtitle.setText(resultp.get(MainActivity.SUBTITLE));
		date.setText(resultp.get(MainActivity.DATE));
		// Capture position and set results to the ImageView
		// Passes poster images URL into ImageLoader.class
		imageLoader.DisplayImage(resultp.get(MainActivity.POSTER), poster);
		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);
				Intent intent = new Intent(context, DetailViewActivity.class);
				// Pass all data id
				intent.putExtra("id", resultp.get(MainActivity.ID));
				// Pass all data subtitle
				intent.putExtra("subtitle", resultp.get(MainActivity.SUBTITLE));
				// Pass all data date
				intent.putExtra("date", resultp.get(MainActivity.DATE));
				// Pass all data poster
				intent.putExtra("poster", resultp.get(MainActivity.POSTER));
				// Start SingleItemView Class
				context.startActivity(intent);

			}
		});
		return itemView;
	}
}
