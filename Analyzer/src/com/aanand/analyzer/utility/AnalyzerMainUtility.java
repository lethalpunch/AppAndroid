package com.aanand.analyzer.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.Context;

public class AnalyzerMainUtility {

	public static List<String> getCategories(Context appContext) {
		List<String> categories = new ArrayList<String>();
		File file = new File(appContext.getFilesDir(), "/Categories.DAT");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String category = null;
			while ((category = br.readLine()) != null) {
				categories.add(category);
			}
			System.out.println("File Exists..................");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (categories.isEmpty()) {
			categories.add("Data Structure and Algorithms");
		}
		return categories;
	}

	public static void saveCategorySatus(String category, String status, Context appContext) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String toWrite = category + "||" + status + "||" + sdf.format(Calendar.getInstance().getTime());
		File file = new File(appContext.getFilesDir(), "/SaveCategory.DAT");
		if (!file.exists()) {
			file.createNewFile();
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		bw.newLine();
		bw.append(toWrite);
		bw.close();
	}

	public static ArrayList<String> getCategoryDataForView(Context context) {
		// TODO Auto-generated method stub
		ArrayList<String> dataList = new ArrayList<String>();
		File file = new File(context.getFilesDir(), "/SaveCategory.DAT");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String str = null;
			while ((str = br.readLine()) != null) {
				dataList.add(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

}
