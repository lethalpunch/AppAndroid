package com.aanand.analyzer.adaptor;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.aanand.analyzer.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridItemViewAdapter extends BaseAdapter {
	private ArrayList<String> data;
	LayoutInflater inflater;
	Context context;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = this.inflater.inflate(R.layout.grid_item_view, null);
		}
		TextView firstTextView = (TextView) convertView.findViewById(R.id.categoryTextView);
		TextView secondTextView = (TextView) convertView.findViewById(R.id.dateTextView);
		TextView thirdTextView = (TextView) convertView.findViewById(R.id.effortTextView);
		
		String strToShow = this.data.get(position);
		if (strToShow != null && !strToShow.trim().equals("")) {
			String[] valArr = strToShow.split(Pattern.quote("||"));
			if (valArr.length != 3) {
				return null;
			}
			firstTextView.setText(valArr[0]);
			secondTextView.setText(valArr[1]);
			thirdTextView.setText(valArr[2]);
			return convertView;
		}
		return null;
	}

	/**
	 * @param data
	 * @param context
	 */
	public GridItemViewAdapter(ArrayList<String> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	

}
