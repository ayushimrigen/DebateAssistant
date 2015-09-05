package in.apeiro.debateassistant;


import android.app.Activity;
import android.app.Dialog;
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
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewManager;import android.widget.ToggleButton;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

 

public class PrepTimeBp extends Activity {

	private InterstitialAd interstitial;
	final Context context= this;
	   

   long ms=0;

   

    CountDownTimer timekeeper; 
    
    
   
    public final void settime(final long millidone,final TextView timer, final SharedPreferences prefs,final MediaPlayer singletap,final MediaPlayer doubletap,final MediaPlayer tripletap)
	   {
		  
		   
		   timekeeper = new CountDownTimer(900000, 1000) {
				
		   	     public void onTick(long millisUntilFinished) {
		   	    	 int millisec,sec,min;
		   	    	 millisec=(int)(15*60*1000.0 - millisUntilFinished + millidone);
		   	    	 sec=millisec/1000;
		   	    	 min=sec/60;
		   	    	 sec=sec%60;
		   	    	 ms=millisec;
		   	    	if((min==15)&&(sec==0))
		   	    		tripletap.start();
		   	    	
		   	    	 
		   	    	 if(sec<10)
		   	    		timer.setText(Integer.toString( min) + ":0" + Integer.toString(sec));
		   	    	 else
		   	         timer.setText(Integer.toString( min) + ":" + Integer.toString(sec));
		   	    	
		   	     }
		   	     
		   	  public void onFinish() {
		   	    	 timer.setText("15:00");
		   	    	 timekeeper.cancel();
		   	     }
		   	  }.start();
	   }


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       setContentView(R.layout.timer_ap); 

       interstitial = new InterstitialAd(PrepTimeBp.this);
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
       
       
    
      
 
       final TextView title =(TextView) findViewById(R.id.title);
       final TextView timer = (TextView)findViewById(R.id.timer);
       final Button prev = (Button) findViewById(R.id.prev);
       final Button next = (Button) findViewById(R.id.next);
       
       final Button selectbell = (Button) findViewById(R.id.selectbell);
       final Button bell = (Button) findViewById(R.id.bell);
       final Button resume = (Button) findViewById(R.id.resume);
       final Button pause = (Button) findViewById(R.id.pause);
       final Button reset = (Button) findViewById(R.id.reset);
       final Button start = (Button) findViewById(R.id.start);
       final SharedPreferences prefs = this.getSharedPreferences("selectbells", Context.MODE_PRIVATE);
       final Editor edit= prefs.edit();
      
    final LinearLayout view=(LinearLayout) findViewById(R.layout.timer_ap); edit.putInt("timeron",0); edit.commit();
      
       
      selectbell.setText(" ");
      bell.setText(" ");
       title.setText("Preparation Time");
       prev.setText("Home");
       next.setText("Prime Minister");
       final MediaPlayer singletap = MediaPlayer.create(this, R.raw.singletap);
       final MediaPlayer doubletap = MediaPlayer.create(this, R.raw.doubletap);
       final MediaPlayer tripletap = MediaPlayer.create(this, R.raw.tripletap);

       start.setOnClickListener(new View.OnClickListener() {
//
// 
    	   
    	
//
          public void onClick(View view) {

        	
      	    	
      	    	edit.putInt("timeron",1); edit.commit();
      	    	
 
      	    	settime(0,timer,prefs,singletap,doubletap,tripletap);
      	    	ms=0;
      	    	pause.setText("Pause");
      	    	reset.setText("Reset");
      	    	resume.setText("Resume");
      	    	((ViewManager)start.getParent()).removeView(start);
        	
 
         }
          
          

       });
       
       next.setOnClickListener(new View.OnClickListener() {
           
           @Override
           public void onClick(View view) {
        	   
        	   Intent motions = new Intent("in.apeiro.debateassistant.BPPM");
   	           startActivity(motions);	if(prefs.getInt("timeron",0)==1) timekeeper.cancel();	
           }
       });
       prev.setOnClickListener(new View.OnClickListener() {
           
           @Override
           public void onClick(View view) {
        	   
        	   Intent motions = new Intent("in.apeiro.debateassistant.BRITISH");
   	           startActivity(motions);		if(prefs.getInt("timeron",0)==1) timekeeper.cancel();
           }
       });
       
       
 reset.setOnClickListener(new View.OnClickListener() {
           
           @Override
           public void onClick(View view) {
        	   
        	  timekeeper.cancel();
        	  timer.setText("0:00");
        	 ms=0;
        	 edit.putInt("timeron",0); edit.commit();
           }
       });
 
 resume.setOnClickListener(new View.OnClickListener() {
     
     @Override
     public void onClick(View view) {
    	 timekeeper.cancel();
  	   settime(ms,timer,prefs,singletap,doubletap,tripletap);
  	 edit.putInt("timeron",1); edit.commit();
     }
 });
 
 pause.setOnClickListener(new View.OnClickListener() {
     
     @Override
    
     public void onClick(View view) {
  	   timekeeper.cancel();
  	 edit.putInt("timeron",0); edit.commit();
     }
 });
       
      
       

    
    } 
    
    
   
    public void onBackPressed()
	{
    	final SharedPreferences prefs = this.getSharedPreferences("selectbells", Context.MODE_PRIVATE);
		if(prefs.getInt("timeron",0)==1) timekeeper.cancel();
		this.finish();

	}
    	
    public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}
    
   
}



