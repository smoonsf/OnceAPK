package com.onceteam.once;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_splash);
	    final ImageView logo = (ImageView) findViewById(R.id.logo);
	    
	    Handler anim1 = new Handler(){
	    	@Override
	    	public void handleMessage(Message msg){
	    		logo.setImageResource(R.drawable.splash2);
	    	}
	    	
	    };
	    Handler anim2 = new Handler(){
	    	@Override
	    	public void handleMessage(Message msg){
	    		logo.setImageResource(R.drawable.splash3);
	    	}
	    	
	    };
	    Handler anim3 = new Handler(){
	    	@Override
	    	public void handleMessage(Message msg){
	    		logo.setImageResource(R.drawable.splash4);
	    	}
	    	
	    };
	    Handler anim4 = new Handler(){
	    	@Override
	    	public void handleMessage(Message msg){
	    		logo.setImageResource(R.drawable.splash5);
	    	}
	    	
	    };
	    
	    anim1.sendEmptyMessageDelayed(0,800);
	    anim2.sendEmptyMessageDelayed(0,1000);
	    anim3.sendEmptyMessageDelayed(0,1700);
	    anim4.sendEmptyMessageDelayed(0,1850);
	    
	    Handler handler = new Handler() {
        	@Override
        	public void handleMessage(Message msg) {        		
        		finish(); //현재 액티비티 즉 SplashActivity 종료
        		
                            //페이드 인 페이드 아웃 효과 res/anim/fadein, fadeout xml을 만들어 줘야 합니다.
        		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        	}
        };
        handler.sendEmptyMessageDelayed(0,2000);
	    
	}
	
	public void onBackPressed(){}

}
