package sg.vinova.vss.group5.non.activity;

import sg.vinova.vss.group5.non.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(C.TAG, "zzz");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		Button launchOAuth = (Button) findViewById(R.id.launchOAuth); 
		launchOAuth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Log.d(C.TAG, "Piu 15");
            	startActivity(new Intent().setClass(v.getContext(), RequestTokenActivity.class));            	
            }
        });
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onPause() {
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
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public void launchOAuth(View view) {
		startActivity(new Intent().setClass(view.getContext(), RequestTokenActivity.class));
	}
	
	public void Skip(View v){
		Intent intent = new Intent(this, MainScreen.class);
		startActivity(intent);
	}

}
