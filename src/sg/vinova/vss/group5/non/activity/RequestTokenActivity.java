package sg.vinova.vss.group5.non.activity;

import java.net.URLEncoder;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class RequestTokenActivity extends Activity {

	private OAuthConsumer consumer; 
	private OAuthProvider provider;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
    		consumer = new CommonsHttpOAuthConsumer(C.CONSUMER_KEY, C.CONSUMER_SECRET);
    		provider = new CommonsHttpOAuthProvider(
    				C.REQUEST_URL  + "?scope=" + URLEncoder.encode(C.SCOPE, C.ENCODING) + "&xoauth_displayname=" + C.APP_NAME,
    				C.ACCESS_URL,
    				C.AUTHORIZE_URL);
    	} catch (Exception e) {
    		Log.e(C.TAG, "Error creating consumer / provider",e);
    	}
    	getRequestToken();
	}
	
	private void getRequestToken() {
		try {
			Log.d(C.TAG, "getRequestToken() called");
			String url = provider.retrieveRequestToken(consumer, C.OAUTH_CALLBACK_URL);			
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url)).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_FROM_BACKGROUND);
			this.startActivity(intent);
			
		} catch (Exception e) {
			Log.e(C.TAG, "Error retrieving request token", e);
		}
	}
	
}
