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
public class LawBP extends Activity {
	private InterstitialAd interstitial;
	
		String motions[] = {"THB it is legitimate to use violence to defend private property",
				"This House believes criminal justice should focus more on rehabilitation. ",
				"This house believes homosexuality should be decriminalized",
				"This House believes parents should have the right to track their children",
				"This House believes that drone strikes should be considered unlawful",
				"This house believes in a right to self-defense",
				"This House believes that to achieve freedom some human rights can be violated",
				"This House would allow prisoners to choose death over life imprisonment",
				"This House would close Guantanamo Bay detention centre",
				"This House would as the United States ban assault weapons",
				"This House would ban the pardoning of those convicted of corruption",
				"This House would make fines relative to income",
				"This House believes the ICC (International Criminal Court) is biased against Africa",
				"This House believes the ICC(International Criminal Court) should have its own enforcement arm",
				"This House would legally require priests to report serious crimes that they hear of in confessions",
				"This House would use torture to obtain information from suspected terrorists"};
		public void motiongenerator(TextView motion)
		{	
		int length= motions.length;
		
		Random r = new Random();
		int a = r.nextInt(length);
		motion.setText(motions[a]);
		final SharedPreferences prefs = this.getSharedPreferences("lawbp", Context.MODE_PRIVATE);
		final Editor edit=prefs.edit();
		edit.putInt("oldmot1", prefs.getInt("mot1",0));edit.putInt("mot1", a);
		edit.commit();
	}
	
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.motions_bp);
	       
	       interstitial = new InterstitialAd(LawBP.this);
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
	       motiongenerator(motion);final SharedPreferences prefs = this.getSharedPreferences("lawbp", Context.MODE_PRIVATE);
	       refresh.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent asian = new Intent("in.apeiro.debateassistant.LAWBP");
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