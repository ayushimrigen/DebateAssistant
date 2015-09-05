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
public class EnvironmentBP extends Activity {
	private InterstitialAd interstitial;
	
		String motions[] = {"THBT developed countries should fund projects to mitigate the impact of climate change in developing countries",
				"This House believes global warming can still be prevented",
				"This House believes hydroelectric dams to be a part of the solution to global warming",
				"This House believes subsidies on fuel should be eliminated",
				"This house believes that developed countries have a higher obligation to combat climate change than developing countries",
				"This house believes that nuclear energy must be stopped. ",
				"This House would ban animal testing",
				"This House would ban gold mining",
				"This House believes Ethiopia is right to build a dam on the River Nile",
				"This house Believes People Should Not Keep Pets",
				"This House believes that countries affected by haze should pay Indonesia to stop slash and burn agriculture",
				"This House believes we're too late on global climate change",
				"This house believes that states should not subsidise the growing of tobacco",
				"This House believes that violent action to defend our environment is justified",
				"This House Does Not Trust the Market for Improvements in Energy Standards. ",
				"This House supports the use of genetically engineered plants in developing countries",
				"This House would ban flying for leisure purposes",
				"This house would ban private car ownership and would compel citizens to use the public eco friendly vehicles",
				"This House would cycle to work",
				"This House would give refugee status to environmental or climate refugees",
				"This House would put a lower tax on organic food in restaurants",
				"This house would encourage offshore drilling",
				"This House would pay the poor not to have children",
				"This House would subsidize renewable sources of energy",
				"THW use carbon capture and storage to curb carbon dioxide emissions from fossil fuels"};
		public void motiongenerator(TextView motion)
		{	
		int length= motions.length;
		
		Random r = new Random();
		int a = r.nextInt(length);
		motion.setText(motions[a]);
		final SharedPreferences prefs = this.getSharedPreferences("environmentbp", Context.MODE_PRIVATE);
		final Editor edit=prefs.edit();
		edit.putInt("oldmot1", prefs.getInt("mot1",0));edit.putInt("mot1", a);
		edit.commit();
	}
	
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.motions_bp);
	       
	       interstitial = new InterstitialAd(EnvironmentBP.this);
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
	       motiongenerator(motion);final SharedPreferences prefs = this.getSharedPreferences("environmentbp", Context.MODE_PRIVATE);
	       refresh.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent asian = new Intent("in.apeiro.debateassistant.ENVIRONMENTBP");
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