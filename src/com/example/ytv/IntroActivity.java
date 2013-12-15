package com.example.ytv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class IntroActivity extends Activity {
	
	/** Called when the activity is first created. */
	Handler handler;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);      
        handler = new Handler();
        handler.postDelayed(irun, 2000); //약 2초동안 인트로 화면
    }
    Runnable irun = new Runnable() {
    	public void run() {
    		Intent intent = new Intent(IntroActivity.this, MainActivity.class);
    		startActivity(intent);
    		// 뒤로가기 했을경우 안나오도록 없애주기 >> finish!!
            finish();
            
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    	}
    };
    
    public void onBackPressed() {   
      super.onBackPressed();
      handler.removeCallbacks(irun);
    }
	
}
