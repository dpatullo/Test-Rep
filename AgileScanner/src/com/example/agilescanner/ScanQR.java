package com.example.agilescanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScanQR extends Activity implements OnClickListener {

	
	private Button scanBtn;
	private TextView  contentTxt, lecturerTxt, courseTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		scanBtn = (Button)findViewById(R.id.scan_button);
		contentTxt = (TextView)findViewById(R.id.scan_content);
		lecturerTxt = (TextView)findViewById(R.id.lecturer_name);
		courseTxt = (TextView)findViewById(R.id.course_name);
		
		scanBtn.setOnClickListener(this);
	}
	
	public void onClick(View v){
		if(v.getId()==R.id.scan_button){
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan();
			//scan
			}
		}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		
		if (scanningResult != null) {
			String scanContent = scanningResult.getContents();
			contentTxt.setText("CONTENT: " + scanContent);
				
			}
		else{
		    Toast toast = Toast.makeText(getApplicationContext(), 
		        "No scan data received", Toast.LENGTH_SHORT);
		    toast.show();
		}

		}
}
