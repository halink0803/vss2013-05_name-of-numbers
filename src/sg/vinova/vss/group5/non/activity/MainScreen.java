package sg.vinova.vss.group5.non.activity;

import sg.vinova.vss.group5.non.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class MainScreen extends FragmentActivity{
	private FragmentTabHost mTabhost;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		mTabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabhost.addTab(mTabhost.newTabSpec("all").setIndicator("ALL"),Tab1.class, null);
		Bundle b = new Bundle();
		mTabhost.addTab(mTabhost.newTabSpec("favorite").setIndicator("Favorite"),Tab2.class, b);
		b = new Bundle();
		mTabhost.addTab(mTabhost.newTabSpec("other").setIndicator("Other Group"),Tab3.class, b); 
		
	}
	
	
	@Override	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
