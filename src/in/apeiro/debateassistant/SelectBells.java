package in.apeiro.debateassistant;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;import android.widget.Button;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.ViewManager;import android.widget.ToggleButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class SelectBells extends Activity {

	private InterstitialAd interstitial;

	   

	   
	 public void onCreate(Bundle savedInstanceState) {

	        super.onCreate(savedInstanceState);

	       setContentView(R.layout.selectbells); 

	       interstitial = new InterstitialAd(SelectBells.this);
			// Insert the Ad Unit ID
			interstitial.setAdUnitId("ca-app-pub-4877332868062678/4193803340");

			//Locate the Banner Ad in activity_main.xml
			AdView adView = (AdView) this.findViewById(R.id.adView);

			// Request for Ads
			AdRequest adRequest = new AdRequest.Builder()

			// Add a test device to show Test Ads
			// .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
			 //.addTestDevice("CC5F2C72DF2B356BBF0DA198")
					.build();

			// Load ads into Banner Ads
			adView.loadAd(adRequest);

			// Load ads into Interstitial Ads
			interstitial.loadAd(adRequest);

			// Prepare an Interstitial Ad Listener
			interstitial.setAdListener(new AdListener() {
				public void onAdLoaded() {
					// Call displayInterstitial() function
					displayInterstitial();
				}
			});
	       
			CheckBox two = (CheckBox) findViewById(R.id.two);
			CheckBox three = (CheckBox) findViewById(R.id.three);
			CheckBox four = (CheckBox) findViewById(R.id.four);
			CheckBox five = (CheckBox) findViewById(R.id.five);
			final SharedPreferences prefs = this.getSharedPreferences("selectbells", Context.MODE_PRIVATE);
			final Editor edit=prefs.edit();
			two.setOnClickListener(new View.OnClickListener() {
		           
		           @Override
		           public void onClick(View view) {
		                //is chkIos checked?
				if (((CheckBox) view).isChecked()) {
					 
						edit.putInt("Two", 1);
				}
				
				else
				{
					edit.putInt("Two", 0);
				}
				}
		 
			  
			});
	       
			three.setOnClickListener(new View.OnClickListener() {
		           
		           @Override
		           public void onClick(View view) {
		                //is chkIos checked?
				if (((CheckBox) view).isChecked()) {
					 
						edit.putInt("Three", 1);
				}
				
				else
				{
					edit.putInt("Three", 0);
				}
				}
		 
			  
			});
			
			four.setOnClickListener(new View.OnClickListener() {
		           
		           @Override
		           public void onClick(View view) {
		                //is chkIos checked?
				if (((CheckBox) view).isChecked()) {
					 
						edit.putInt("Four", 1);
				}
				
				else
				{
					edit.putInt("Four", 0);
				}
				}
		 
			  
			});
			
			five.setOnClickListener(new View.OnClickListener() {
		           
		           @Override
		           public void onClick(View view) {
		                //is chkIos checked?
				if (((CheckBox) view).isChecked()) {
					 
						edit.putInt("Five", 1);
				}
				
				else
				{
					edit.putInt("Five", 0);
				}
				}
		 
			  
			});
			
			edit.commit();
	 }
	 public void displayInterstitial() {
			// If Ads are loaded, show Interstitial else show nothing.
			if (interstitial.isLoaded()) {
				interstitial.show();
			}
	 }
	      
	 
}
