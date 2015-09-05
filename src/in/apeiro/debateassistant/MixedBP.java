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
public class MixedBP extends Activity {
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
				"This House would require university graduates to work in their country of origin for three years after graduation",
				"THBT developed countries should fund projects to mitigate the impact of climate change in developing countries",
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
				"THW use carbon capture and storage to curb carbon dioxide emissions from fossil fuels",
				"This House believes access to the internet should be controlled",
				"This House believes the BBC should be free to blaspheme",
				"This House believes the imprisoned members of Pussy Riot should be considered political prisoners",
				"This House Supports India’s Ban on the Satanic Verses",
				"This House would allow celebrities to switch off the limelight",
				"This House would offer amnesty to bloggers currently prosecuted by their native states",
				"This House would show the darker side of the formation of the nation",
				"This House believes a nation's history and mythology is part of its national security",
				"This House believes in the Right to be forgotten",
				"This House Believes NSA Spying was Justified",
				"This House believes that it is sometimes right for the government to restrict freedom of speech",
				"This House believes that rumours about politicians should not be reported",
				"This House believes the expenditure of money should be protected as speech. ",
				"This House believes you have nothing to worry about surveillance if you have done nothing wrong. ",
				"This House would ban music containing lyrics that glorify violent and criminal lifestyles",
				"This House would regulate the press",
				"THBT the beauty industry does more harm than good",
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
				"THW force-feed anorexics",
				"THB it is legitimate to use violence to defend private property",
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
				"This House would use torture to obtain information from suspected terrorists",
				"TH regrets the Arab Spring",
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
				"This House would stop sending development aid to India",
				"This House Would encourage the separation Muslims and Hindus in India",
				"TH regrets strong society norms in favour of monogamy",
				"This House believes that belief in God is irrational",
				"This house believes that the Catholic Church is justified in forbidding the use of barrier methods of contraception. ",
				"This House would (as a Christian Church) allow the ordination of gay and lesbian priests",
				"This House would ban religious symbols in public buildings",
				"This House would remove the requirement for Catholic Priests to take a vow of celibacy",
				"This House believes that marriage is an outdated institution",
				"This House would legally require priests to report serious crimes that they hear of in confessions",
				"This house would teach creationism in schools",
				"THW legalize multi-partner marriages for both men and women",
				"This House believes that Facebook is a reflection of urban loneliness",
				"This House believes mixed gender residences are preferable over single sex residences at universities",
				"This House believes that countries with an imbalanced male/female ratio skewed towards males should encourage parents to produce girls",
				"This House believes African cities need to invest more in housing to replace slums",
				"This House believes men should do half the cooking",
				"This House believes that cannabis should be legalized",
				"This House believes that the EU should offer asylum to women from countries which have legislation that discriminates against women. ",
				"This House believes that the people's republic of China should abandon the one-child policy",
				"This house regrets the rise of teen idols",
				"This House would ban the burqa",
				"This House believes that the feminist movement should seek a ban on pornography"
};
		public void motiongenerator(TextView motion)
		{
		int length= motions.length;
		
		Random r = new Random();
		int a = r.nextInt(length);
		motion.setText(motions[a]);
		final SharedPreferences prefs = this.getSharedPreferences("mixedbp", Context.MODE_PRIVATE);
		final Editor edit=prefs.edit();
		edit.putInt("oldmot1", prefs.getInt("mot1",0));edit.putInt("mot1", a);
		edit.commit();
	}
	
	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.motions_bp);
	       
	       interstitial = new InterstitialAd(MixedBP.this);
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
	       motiongenerator(motion);final SharedPreferences prefs = this.getSharedPreferences("mixedbp", Context.MODE_PRIVATE);
	       refresh.setOnClickListener(new View.OnClickListener() {
	            
	           @Override
	           public void onClick(View view) {
	        	   
	        	   Intent asian = new Intent("in.apeiro.debateassistant.MIXEDBP");
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