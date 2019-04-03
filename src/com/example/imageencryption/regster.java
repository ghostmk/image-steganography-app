package com.example.imageencryption;

import com.example.imageencryption.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class regster extends Activity{
	
	EditText ustxt;
	EditText nptxt, cnptxt, sqtxt, anstxt;
	Button reg;
	String user,paswrd,cnpaswrd,seq,ans;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		
		
		reg=(Button)findViewById(R.id.button1);
		
		ustxt=(EditText)findViewById(R.id.editText1);
		nptxt=(EditText)findViewById(R.id.editText2);
		cnptxt=(EditText)findViewById(R.id.editText3);
		sqtxt=(EditText)findViewById(R.id.editText4);
		anstxt=(EditText)findViewById(R.id.editText5);
		
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			    user=ustxt.getText().toString();
				paswrd=nptxt.getText().toString();
				cnpaswrd=cnptxt.getText().toString();
				seq=sqtxt.getText().toString();
				ans=anstxt.getText().toString();
				
				if(paswrd.equals(cnpaswrd))
				{
				
				SharedPreferences spf=getSharedPreferences("regdet",MODE_WORLD_WRITEABLE);
				Editor regis=spf.edit();
				regis.putString("username", user);
				regis.putString("Newpassword", paswrd);
				regis.putString("Sequrity", seq);
				regis.putString("Answer", ans);
				
				regis.commit();
				Intent in=new Intent(getApplicationContext(),entry_java.class);
				startActivity(in);
				}
				else
				{
					Toast.makeText(getApplicationContext(),"password and confirm password didnot match" ,Toast.LENGTH_LONG).show();
				}
				
				
			}
		});
	}

}
