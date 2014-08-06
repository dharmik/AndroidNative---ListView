package com.mobmaxime.listfromcustom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mobmaxime.listfromcustom.R.id;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	protected static final int BUTTON_POSITIVE = 0;
	Button singleBtn, doubleBtn, multipleBtn;
	Context appContext;
	private ListView listView;

	final Context context = this;
	List<createRow> rowItems;
	LazyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.list_item);
		
		rowItems = new ArrayList<createRow>();

		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(
					getAssets().open("NewData.json")));
			String line = bReader.readLine();
			Log.e("line---->", line.toString());
			try {

				JSONObject listLength = new JSONObject(line);
				JSONArray data = listLength.getJSONArray("List");
				Log.d("Hi---->", data.length() + "");

				for (int i = 0; i < data.length(); i++) {
					String Name = null, screenname = null, ProfileBanner = null, description = null;

					JSONObject content = data.getJSONObject(i);
					JSONArray subdata = content.getJSONArray("recent");

					Log.d("subdata---->", subdata.length() + "");

					Name = content.getString("Name");
					screenname = content.getString("screenname");
					ProfileBanner = content.getString("ProfileBanner");
					description = content.getString("description");
					
					Log.d("name", Name);
					Log.d("screenname", screenname);
					Log.d("profileBanner", ProfileBanner);
					Log.d("description", description);

					rowItems.add(new createRow(Name, screenname, ProfileBanner, description));

				}

				adapter = new LazyAdapter(getApplicationContext(), rowItems);

				listView.setAdapter(adapter);
				//adapter.notifyDataSetChanged();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}

	}

	private ListView findViewById(Class<id> class1) {
		// TODO Auto-generated method stub
		return null;
	}
}