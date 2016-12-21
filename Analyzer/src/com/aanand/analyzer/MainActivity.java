package com.aanand.analyzer;

import java.util.List;

import com.aanand.analyzer.utility.AnalyzerMainUtility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private Spinner categorySpinner;
	private EditText statusText;
	private Button saveBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<String> categories = AnalyzerMainUtility.getCategories(this.getApplicationContext());
		categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
		statusText = (EditText) findViewById(R.id.statusEditText);
		saveBtn = (Button) findViewById(R.id.button1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.simple_spinner_item, categories);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter);
		saveBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String category = categorySpinner.getSelectedItem().toString();
				String status = statusText.getText().toString();
				if (status == null || "".equals(status.trim())) {
					statusText.setError("Please enter some value");
					return;
				}
				try {
					AnalyzerMainUtility.saveCategorySatus(category, status, getApplicationContext());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.showData) {
			Intent intent = new Intent(this, ShowData.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
