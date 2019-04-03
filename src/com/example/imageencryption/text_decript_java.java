package com.example.imageencryption;

import com.example.imageencryption.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class text_decript_java extends Activity{
	EditText dec_text_key_edt;
	Button dec_text_btn;
	TextView dec_text_view;
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_decript_xml);
		dec_text_btn=(Button)findViewById(R.id.dec_text_btn);
		dec_text_key_edt=(EditText)findViewById(R.id.dec_text_key_edt);
		dec_text_view=(TextView)findViewById(R.id.dec_text_view);
		
		
		dec_text_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "code to be writen"+Imgdecript.text_code_string, 100).show();
				try {
					//System.out.println("Decrypted ----: "+SimpleCrypto.decrypt("ganesh", SimpleCrypto.encrypt("ganesh", "Hai how r u?")));
					dec_text_view.setText(SimpleCrypto2.decrypt(dec_text_key_edt.getText().toString(), Imgdecript.text_code_string));
				} catch (Exception e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "criptography exception see log cat....", 100).show();
					count++;
					if(count==3){
						Intent in=new Intent(getApplicationContext(),entry_java.class);
						startActivity(in);
						finish();
					}
				}

			}
		});
	}

}
