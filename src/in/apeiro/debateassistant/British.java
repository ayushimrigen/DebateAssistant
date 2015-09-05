package in.apeiro.debateassistant;


import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;import android.widget.Button;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewManager;import android.widget.ToggleButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
public class British extends Activity {
	private InterstitialAd interstitial;
	@Override
	   public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.motions_timer);
	       
		 interstitial = new InterstitialAd(British.this);
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
		Button motions = (Button) findViewById(R.id.motions);
		Button timer = (Button) findViewById(R.id.timer);
		
		motions.setOnClickListener(new View.OnClickListener() {
            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent motions = new Intent("in.apeiro.debateassistant.MOTIONSBP");
	   	           startActivity(motions);		
	           }
	       });
		
		timer.setOnClickListener(new View.OnClickListener() {
            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent timer = new Intent("in.apeiro.debateassistant.PREPTIMEBP");
	   	           startActivity(timer);		
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
