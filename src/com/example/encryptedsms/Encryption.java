package com.example.encryptedsms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Encryption extends Activity {
	Button buttonSend;
//	EditText tN = (EditText)findViewById(R.id.telNum);
//	EditText sms = (EditText)findViewById(R.id.textMessage);
//	String smsContent = sms.getText().toString();
//	String telNumber = tN.getText().toString();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encryption);
		
//		Button btnSendSMS = (Button) findViewById(R.id.sendEncrypt);
//	      btnSendSMS.setOnClickListener(new View.OnClickListener()
//	      {
//	         public void onClick(View v)
//	         {
////	             sendSMS(telNumber, smsContent);
//	          }
//	      });
//	   }
	  //---sends an SMS message to another device---
//
//	   private void sendSMS(String phoneNumber, String message)
//	   {
//	       SmsManager sms = SmsManager.getDefault();
//	       sms.sendTextMessage(phoneNumber, null, message, null, null);
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.encryption, menu);
		return true;
	}

}
