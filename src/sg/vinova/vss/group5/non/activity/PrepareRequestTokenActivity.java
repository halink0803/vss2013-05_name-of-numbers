package sg.vinova.vss.group5.non.activity;

import sg.vinova.vss.group5.non.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;

import com.google.api.client.auth.oauth.OAuthHmacSigner;

public class PrepareRequestTokenActivity extends Activity {

	final String TAG = getClass().getName();
	private OAuthHmacSigner signer;
	//private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(C.TAG, "Pepe07");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prepare_request_token);
		Log.i(C.TAG, "Pepe");
    	try {
			signer = new OAuthHmacSigner();
			signer.clientSharedSecret = C.CONSUMER_SECRET;        	
    	} catch (Exception e) {
    		Log.e(TAG, "Error creating consumer / provider",e);
		}
        Log.i(TAG, "Starting task to retrieve request token.");
		new OAuthRequestTokenTask(this,signer).execute();
	}
	
	/**
	 * Called when the OAuthRequestTokenTask finishes (user has authorized the request token).
	 * The callback URL will be intercepted here so we can fetch the token and token secret.
	 */
	@Override
	public void onNewIntent(Intent intent) {
		super.onNewIntent(intent); 
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		final Uri uri = intent.getData();
		if (uri != null && uri.getScheme().equals(C.OAUTH_CALLBACK_SCHEME)) {
			Log.i(TAG, "Callback received : " + uri);
			Log.i(TAG, "Retrieving Access Token");
			new RetrieveAccessTokenTask(this,signer,prefs).execute(uri);
			finish();	
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prepare_request_token, menu);
		return true;
	}

}
