package com.aanand.analyzer;

import java.util.ArrayList;

import com.aanand.analyzer.adaptor.GridItemViewAdapter;
import com.aanand.analyzer.utility.AnalyzerMainUtility;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;

public class ShowData extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.id.showData);
	    ArrayList<String> dataList = AnalyzerMainUtility.getCategoryDataForView(getApplicationContext());
	    Adapter adapter = new GridItemViewAdapter(dataList, getApplicationContext());
	    GridView gv= (GridView) findViewById(R.id.dataView);
	    gv.setAdapter((ListAdapter) adapter);
	    // TODO Auto-generated method stub
	}

}
