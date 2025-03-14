package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_forgot;
    private  TextView text_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_call_phonenumber);
        mapping();
        btn_forgot.setOnClickListener(this);
    }

    public void mapping() {
        btn_forgot = (Button) findViewById(R.id.btn_forgot); // Contact
        text_phone = (TextView) findViewById(R.id.text_phone); // Phone number
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_forgot) { // press button Contact
            String number = text_phone.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + number));
            startActivity(callIntent);
        }
    }
}
