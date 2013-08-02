package sg.vinova.vss.group5.non;

public class C {
	
	public static final String TAG = "myDebugger";

	public static final String CONSUMER_KEY 	= "anonymous";
	public static final String CONSUMER_SECRET 	= "anonymous";

	public static final String CLIENT_ID  		= "585048405123.apps.googleusercontent.com"; 
	public static final String SCOPE 			= "https://www.google.com/m8/feeds/";	
	public static final String REQUEST_URL 		= "https://www.google.com/accounts/OAuthGetRequestToken";
	public static final String ACCESS_URL 		= "https://www.google.com/accounts/OAuthGetAccessToken";  
	public static final String AUTHORIZE_URL 	= "https://www.google.com/accounts/OAuthAuthorizeToken";
	
	public static final String GET_CONTACTS_FROM_GOOGLE_REQUEST 		= "https://www.google.com/m8/feeds/contacts/default/full?alt=json";
	
	public static final String ENCODING 		= "UTF-8";
	
	public static final String	OAUTH_CALLBACK_SCHEME	= "x-oauthflow";
	public static final String	OAUTH_CALLBACK_HOST		= "callback";
	public static final String	OAUTH_CALLBACK_URL		= OAUTH_CALLBACK_SCHEME + "://" + OAUTH_CALLBACK_HOST;
	//public static final String	APP_NAME                = "NoN";
	// public static final String  CALLBACK_URL 			= "urn:ietf:wg:oauth:2.0:oob";
	
	public static final String PREF_KEY_OAUTH_TOKEN_SECRET = "oauth_token_secret";
	public static final String PREF_KEY_OAUTH_TOKEN = "oauth_token";

}
