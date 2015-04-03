package com.onceteam.once;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sinchontycoon.once.R;

public class WebViewActivity extends Activity {

	
	WebView mWV;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_webview);

	    mWV = (WebView) findViewById(R.id.webview);
	    mWV.loadUrl("http://54.92.64.176/not_yet/");
	    mWV.setWebViewClient(new myWebViewClient());
	    
	    

	}

	class myWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url){
			view.loadUrl(url);
			
			return true;			
		}
	}
	
	
	
}
