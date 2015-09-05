package in.apeiro.debateassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;import android.widget.Button;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.ViewManager;import android.widget.ToggleButton;

 

public class TimerAsian extends Activity {

 

   

   

    CountDownTimer timekeeper; boolean isrunning=false;

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       setContentView(R.layout.timer_ap); 

 
       
       

 
       final TextView title =(TextView) findViewById(R.id.title);
       final TextView timer = (TextView)findViewById(R.id.timer);
       final Button prev = (Button) findViewById(R.id.prev);
       final Button next = (Button) findViewById(R.id.next);
       
 

       timer.setOnClickListener(new View.OnClickListener() {
//
// 
//
          public void onClick(View view) {

        	  Log.i("onToggleClicked", "ToggleClick Event Started");
        	  
        	  boolean on = ((ToggleButton) view).isChecked();
        	  if (on) {
      	    	Log.i("onToggleIsChecked", "ToggleClick Is On"); isrunning=true;
 
        timekeeper = new CountDownTimer(600000, 1000) {

   	     public void onTick(long millisUntilFinished) {
   	    	 int millisec,sec,min;
   	    	 millisec=(int)(10*60*1000.0 - millisUntilFinished);
   	    	 sec=millisec/1000;
   	    	 min=sec/60;
   	    	 sec=sec%60;
   	    	 
   	    	 if(sec<10)
   	    		timer.setText(Integer.toString( min) + ":0" + Integer.toString(sec));
   	    	 else
   	         timer.setText(Integer.toString( min) + ":" + Integer.toString(sec));
   	     }

   	     public void onFinish() {
   	    	 //Game over
   	    	
   	    
             		//Intent easy= new Intent("com.example.mathbomb.ARCADEMEDIUMGO");
             		//easy.putExtra("score", Integer.toString(score));
        	        //   startActivity(easy);
   	     }
   	  }.start();
        	  }
        	  
        	  else
        	  {
        		  
        		  Log.i("onToggleIsChecked", "ToggleClick Is Off"); isrunning=false;
        		  if (isrunning==true) timekeeper.cancel();
        		  timer.setText("0:00");
        	  }
 
         }
          
          

       });
       
     
       
    }
    

 
    	
  
 

}
