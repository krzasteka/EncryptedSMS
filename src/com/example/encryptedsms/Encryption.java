package com.example.encryptedsms;
import java.security.spec.KeySpec;
 
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption extends Activity {

	protected static final String ALGORITHM = "AES";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_encryption);
         
          final EditText sms = (EditText)findViewById(R.id.textMessage);
          final EditText tN = (EditText)findViewById(R.id.telNum);         
          final TextView previewText = (TextView)findViewById(R.id.previewText);
          final EditText key = (EditText)findViewById(R.id.encryptKey);
          
          final Button button = (Button) findViewById(R.id.sendEncrypt);
      button.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              // Perform action on click
                final String smsContent = sms.getText().toString();
                final String telNumber = tN.getText().toString();
                final String ekey = key.getText().toString();
                previewText.setText(smsContent);
                try {
                            final String Enc = cipher (ekey, smsContent);     
                            sendSMS(telNumber, Enc);
                      } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                      }
         
          
          }
         
          public String cipher(String secretKey, String data) throws Exception {

                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), secretKey.getBytes(), 128, 256);
                SecretKey tmp = factory.generateSecret(spec);
                SecretKey key = new SecretKeySpec(tmp.getEncoded(), ALGORITHM);

                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, key);

                return toHex(cipher.doFinal(data.getBytes()));
                }
          public String toHex(byte[] stringBytes) {
                StringBuffer result = new StringBuffer(2*stringBytes.length);

                for (int i = 0; i < stringBytes.length; i++) {
                result.append(HEX.charAt((stringBytes[i]>>4)&0x0f)).append(HEX.charAt(stringBytes[i]&0x0f));
                }

                return result.toString();
                }
          private final static String HEX = "0123456789ABCDEF";
         
       private void sendSMS(String phoneNumber, String message)
       {
           SmsManager sms = SmsManager.getDefault();
           sms.sendTextMessage(phoneNumber, null, message, null, null);
       }
      });
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.encryption, menu);
		return true;
	}

}
