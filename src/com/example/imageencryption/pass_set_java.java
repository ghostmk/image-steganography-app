package com.example.imageencryption;

import com.example.imageencryption.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pass_set_java extends Activity{
	
	
	Button save,ok;
	EditText oldpsd,newpsd,cnpsd,sq,sqans;
	String old,chng,cnchng,seq,seqans;
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pass_set_xml);
		
		save=(Button)findViewById(R.id.button2);
		ok=(Button)findViewById(R.id.button1);
		oldpsd=(EditText)findViewById(R.id.editText1);
		newpsd=(EditText)findViewById(R.id.editText2);
		cnpsd=(EditText)findViewById(R.id.editText3);
		sq=(EditText)findViewById(R.id.editText4);
		sqans=(EditText)findViewById(R.id.editText5);
		
		save.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				old=oldpsd.getText().toString();
				chng=newpsd.getText().toString();
				cnchng=cnpsd.getText().toString();
				if(chng.equals(cnchng))
				{
				 SharedPreferences pass=getSharedPreferences("regdet", MODE_WORLD_WRITEABLE);
				 Editor psd=pass.edit();
				 psd.putString("Newpassword", chng);
				 psd.commit();
				}
				 
				else
				{
				 Toast.makeText(getApplicationContext(), "Password and Confirm Password donot match", Toast.LENGTH_LONG).show();
				}
			    
				
			}
		});
		ok.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
			
				seq=sq.getText().toString();
				seqans=sqans.getText().toString();
				
				SharedPreferences forget=getSharedPreferences("regdet", MODE_WORLD_WRITEABLE);
				String shrseq=forget.getString("Sequrity", "Not found");
				String shrans=forget.getString("Answer", "Not found");
				
				if(seq.equals(shrseq)&&(seqans.equals(shrans)))
				{
					String shrpas=forget.getString("Newpassword", "Not found");
					Toast.makeText(getApplicationContext(), "Your Password is:"+shrpas, Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getBaseContext(), "Please Enter correct Security Question and Answer", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

}
