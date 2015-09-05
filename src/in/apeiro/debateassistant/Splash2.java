package in.apeiro.debateassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;import android.widget.Button;
import android.widget.ImageView;

public class Splash2 extends Activity{
	
	ImageView gear;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash2);
	
		
	initialisers();				
	
	Thread timer= new Thread()
	{
		public void run()
		{
			try
			{
				sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			finally{
				
				Intent openMenu= new Intent("in.apeiro.debateassistant.HOMESCREEN");
				startActivity(openMenu);
			}
		}
	};
	timer.start();
	}

	

private void initialisers() {
	// TODO Auto-generated method stub
	gear= (ImageView)findViewById(R.id.launch2);
}
}