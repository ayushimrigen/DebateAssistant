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
public class PoliticsAndIRAP extends Activity {
	private InterstitialAd interstitial;
	
		String motions[] = {"TH regrets the Arab Spring",
				"This House would encourage the separation Muslims and Hindus in India",
				"THBT change comes through Molotov cocktails, not with a voting ballot",
				"THBT human shields are a legitimate tactic in war",
				"The house believes that to abstain is not democratic",
				"THBT the media should not report or comment upon terrorist incidents",
				"This House believes a democratic vote can only be legitimate if a majority of eligible voters take part",
				"This House believes Britain should join the Euro currency",
				"This House believes it is better to go for youthful dynamism over experience for political office",
				"THB the Protection of National Identity is a Legitimate Reason to Restrict Immigration",
				"This House believes the west should provide financial and military support to opposition groups in oppressive regimes",
				"This House believes a third world war is inevitable",
				"This House believes all nations have a right to nuclear weapons",
				"This House believes European NATO member governments should significantly reduce their armed forces",
				"This House believes NATO has succeeded in Afghanistan",
				"This House believes no election in Syria can be legitimate while Assad is a candidate",

				"This House believes only those who contribute more in taxes than they receive in benefits should vote",

				"This House believes Russia has the right to send troops into Crimea",

				"This house believes self-determination of peoples is a human right",

				"This house believes states are justified in waging war in response to terrorist acts",

				"This House believes that disbanding all militaries is necessary for global peace",

				"This House believes that drone strikes should be considered unlawful",

				"This House believes that elected representatives should not hold any additional posts while serving in government",

				"This House Believes Terrorism can be justified",

				"This House believes that firearms should be banned worldwide",

				"This House believes that governments should pay compensation for terrorist atrocities committed by their citizens",

				"This house believes that the benefits of war can outweigh the costs",

				"This house believes that the LGBT movement should not 'out' gay politicians that publicly profess homophobic views",

				"This House believes that violence can be a legitimate means of political expression",

				"This House believes the WHO should be able to overrule national agencies when responding to a pandemic",

				"This House favours a common EU foreign policy",
				"This House supports countries spying on each other",
				"This House believes that violent revolution is never justified",
				"This House believes the Arab Spring revolutions can create stable democracies. ",
				"This House would abolish the immunity of diplomats",
				"This house would allow prisoners to vote",
				"This House would consider a large scale cyber attack an act of war",
				"This House would introduce positive discrimination to put more women in parliament",
				"This House would let the Kashmiris decide whether to be a part of India or Pakistan",
				"This House would negotiate with terrorists",
				"This House would restrict the right to Habeas Corpus as part of efforts to combat terrorism",
				"This House would throw Russia out of the G8",
				"This House would use targeted sanctions to respond to cyber-attacks",
				"This House would use Unmanned Aerial Vehicles to strike terrorist targets",
				"THW ban negative political advertisements",
				"THW ban racist and extreme nationalist political parties",
				"THW pressure North Korea to come to a full armistice agreement with the UN",
				"THW ban private financing of election campaigns. ",
				"THW introduce compulsory military service",
				"THW shoot human shields used by the other side",
				"This House believes India is an idea, not just a country",
				"This House believes in a world government",
				"This House believes Jammu and Kashmir should be independent",
				"THBT, in countries with few female politicians, it is good to have a politically active first lady",
				"This House believes nations of the world should increase protection of the economic and social rights of migrants. ",
				"This House believes that the UN should restrict arms sales to rogue nations. ",
				"This house believes sanctions should be used to promote democracy",
				"This House believes that former colonial powers should pay reparations to former colonies",
				"This House believes that the United Nations has failed",
				"This House believes there needs to be more UN involvement in the post Arab spring Middle East",
				"This House prefers trade to aid",
				"This House would put taxes/revenue from oil into a trust fund independent of politicians influence",
				"THW prefer Chinese hegemony to American hegemony",
				"This House would stop sending development aid to India"
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
		final SharedPreferences prefs = this.getSharedPreferences("politicsandirap", Context.MODE_PRIVATE);
		final Editor edit=prefs.edit();
		edit.putInt("oldmot1", prefs.getInt("mot1",0));edit.putInt("mot1", a);
		edit.putInt("oldmot2", prefs.getInt("mot2",0));edit.putInt("mot2", b);
		edit.putInt("oldmot3", prefs.getInt("mot3",0));edit.putInt("mot3", c);
		edit.commit();
		
	}
	
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.motions_ap);
	       
	       interstitial = new InterstitialAd(PoliticsAndIRAP.this);
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
	      motiongenerator(motion1,motion2,motion3);final SharedPreferences prefs = this.getSharedPreferences("politicsandirap", Context.MODE_PRIVATE);
	       refresh.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent asian = new Intent("in.apeiro.debateassistant.POLITICSANDIRAP");
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