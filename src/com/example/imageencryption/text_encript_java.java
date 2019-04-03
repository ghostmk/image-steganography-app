package com.example.imageencryption;

import com.example.imageencryption.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class text_encript_java extends Activity{
EditText enc_text_key_edt,enc_text_edt;
Button enc_text_btn;
public static String encrypted_string;
SimpleCrypto2 sicrypto=new SimpleCrypto2();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_encript_xml);
		enc_text_key_edt=(EditText)findViewById(R.id.enc_text_key_edt);
		enc_text_edt=(EditText)findViewById(R.id.enc_text_edt);
		enc_text_btn=(Button)findViewById(R.id.enc_text_btn);
		
		enc_text_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					
					
					//text.setText(SimpleCrypto.encrypt("ganesh", "Hai how r u?"));
					encrypted_string=SimpleCrypto2.encrypt(enc_text_key_edt.getText().toString(),enc_text_edt.getText().toString());
					//text.setText(encrypted_string);
					Toast.makeText(getApplicationContext(),encrypted_string , 100).show();
					enc_text_key_edt.setText("");
					enc_text_edt.setText("");
					
					Intent encriptImg_intent=new Intent(getApplicationContext(),Imgencript.class);
					startActivity(encriptImg_intent);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
	}
}
