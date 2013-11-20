package com.example.encryptedsms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Encryption extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encryption);
		
		final EditText sms = (EditText)findViewById(R.id.textMessage);
		
		final EditText tN = (EditText)findViewById(R.id.telNum);
		
		final TextView previewText = (TextView)findViewById(R.id.previewText);
		
		final Button button = (Button) findViewById(R.id.sendEncrypt);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final String smsContent = sms.getText().toString();
            	final String telNumber = tN.getText().toString();
            	previewText.setText(smsContent);
            	sendSMS(telNumber, smsContent);
            }
            
            
     	   private void sendSMS(String phoneNumber, String message)
    	   {
    	       SmsManager sms = SmsManager.getDefault();
    	       sms.sendTextMessage(phoneNumber, null, message, null, null);
    	   }
        });
        
//		Button btnSendSMS = (Button) findViewById(R.id.sendEncrypt);
//	      btnSendSMS.setOnClickListener(new View.OnClickListener()
//	      {
//	         public void onClick(View v)
//	         {
////	             
//	          }
//	      });
//	   }
	  //---sends an SMS message to another device---
//

	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.encryption, menu);
		return true;
	}

}
