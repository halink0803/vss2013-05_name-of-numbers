package sg.vinova.vss.group5.non.activity;

import sg.vinova.vss.group5.non.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2 extends Fragment{
	
	private TextView text;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		//View v = LayoutInflater.from(getActivity()).inflate(R.layout.tab_layout,null);
		View v = inflater.inflate(R.layout.tab_layout,container, false);
		
		text = (TextView) v.findViewById(R.id.text);
		if (getArguments() != null) {
			//
			try {
				//String value = getArguments().getString("key");
				text.setText("List Favorite Contacts Here");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return v;
		
	}
	
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}
}
