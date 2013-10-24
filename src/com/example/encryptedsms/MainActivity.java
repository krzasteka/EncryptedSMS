package com.example.encryptedsms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	Button sendEncrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sendEncrypted = (Button)findViewById(R.id.encryptedMessage);
        final Intent encrypt = new Intent(this, Encryption.class);
        
        sendEncrypted.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(encrypt);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
