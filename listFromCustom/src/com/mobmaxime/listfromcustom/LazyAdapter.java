package com.mobmaxime.listfromcustom;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {

	Context context;
	List<createRow> rowItems;

	public LazyAdapter(Context applicationContext, List rowItems) {
		// TODO Auto-generated constructor stub
		this.context = applicationContext;
		this.rowItems = rowItems;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return rowItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return rowItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return rowItems.indexOf(getItem(position));
	}

	private class ViewHolder {
		TextView name;
		TextView screenname;
		TextView ProfileBanner;
		TextView description;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder = null;
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			// convertView = mInflater.inflate(
			// R.layout.mention_timeline_listitems, null);

			convertView = mInflater.inflate(R.layout.list_row, null);
			holder = new ViewHolder();
			holder.description = (TextView) convertView
					.findViewById(R.id.description);
			holder.name = (TextView) convertView.findViewById(R.id.title);
			holder.screenname = (TextView) convertView.findViewById(R.id.screenname);

			convertView.setTag(holder);
		} else{
			holder = (ViewHolder) convertView.getTag();
		}

		createRow rowItem = (createRow) getItem(position);

		holder.description.setText(rowItem.getDescription());
		holder.name.setText(rowItem.getName());
		holder.screenname.setText(rowItem.getScreenname());
		return convertView;

	}

}
