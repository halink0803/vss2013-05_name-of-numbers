package sg.vinova.vss.group5.non.activity;

import sg.vinova.vss.group5.non.R;
import android.app.Activity;
import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> 36ca071d98987f2dab973e30d736cad294dd5ecd
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	
<<<<<<< HEAD
	String prefname="my_data";
	
	
	public void check()
	{
		SharedPreferences pre=getSharedPreferences
				(prefname,MODE_PRIVATE);
			//lấy giá trị checked ra, nếu không thấy thì giá trị mặc định là false
			boolean bchk=pre.getBoolean("checked", false);
			
			if (!bchk)
			{
				//StartLogIn(null);
				Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);
			}
			else
			{
				//StartMainScreen(null);
				Intent intent = new Intent(this, MainScreen.class);
				startActivity(intent);
			}
	}

	private void StartMainScreen(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainScreen.class);
		startActivity(intent);
	}

	public void StartLogIn(View v){
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
=======
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
>>>>>>> 36ca071d98987f2dab973e30d736cad294dd5ecd
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
	
<<<<<<< HEAD
=======
	public void StartLogIn(View v){
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
>>>>>>> 36ca071d98987f2dab973e30d736cad294dd5ecd
	public void finishMainActivity(View v){
		MainActivity.this.finish();
	}
}
