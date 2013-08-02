package sg.vinova.vss.group5.non.activity;

import sg.vinova.vss.group5.non.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
//import android.view.View;

public class MainActivity extends Activity {
	
	Button btnenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnenter = (Button) findViewById(R.id.enter);
		btnenter.setOnClickListener(
				new View.OnClickListener() {
			public void onClick(View view) {
				//check(view);
				Log.d(C.TAG, "peo 3");
				startActivity(new Intent().setClass(view.getContext(), LoginActivity.class));
				Log.d(C.TAG, "peo 4");
			}
		});
	}
	
	String prefname="my_data";
	public void check(View view)
	{
		SharedPreferences pre=getSharedPreferences
				(prefname,MODE_PRIVATE);
			boolean bchk=pre.getBoolean("checked", false);
			
			if (!bchk)
			{
				//StartLogIn(view);
				Log.d(C.TAG, "peo");
				startActivity(new Intent().setClass(view.getContext(), LoginActivity.class));
				
				SharedPreferences.Editor editor=pre.edit();
				
					editor.putBoolean("checked", true);
				
				editor.commit();
			}
			else
			{
				StartMainScreen();
				/*Intent intent = new Intent(this, MainScreen.class);
				startActivity(intent);*/
			}
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void StartMainScreen() {
		// TODO Auto-generated method stub
		finish();
		Intent intent = new Intent(this, MainScreen.class);
		startActivity(intent);
	}
	/*
	public void StartLogIn(){
		finish();
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}*/
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStop(){
		super.onStop();
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
	
}