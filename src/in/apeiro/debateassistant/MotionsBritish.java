package in.apeiro.debateassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;import android.widget.Button;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
public class MotionsBritish extends Activity {
	private InterstitialAd interstitial;
	@Override
	   public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.theme_select_bp);
		
		 interstitial = new InterstitialAd(MotionsBritish.this);
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
	       
		Button education = (Button) findViewById(R.id.education);
		Button environment = (Button) findViewById(R.id.environment);
		Button freespeech = (Button) findViewById(R.id.freespeech);
		Button health = (Button) findViewById(R.id.health);
		Button law = (Button) findViewById(R.id.law);
		Button mixed = (Button) findViewById(R.id.mixed);
		Button politicsandir = (Button) findViewById(R.id.polandir);
		Button religion = (Button) findViewById(R.id.religion);
		Button society = (Button) findViewById(R.id.society);
		
		
		education.setOnClickListener(new View.OnClickListener() {
         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.EDUCATIONBP");
	   	           startActivity(format);		
	           }
	       });
		
		environment.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.ENVIRONMENTBP");
	   	           startActivity(format);		
	           }
	       });
		
		freespeech.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.FREESPEECHBP");
	   	           startActivity(format);		
	           }
	       });
		
		health.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.HEALTHBP");
	   	           startActivity(format);		
	           }
	       });
		
		law.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.LAWBP");
	   	           startActivity(format);		
	           }
	       });
		
		mixed.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.MIXEDBP");
	   	           startActivity(format);		
	           }
	       });
		
		politicsandir.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.POLITICSANDIRBP");
	   	           startActivity(format);		
	           }
	       });
		
		religion.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.RELIGIONBP");
	   	           startActivity(format);		
	           }
	       });
		
		society.setOnClickListener(new View.OnClickListener() {
	         
	           @Override
	           public void onClick(View view) {
	        	   Intent format = new Intent("in.apeiro.debateassistant.SOCIETYBP");
	   	           startActivity(format);		
	           }
	       });
		
		
	}

	public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}
}
