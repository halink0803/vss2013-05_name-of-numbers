package sg.vinova.vss.group5.non.activity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import sg.vinova.vss.group5.non.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private SharedPreferences prefs;
	TextView console;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
		console = (TextView) findViewById(R.id.console);
		
		Button launchOauth = (Button) findViewById(R.id.launch_oauth);
		launchOauth.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent().setClass(v.getContext(),
						PrepareRequestTokenActivity.class));
			}
		});
		
		Button clearCredentials = (Button) findViewById(R.id.clear_credentials);
		clearCredentials.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	clearCredentials();
            	console.setText("Tokens deleted, getContacts call should fail now.");
            }
        });
		
		Button getContact = (Button) findViewById(R.id.get_contact);
		getContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	getContacts();
            }
        });
	}
	
	/**
	String prefname="my_data";
	public void check()
	{
		SharedPreferences pre=getSharedPreferences
				(prefname,MODE_PRIVATE);
			boolean bchk=pre.getBoolean("checked", false);
			
			if (!bchk)
			{
				
				//Intent intent = new Intent(this, LoginActivity.class);
				//startActivity(intent);			
				SharedPreferences.Editor editor=pre.edit();
					//lÆ°u vÃ o editor
					editor.putBoolean("checked", true);				
				editor.commit();
			}
			else
			{
				StartMainScreen();
				//Intent intent = new Intent(this, MainScreen.class);
				//startActivity(intent);
			}
	}
	*/
	
	
	public void launchOAuth(View view) {				
		Intent intent = new Intent(view.getContext(), PrepareRequestTokenActivity.class);		
		startActivity(intent);
	}
	
	public void getContacts() {				
		String jsonOutput = "";		
        try {        	
        	jsonOutput = makeSecuredReq(C.GET_CONTACTS_FROM_GOOGLE_REQUEST, getConsumer(this.prefs));        	
         	JSONObject jsonResponse = new JSONObject(jsonOutput);
        	JSONObject m = (JSONObject)jsonResponse.get("feed");
        	JSONArray entries =(JSONArray)m.getJSONArray("entry");
        	String contacts = "";
        	for (int i=0 ; i<entries.length() ; i++) {
        		JSONObject entry = entries.getJSONObject(i);
        		JSONObject title = entry.getJSONObject("title");
        		if (title.getString("$t")!=null && title.getString("$t").length()>0) {
        			contacts += title.getString("$t") + "\n";
        		}
        	}        	
        	console.setText(contacts);
		} catch (Exception e) {
			Log.e(C.TAG, "Error executing request",e);
			console.setText("Error retrieving contacts : " + jsonOutput);
		}
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (isOAuthSuccessful()) {
    		// OAuth successful, try getting the contacts
    		console.setText("OAuth successful, try getting the contacts");
    	}
    	else {
    		console.setText("OAuth failed, no tokens, Click on the Do OAuth Button.");
    	}
	}
	
    private void clearCredentials() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		final Editor edit = prefs.edit();
		edit.remove("oauth_token");
		edit.remove("oauth_token_secret");
		edit.commit();
	}
    
    private boolean isOAuthSuccessful() {
    	String token = prefs.getString(OAuth.OAUTH_TOKEN, null);
		String secret = prefs.getString(OAuth.OAUTH_TOKEN_SECRET, null);
		if (token != null && secret != null) {
			StartMainScreen();
			return true;			
		} else 
			return false;
    }
	
	private OAuthConsumer getConsumer(SharedPreferences prefs) {
		String token = prefs.getString("oauth_token", "");
		String secret = prefs.getString("oauth_token_secret", "");
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(C.CONSUMER_KEY, C.CONSUMER_SECRET);		
		consumer.setTokenWithSecret(token, secret);
		return consumer;
	}
	
	private String makeSecuredReq(String url, OAuthConsumer consumer) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
    	HttpGet request = new HttpGet(url);
    	Log.i(C.TAG,"Requesting URL : " + url);
    	consumer.sign(request);    	
    	HttpResponse response = httpclient.execute(request);    	
    	Log.i(C.TAG,"Statusline : " + response.getStatusLine());
    	InputStream data = response.getEntity().getContent();
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));
        String responeLine;
        StringBuilder responseBuilder = new StringBuilder();
        while ((responeLine = bufferedReader.readLine()) != null) {
        	responseBuilder.append(responeLine);
        }
        Log.i(C.TAG,"Response : " + responseBuilder.toString());
        return responseBuilder.toString();
        
        
	}	
	
	private void StartMainScreen() {
		// TODO Auto-generated method stub
		//finish();
		Log.d(C.TAG, "Pepo5 b");
		Intent intent = new Intent(this, MainScreen.class);
		startActivity(intent);
	}	
}