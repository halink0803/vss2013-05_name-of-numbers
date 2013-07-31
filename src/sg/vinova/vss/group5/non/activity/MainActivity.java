package sg.vinova.vss.group5.non.activity;

import sg.vinova.vss.group5.non.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
			public void onClick(View arg0) {
				check();
			}
		});
	}
	
	String prefname="my_data";
	public void check()
	{
		SharedPreferences pre=getSharedPreferences
				(prefname,MODE_PRIVATE);
			boolean bchk=pre.getBoolean("checked", false);
			
			if (!bchk)
			{
				StartLogIn();
				
				/*Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);*/
				//tạo đối tượng Editor để lưu thay đổi
				SharedPreferences.Editor editor=pre.edit();
					//lưu vào editor
					editor.putBoolean("checked", true);
				//chấp nhận lưu xuống file
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
	
	public void StartLogIn(){
		finish();
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
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