package sg.vinova.vss.group5.non.activity;

import android.content.SharedPreferences;

import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.auth.oauth.OAuthParameters;
import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.json.JsonCParser;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;


public class Util {
	public static final HttpTransport TRANSPORT = newTransport(false);
	public static final HttpTransport AUTH_TRANSPORT = newTransport(true);
	public static final JsonFactory JSON_FACTORY = new JacksonFactory();
	public static final String APP_DESCRIPTION = "Name of Number";	
	
	static HttpTransport newTransport(boolean forAuth) {
		HttpTransport result = new NetHttpTransport();
		GoogleUtils.useMethodOverride(result);
		GoogleHeaders headers = new GoogleHeaders();
		headers.setApplicationName("Google-LatitudeSample/1.0");
		result.defaultHeaders = headers;
		if (!forAuth) {
			JsonCParser parser = new JsonCParser();
			parser.jsonFactory =  new JacksonFactory();
			result.addParser(parser);
		}
		return result;
	}

	public static void setupAuthorizer(SharedPreferences prefs) {
		String token = prefs.getString(C.PREF_KEY_OAUTH_TOKEN, "");
		String secret = prefs.getString(C.PREF_KEY_OAUTH_TOKEN_SECRET,"");

		OAuthHmacSigner signer = new OAuthHmacSigner();
		signer.clientSharedSecret = C.CONSUMER_SECRET;
		signer.tokenSharedSecret = secret;
		OAuthParameters authorizer = new OAuthParameters();
		authorizer.consumerKey = C.CONSUMER_KEY;
		authorizer.signer = signer;
		authorizer.token = token;
		authorizer.signRequestsUsingAuthorizationHeader(Util.TRANSPORT);
	}

	/*
	public static String executeApiCall() throws Exception {
		BuzzActivityFeed feed = BuzzActivityFeed.list();
		StringBuffer sb = new StringBuffer();
		for (BuzzActivity activity : feed.items) {
			sb.append("\n");
			sb.append("-----------------------------------------------\n");
			sb.append("Content: " + activity.object.content);
			sb.append("\n");
			sb.append("Updated: " + activity.updated);
			;
			sb.append("\n");
		}
		return sb.toString();
	}
	*/
	
}
