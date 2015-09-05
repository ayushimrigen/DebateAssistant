package in.apeiro.debateassistant;

import android.app.Activity;
import android.os.Bundle;import android.widget.Button;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
 

public class TimeAp extends Activity {
	private InterstitialAd interstitial;
 

    private Button next;

    private Button prev;

 
    private TextView title;
    private Button timer;

 

    private long startTime = 0L;

 

    private Handler customHandler = new Handler();

 

    long timeInMilliseconds = 0L;

    long timeSwapBuff = 0L;

    long updatedTime = 0L;

 

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       setContentView(R.layout.timer_ap); 

       interstitial = new InterstitialAd(TimeAp.this);
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

       

 
        title =(TextView) findViewById(R.id.title);
        timer = (Button) findViewById(R.id.timer);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);

 

        timer.setOnClickListener(new View.OnClickListener() {

 

            public void onClick(View view) {

                startTime = SystemClock.uptimeMillis();

                customHandler.postDelayed(updateTimerThread, 0);

 

            }

        });

 

     
 

    }

 

    private Runnable updateTimerThread = new Runnable() {

 

        public void run() {

 

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

 

            updatedTime = timeSwapBuff + timeInMilliseconds;

 

            int secs = (int) (updatedTime / 1000);

            int mins = secs / 60;

            secs = secs % 60;

            int milliseconds = (int) (updatedTime % 1000);

            timer.setText("" + mins + ":"

                    + String.format("%02d", secs) + ":"

                    + String.format("%03d", milliseconds));

            customHandler.postDelayed(this, 0);

        }

 

    };

    public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}

}
