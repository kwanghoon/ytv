package com.example.ytv;

import com.google.android.youtube.player.YouTubeIntents;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	
	private static final String SUNDAY_WORSHIP_ID = "PLnHlSuVXEMp6X1nNXRg7Ae4FX_exjebhk";
	private static final String SUNDAY_AFTERNOON_WORSHIP_ID = "PLnHlSuVXEMp6m3__Dp4Zg3gDgd9W8HP3z";
	private static final String CHAPEL_ID = "PLnHlSuVXEMp4_CQF-K6ugx0-ydHBy2mSk";
	private static final String SPECIAL_BROADCASTING_ID = "PLnHlSuVXEMp6fhD0GYfkaKx4Oseu5FxUv";
	private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTitle("연세대 인터넷 선교방송국");
		getActionBar().setIcon(R.drawable.ytv_actionbar_image);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // res/values/array.xml로 저장됨.
		
		
		mPlanetTitles = getResources().getStringArray(R.array.list);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		ImageView imagehowtouse =(ImageView)this.findViewById(R.id.imageView2);
		imagehowtouse.setImageResource(R.drawable.ytv_howtouse);

		
		//Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mPlanetTitles));
		
		//Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
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
		
		switch(position) {
		
		case 0:
			TextView text0 = (TextView) findViewById(R.id.TextView1);
			text0.setText("\n<설립목적>\n\n-연세정신의 구현, 문화선교의 매체-\n\n연세대학교는 기독교의 가르침을 바탕으로\n 진리와 자유의 정신에 따라 \n사회에 이바지할 지도자를 기르는 배움터이다.\n " +
									"이에 우리는 실세계와 사이버 세계의 창조적인 균형을 지향하여,\n우리 대학교의 이념이 구현될 수 있도록 \nYTV의 설립 목적을 세운다." +
							"\n\n\n<이념>\n\nYTV는 기독교 정신을 바탕으로 \n인터넷 상에서 좋은 문화의 장을 마련하기 위한 알림터이다.\nYTV 팀원은 신앙과 양심을 갖추어 곧고 바르게 살고, \n희생과 사랑의 마음으로 사회에 봉사하며," +
									"캠퍼스의 복음화에 힘쓴다.\n");
			ImageView image0 =(ImageView)this.findViewById(R.id.imageView1);
			image0.setImageResource(android.R.color.transparent);
			
			TextView text00 = (TextView) findViewById(R.id.TextView2);
			text00.setText("\n<문의>\n");
			
			TextView text01 = (TextView) findViewById(R.id.TextView3);
			text01.setText("ytvyonsei@gmail.com");
			Linkify.addLinks(text01, Linkify.EMAIL_ADDRESSES);
			
			TextView text02 = (TextView) findViewById(R.id.TextView4);
			text02.setText("");
			
			TextView text03 = (TextView) findViewById(R.id.TextView5);
			text03.setText("");
			
			ImageView imagehowtouse0 =(ImageView)this.findViewById(R.id.imageView2);
			imagehowtouse0.setImageResource(android.R.color.transparent);
			
			break;
		
		case 1:
			TextView text1 = (TextView) findViewById(R.id.TextView1); 
			text1.setText("\n<주일예배>\n\n시간: 주일 오전 11시  / 장소: 대학교회 대예배실\n\n(담당: 박정진 목사님)\n\n");
			
			ImageView image1 =(ImageView)this.findViewById(R.id.imageView1);
			image1.setImageResource(R.drawable.ytv_watch);
			
			image1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent;
					intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), SUNDAY_WORSHIP_ID);
			        startActivity(intent);
				}
				
			});
			
			TextView text10 = (TextView) findViewById(R.id.TextView2);
			text10.setText("(위 이미지를 클릭하시면 방송을 시청하실 수 있습니다.)\n\n\n<TEL>\n");
			
			TextView text11 = (TextView) findViewById(R.id.TextView3);
			text11.setText("0337602871\n");
			Linkify.addLinks(text11, Linkify.PHONE_NUMBERS);
			
			TextView text12 = (TextView) findViewById(R.id.TextView4);
			text12.setText("0337602872\n");
			Linkify.addLinks(text12, Linkify.PHONE_NUMBERS);
			
			TextView text13 = (TextView) findViewById(R.id.TextView5);
			text13.setText("0337602173\n\n");
			Linkify.addLinks(text13, Linkify.PHONE_NUMBERS);
			
			ImageView imagehowtouse1 =(ImageView)this.findViewById(R.id.imageView2);
			imagehowtouse1.setImageResource(android.R.color.transparent);
			
			break;
		
		case 2:
			TextView text2 = (TextView) findViewById(R.id.TextView1); 
			text2.setText("\n<오후예배>\n\n시간: 주일 오후 3시 / 장소: 대학교회 대예배실 (매 학기 중)\n\n(담당: 김영혜 목사님)\n\n");
			
			ImageView image2 =(ImageView)this.findViewById(R.id.imageView1);
			image2.setImageResource(R.drawable.ytv_watch);
			
			image2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent;
					intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), SUNDAY_AFTERNOON_WORSHIP_ID);
			        startActivity(intent);
				}
				
			});
			
			TextView text20 = (TextView) findViewById(R.id.TextView2);
			text20.setText("(위 이미지를 클릭하시면 방송을 시청하실 수 있습니다.)\n\n\n<TEL>\n");
			
			TextView text21 = (TextView) findViewById(R.id.TextView3);
			text21.setText("0337602871\n");
			Linkify.addLinks(text21, Linkify.PHONE_NUMBERS);
			
			TextView text22 = (TextView) findViewById(R.id.TextView4);
			text22.setText("0337602872\n");
			Linkify.addLinks(text22, Linkify.PHONE_NUMBERS);
			
			TextView text23 = (TextView) findViewById(R.id.TextView5);
			text23.setText("0337602173\n\n");
			Linkify.addLinks(text23, Linkify.PHONE_NUMBERS);
			
			ImageView imagehowtouse2 =(ImageView)this.findViewById(R.id.imageView2);
			imagehowtouse2.setImageResource(android.R.color.transparent);
			
			break;
			
		case 3:
			TextView text3 = (TextView) findViewById(R.id.TextView1); 
			text3.setText("\n<채플>\n\n시간: 수요일 10시, 11시, 12시 / 화요일 17시\n\n장소: 정의관 대강당\n\n");
			
			ImageView image3 =(ImageView)this.findViewById(R.id.imageView1);
			image3.setImageResource(R.drawable.ytv_watch);
			
			image3.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent;
					intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), CHAPEL_ID);
			        startActivity(intent);
				}
			});
			
			TextView text30 = (TextView) findViewById(R.id.TextView2);
			text30.setText("(위 이미지를 클릭하시면 방송을 시청하실 수 있습니다.)\n\n\n<문의>\n");
			
			TextView text31 = (TextView) findViewById(R.id.TextView3);
			text31.setText("0337602657\n");
			Linkify.addLinks(text31, Linkify.PHONE_NUMBERS);
			
			TextView text32 = (TextView) findViewById(R.id.TextView4);
			text32.setText("0337602695\n");
			Linkify.addLinks(text32, Linkify.PHONE_NUMBERS);
			
			TextView text33 = (TextView) findViewById(R.id.TextView5);
			text33.setText("wchapel@yonsei.kr\n\n");
			Linkify.addLinks(text33, Linkify.EMAIL_ADDRESSES);
			
			ImageView imagehowtouse3 =(ImageView)this.findViewById(R.id.imageView2);
			imagehowtouse3.setImageResource(android.R.color.transparent);
			
			break;
			
		case 4:
			TextView text4 = (TextView) findViewById(R.id.TextView1); 
			text4.setText("\n<기획방송>\n\n");
			
			ImageView image4 =(ImageView)this.findViewById(R.id.imageView1);
			image4.setImageResource(R.drawable.ytv_watch);
			image4.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent;
					intent = YouTubeIntents.createOpenPlaylistIntent(getApplicationContext(), SPECIAL_BROADCASTING_ID);
			        startActivity(intent);
				}	
			});
			
			TextView text40 = (TextView) findViewById(R.id.TextView2);
			text40.setText("(위 이미지를 클릭하시면 방송을 시청하실 수 있습니다.)\n\n\n<문의>\n");
			
			TextView text41 = (TextView) findViewById(R.id.TextView3);
			text41.setText("ytvyonsei@gmail.com\n");
			Linkify.addLinks(text41, Linkify.EMAIL_ADDRESSES);
			
			TextView text42 = (TextView) findViewById(R.id.TextView4);
			text42.setText("");
			
			TextView text43 = (TextView) findViewById(R.id.TextView5);
			text43.setText("");
			
			ImageView imagehowtouse4 =(ImageView)this.findViewById(R.id.imageView2);
			imagehowtouse4.setImageResource(android.R.color.transparent);
			
			break;
			
		default:
		
		}
	    
	    ///////////////////////////////////////////////////////////////////
	    // Highlight the selected item, update the title, and close the drawer
	    mDrawerList.setItemChecked(position, true);
	    setTitle(mPlanetTitles[position]);
	    mDrawerLayout.closeDrawer(mDrawerList);
	}
	
	@Override
	public void setTitle(CharSequence title) {
	    getActionBar().setTitle(title);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.about:
				TextView textabout = (TextView) findViewById(R.id.TextView1); 
				textabout.setText("\n<YTV 지도 교수님>\n\n최광훈 교수님\nKwanghoon Choi\n");
				ImageView image =(ImageView)this.findViewById(R.id.imageView1);
				image.setImageResource(R.drawable.professor_choi);
				
				TextView textinfo = (TextView) findViewById(R.id.TextView2);
				textinfo.setText("(위 이미지를 클릭하시면 그 분의 홈페이지에 \n접속하실 수 있습니다.)\n\n<문의>");
				
				TextView infomail = (TextView) findViewById(R.id.TextView3);
				infomail.setText("ytvyonsei@gmail.com");
				Linkify.addLinks(infomail, Linkify.EMAIL_ADDRESSES);
				
				TextView devinfo = (TextView) findViewById(R.id.TextView4);
				devinfo.setText("\n\n<개발자>");
				
				TextView devmail = (TextView) findViewById(R.id.TextView5);
				devmail.setText("owjpss@gmail.com\n\n");
				Linkify.addLinks(devmail, Linkify.EMAIL_ADDRESSES);
				
				//이미지 클릭시 교수님 홈페이지로 이동.
				image.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent mobilesw = new Intent(Intent.ACTION_VIEW);
						Uri mobile = Uri.parse("http://mobilesw.yonsei.ac.kr/");
						mobilesw.setData(mobile);
						startActivity(mobilesw);
					}
				});
				
				ImageView imagehowtouseinfo =(ImageView)this.findViewById(R.id.imageView2);
				imagehowtouseinfo.setImageResource(android.R.color.transparent);
				
				break;
			
			default:
				return false;
		}
		
		return true;
	}
}
