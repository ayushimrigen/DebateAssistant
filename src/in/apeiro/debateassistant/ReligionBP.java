package in.apeiro.debateassistant;



import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.ViewManager;import android.widget.ToggleButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
public class ReligionBP extends Activity {
	private InterstitialAd interstitial;
	
		String motions[] = {"This House Would encourage the separation Muslims and Hindus in India",
				"TH regrets strong society norms in favour of monogamy",
				"This House believes that belief in God is irrational",
				"This house believes that the Catholic Church is justified in forbidding the use of barrier methods of contraception. ",
				"This House would (as a Christian Church) allow the ordination of gay and lesbian priests",
				"This House would ban religious symbols in public buildings",
				"This House would remove the requirement for Catholic Priests to take a vow of celibacy",
				"This House believes that marriage is an outdated institution",
				"This House would legally require priests to report serious crimes that they hear of in confessions",
				"This house would teach creationism in schools",
				"THW legalize multi-partner marriages for both men and women"};
		public void motiongenerator(TextView motion)
		{
		int length= motions.length;
		
		Random r = new Random();
		int a = r.nextInt(length);
		motion.setText(motions[a]);
		final SharedPreferences prefs = this.getSharedPreferences("religionbp", Context.MODE_PRIVATE);
		final Editor edit=prefs.edit();
		edit.putInt("oldmot1", prefs.getInt("mot1",0));edit.putInt("mot1", a);
		
		edit.commit();
	}
	
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.motions_bp);
	       
	       interstitial = new InterstitialAd(ReligionBP.this);
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
	       
	      final  TextView motion = (TextView) findViewById(R.id.motion); Button refresh = (Button)findViewById(R.id.refresh);  final Button lastseen= (Button)findViewById(R.id.lastseen);  
	       motiongenerator(motion);final SharedPreferences prefs = this.getSharedPreferences("religionbp", Context.MODE_PRIVATE);
	       refresh.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent asian = new Intent("in.apeiro.debateassistant.RELIGIONBP");
	   	           startActivity(asian);		
	           }
	       });
	       
	      
	       
	       lastseen.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   motion.setText(motions[prefs.getInt("oldmot1",0)]);
	       		
	        	((ViewManager)lastseen.getParent()).removeView(lastseen);
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