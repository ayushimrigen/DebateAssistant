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
public class HealthAP extends Activity {
	private InterstitialAd interstitial;
	
		String motions[] = {"THBT the beauty industry does more harm than good",
				"THBT the USA should increase funding to fight disease in developing nations",
				"This House believes that male infant circumcision is tantamount to child abuse",
				"This House believes that fast food restaurants bring more harm than good",
				"This House would allow parents to genetically screen foetuses for heritable diseases",
				"This House would allow pharmaceutical companies to advertise directly to consumers",
				"This house would ban cosmetic surgery",
				"THBT doctors should be allowed to change the sexual orientation of consenting subjects",
				"THBT the media should not publish news on suicides",
				"This House believes that cannabis should be legalized",
				"This House believes that we put too much faith in medical profession",
				"This House would allow donations of vital organs even at the expense of the donor's life",
				"This house would allow people to sell their organs on the open market",
				"This House would ban alcohol",
				"This House would make condom usage in the porn industry mandatory",
				"This House would send obese children to fat camp",
				"This House would grant those diagnosed with terminal illnesses the right to access treatments that have not completed clinical testing",
				"This House would legalize sex work",
				"This House would permit the use of performance enhancing drugs in professional sports",
				"THW compel doctors to reveal STDs to sexual partners of their patients",
				"THW force-feed anorexics"
};
		public void motiongenerator(TextView motion1,final  TextView motion2,final  TextView motion3)
		{
		int length= motions.length;
		
		Random r = new Random();
		int a = r.nextInt(length);
		int b=r.nextInt(length);
		while(b==a)
		{
			b=r.nextInt(length);
		}
		int c=r.nextInt(length);
		while(c==b || c==a)
		{
			c=r.nextInt(length);
		}
		
		motion1.setText(motions[a]);
		motion2.setText(motions[b]);
		motion3.setText(motions[c]);
		final SharedPreferences prefs = this.getSharedPreferences("healthap", Context.MODE_PRIVATE);
		final Editor edit=prefs.edit();
		edit.putInt("oldmot1", prefs.getInt("mot1",0));edit.putInt("mot1", a);
		edit.putInt("oldmot2", prefs.getInt("mot2",0));edit.putInt("mot2", b);
		edit.putInt("oldmot3", prefs.getInt("mot3",0));edit.putInt("mot3", c);
		edit.commit();
		
	}
	
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.motions_ap);
	       
	       interstitial = new InterstitialAd(HealthAP.this);
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
	       
	      final  TextView motion1 = (TextView) findViewById(R.id.motion1); Button refresh = (Button)findViewById(R.id.refresh);  final Button lastseen= (Button)findViewById(R.id.lastseen);  
	      final  TextView motion2 = (TextView) findViewById(R.id.motion2);
	      final  TextView motion3 = (TextView) findViewById(R.id.motion3);
	      motiongenerator(motion1,motion2,motion3);final SharedPreferences prefs = this.getSharedPreferences("healthap", Context.MODE_PRIVATE);
	       refresh.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent asian = new Intent("in.apeiro.debateassistant.HEALTHAP");
	   	           startActivity(asian);		
	           }
	       });
	       
	       lastseen.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   motion1.setText(motions[prefs.getInt("oldmot1",0)]);
		       		motion2.setText(motions[prefs.getInt("oldmot2",0)]);  
		       		motion3.setText(motions[prefs.getInt("oldmot3",0)]);  
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