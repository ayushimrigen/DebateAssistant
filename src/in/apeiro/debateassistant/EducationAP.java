package in.apeiro.debateassistant;



import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;import android.view.View;

import android.widget.Button;import android.widget.Button;
import android.widget.TextView;
import android.view.ViewManager;import android.widget.ToggleButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
public class EducationAP extends Activity {
	private InterstitialAd interstitial;
	
		String motions[] = {"THB universities everywhere should compete to attract the most qualified students, regardless of nationality or residence.",
				"THBT education systems should promote equality of outcome over equality of opportunity",
				"This House believes degrees in the creative arts are luxuries society can no longer afford",
				"This House believes literacy promotes peace",
				"This house believes poetry is an unnecessary burden for schools",
				"This House believes schools should use surveillance cameras",
				"This House believes students should take a gap year before college",
				"This House believes that Grade 3 students and below should be taught good manners",
				"This House believes that parents should be held responsible for their school-going children's discipline problems",
				"This House believes that teachers should not be allowed to strike. ",
				"THB that sex education classes should include sexual fetishes with the aim of normalising them",
				"THBT it is legitimate for nations to lie in history textbooks",
				"This house believes extra-curricular activities in schools should be formally recognised. ",
				"This House believes mixed gender residences are preferable over single sex residences at universities",
				"This House believes motivation is more important for success than intelligence",
				"This house believes schools should prohibit students from dating",
				"This House believes that examinations are a good way for measure competency",
				"This house believes that Mathematics should not be taught in school",
				"This House believes that the Internet increases students interest in studying",
				"This House believes the teaching of literary classics should be compulsory",
				"This House believes those who do not learn from history are destined to repeat it",
				"This House would abolish standardized tests for University Admission",
				"This House would ban faith schools. ",
				"This house would ban school students from having smart phones",
				"This house would ban schools from promoting a religion",
				"This House would eliminate grading at school",
				"This House would allow biased versions of history to be taught in schools",
				"This House would ban religious schools",
				"This house would bring back corporal punishment",
				"This House would make community service compulsory for all school students",
				"This House would make learning debate compulsory",
				"This House would make sex education mandatory in schools",
				"This House would require government schools to teach religious studies",
				"This House would subsidise the translation of academic work in the languages of developing countries",
				"This House would use positive discrimination to increase diversity in university",
				"THW introduce mandatory trips to Nazi concentration camps for Austrian elementary school students",
				"When paying teachers, THW take into account their students' academic performance",
				"This house would teach talented students separately from their peers",
				"This House would require university graduates to work in their country of origin for three years after graduation"
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
		 final SharedPreferences prefs = this.getSharedPreferences("educationap", Context.MODE_PRIVATE);
		final Editor edit=prefs.edit();
		edit.putInt("oldmot1", prefs.getInt("mot1",0));edit.putInt("mot1", a);
		edit.putInt("oldmot2", prefs.getInt("mot2",0));edit.putInt("mot2", b);
		edit.putInt("oldmot3", prefs.getInt("mot3",0));edit.putInt("mot3", c);
		edit.commit();
		
		
	}
	
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.motions_ap);
	       
	       interstitial = new InterstitialAd(EducationAP.this);
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
	       
	      final  TextView motion1 = (TextView) findViewById(R.id.motion1); Button refresh = (Button)findViewById(R.id.refresh);   final Button lastseen= (Button)findViewById(R.id.lastseen);  
	      final  TextView motion2 = (TextView) findViewById(R.id.motion2);
	      final  TextView motion3 = (TextView) findViewById(R.id.motion3);
	      motiongenerator(motion1,motion2,motion3); final SharedPreferences prefs = this.getSharedPreferences("educationap", Context.MODE_PRIVATE);
	       
	       refresh.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent asian = new Intent("in.apeiro.debateassistant.EDUCATIONAP");
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