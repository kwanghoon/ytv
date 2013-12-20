package edu.yonsei.ytv;

import edu.yonsei.ytv.YouTubeFailureRecoveryActivity;
import edu.yonsei.ytv.DeveloperKey;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends YouTubeFailureRecoveryActivity {
	
	private static final String SUNDAY_WORSHIP_ID = "PLnHlSuVXEMp6X1nNXRg7Ae4FX_exjebhk";
	private static final String SUNDAY_AFTERNOON_WORSHIP_ID = "PLnHlSuVXEMp6m3__Dp4Zg3gDgd9W8HP3z";
	private static final String CHAPEL_ID = "PLnHlSuVXEMp4_CQF-K6ugx0-ydHBy2mSk";
	private static final String SPECIAL_BROADCASTING_ID = "PLnHlSuVXEMp6fhD0GYfkaKx4Oseu5FxUv";
	private ActionBarDrawerToggle mDrawerToggle;
	private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setTitle("연세대 인터넷 선교방송국");
		
		getActionBar().setIcon(R.drawable.ytv_actionbar_image);
		getActionBar().setHomeButtonEnabled(true);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // res/values/array.xml로 저장됨.
		
		YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
		youTubeView.setVisibility(View.INVISIBLE);
		
		mPlanetTitles = getResources().getStringArray(R.array.list);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		mDrawerToggle = new ActionBarDrawerToggle(
				this,
				mDrawerLayout,
				R.drawable.ytv_actionbar_image,
				R.string.drawer_open,
				R.string.drawer_close
				
				){
			public void onDrawerClosed(View view) {
				invalidateOptionsMenu();
			}
			public void onDrawerOpened(View view) {
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		
		ImageView imagehowtouse =(ImageView)this.findViewById(R.id.imageView2);
		imagehowtouse.setImageResource(R.drawable.ytv_intro);
		
		//Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mPlanetTitles));
		
		//Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
	}
	YouTubePlayer myPlayer;
	
	@Override
	  public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
	      boolean wasRestored) {
	    if (!wasRestored) {
	      player.loadVideo("bJDtLme90SU");
	      myPlayer = player;
	      myPlayer.setShowFullscreenButton(false);
	      Log.i("MainActivity","onInitializationSuccess");
	    }
	  }

	  @Override
	  protected YouTubePlayer.Provider getYouTubePlayerProvider() {
	    return (YouTubePlayerView) findViewById(R.id.youtube_view);
	  }
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
			//클릭시 해당 위치의 항목에 대한 아이템에 관한 정보를 실행시킴.
		}
	}
	
	//Swaps fragments in the main content view
	private void selectItem(int position) {
		////////////////////////////////////////////////////////////////////
		//선택시 실행될 코드들 수행
	    ///////////////////////////////////////////////////////////////////
	    // Highlight the selected item, update the title, and close the drawer
	    mDrawerList.setItemChecked(position, true);
	    setTitle(mPlanetTitles[position]);
	    mDrawerLayout.closeDrawer(mDrawerList);
	    
		switch(position) {
		
		case 0:
		{
			YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
			youTubeView.setVisibility(View.VISIBLE);
			
			if(myPlayer != null)
			{
			myPlayer.seekToMillis(0);
			myPlayer.play();
			}
			
			ImageView image0 =(ImageView)this.findViewById(R.id.imageView2);
			image0.setVisibility(View.INVISIBLE);

		    youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
		}
			break;
		
		case 1:
		{
			YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
			youTubeView.setVisibility(View.INVISIBLE);
			
			if (myPlayer != null && myPlayer.isPlaying()) {
				myPlayer.release();
				myPlayer = null;
			}
			
			ImageView image0 =(ImageView)this.findViewById(R.id.imageView2);
			image0.setVisibility(View.VISIBLE);
			
			Intent intent;
			intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), SUNDAY_WORSHIP_ID);
			startActivity(intent);
		}
			break;
		
		case 2:
		{
			YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
			youTubeView.setVisibility(View.INVISIBLE);
			
			if (myPlayer != null && myPlayer.isPlaying()) {
				myPlayer.release();
				myPlayer = null;
			}
			
			ImageView image0 =(ImageView)this.findViewById(R.id.imageView2);
			image0.setVisibility(View.VISIBLE);
			
			Intent intent;
			intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), SUNDAY_AFTERNOON_WORSHIP_ID);
			startActivity(intent);
		}

			break;
			
		case 3:
		{
			YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
			youTubeView.setVisibility(View.INVISIBLE);
			
			if (myPlayer != null && myPlayer.isPlaying()) {
				myPlayer.release();
				myPlayer = null;
			}
			
			ImageView image0 =(ImageView)this.findViewById(R.id.imageView2);
			image0.setVisibility(View.VISIBLE);
			
			Intent intent;
			intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), CHAPEL_ID);
			startActivity(intent);
		}
			
			break;
			
		case 4:
		{
			YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
			youTubeView.setVisibility(View.INVISIBLE);
			
			if (myPlayer != null && myPlayer.isPlaying()) {
				myPlayer.release();
				myPlayer = null;
			}
			
			ImageView image0 =(ImageView)this.findViewById(R.id.imageView2);
			image0.setVisibility(View.VISIBLE);
			
			Intent intent;
			intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), SPECIAL_BROADCASTING_ID);
			startActivity(intent);
		}
			break;
			
		/*
		case 5:
		{
			//TODO: Integration of VideoWallDemoActivity to play all contents in a random order!
			Intent intent = new Intent();
			intent = new Intent(MainActivity.this, VideoWallDemoActivity.class);
		    startActivity(intent);
		}
			
		*/
		default:
		
		}		
	}
	
	@Override
	public void setTitle(CharSequence title) {
	    getActionBar().setTitle(title);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.about).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
	
	public boolean onOptionsItemSelected(MenuItem item) {
	
		//The ActionBar home Action should do open or close the drawer on the left.
		//ActionBarDrawerToggle defined on the almost top of this code will take care of this.
		if(mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		//Handle Action buttons on the action bar
		switch(item.getItemId()) {
			case R.id.about:
			    //mDrawerLayout.openDrawer(mDrawerList);
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("YTV App Info");
				builder.setMessage("-YTV 문의-\nytvyonsei@gmail.com\n\n-개발자-\nowjpss@gmail.com\n컴퓨터정보통신공학부 오재영");
				builder.setNeutralButton("Close",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				builder.show();
			//break;
			return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		
		//return true;
	}
	
	@Override
	public void onBackPressed() {   
	      super.onBackPressed();
	      
	     //YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
			
		ImageView image0 =(ImageView)this.findViewById(R.id.imageView2);
		
		if(image0.isShown() == true)
		{
			
		}
		
	}
	
	@Override
	public boolean onKeyDown(int KeyCode, KeyEvent event) {
		
		YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

		ImageView image0 =(ImageView)this.findViewById(R.id.imageView2);
		
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			switch (KeyCode) {
			case KeyEvent.KEYCODE_BACK:
	
				Log.i("Backkey", "BackBack");
				if(image0.isShown())
				{
					return super.onKeyDown(KeyCode, event);
				}
				
				else
				{
					youTubeView.setVisibility(View.INVISIBLE);
					
					if (myPlayer != null && myPlayer.isPlaying()) {
						myPlayer.release();
						myPlayer = null;
					}
					
					image0.setVisibility(View.VISIBLE);

					return true;
				}
				
			}
		}
		

		return super.onKeyDown(KeyCode, event);
	}
	
}
