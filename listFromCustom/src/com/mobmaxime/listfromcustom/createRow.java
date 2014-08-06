package com.mobmaxime.listfromcustom;

import android.util.Log;

public class createRow {

	private String name;
	private String screenname;
	private String profileBanner;
	private String description;

	public createRow(String name, String screenname, String profileBanner,
			String description) {
		Log.d("name", name);
		Log.d("screenname", screenname);
		Log.d("profileBanner", profileBanner);
		Log.d("description", description);
		
		this.description = description;
		this.name = name;
		this.profileBanner = profileBanner;
		this.screenname = screenname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public String getProfileBanner() {
		return profileBanner;
	}

	public void setProfileBanner(String profileBanner) {
		this.profileBanner = profileBanner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return screenname + "\n" + profileBanner + "\n"+ description;
	}

}
