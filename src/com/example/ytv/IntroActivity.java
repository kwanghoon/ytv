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
        handler.postDelayed(irun, 2000); //�� 2�ʵ��� ��Ʈ�� ȭ��
    }
    Runnable irun = new Runnable() {
    	public void run() {
    		Intent intent = new Intent(IntroActivity.this, MainActivity.class);
    		startActivity(intent);
    		// �ڷΰ��� ������� �ȳ������� �����ֱ� >> finish!!
            finish();
            
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    	}
    };
    
    public void onBackPressed() {   
      super.onBackPressed();
      handler.removeCallbacks(irun);
    }
	
}
