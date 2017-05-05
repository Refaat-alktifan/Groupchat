package com.andrody.test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Abboudi_Aliwi on 10/24/2015.
 */
public class Login extends Activity {
    EditText uName;
    TextView text1;
    String Name;
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        settings = getSharedPreferences("NAME", 0);
        Boolean check = settings.getBoolean("check", false);


        uName = (EditText) findViewById(R.id.user);
        text1 = (TextView) findViewById(R.id.text1);


        if (check) {
            Intent i = new Intent(Login.this,MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    public void onClick(View v) {

        Name = uName.getText().toString();

        if(Name.isEmpty() || Name.trim().length() < 3){
            text1.setText("من فضلك أدخل اسمك على أن لا يقل عن ثلاث أحرف");
        }else {
            settings = getSharedPreferences("NAME", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("check", true);
            editor.putString("name", Name);
            editor.apply();
            Intent i1 = new Intent(Login.this,MainActivity.class);
            startActivity(i1);
            finish();
        }

    }
}