package com.onceteam.once;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_splash);
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
