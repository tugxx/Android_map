package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.presenter.ChangePassPresenter;
import com.example.myapplication.presenter.IChangePassPresenter;
import com.example.myapplication.view.IChangePassView;


public class ChangePassActivity extends AppCompatActivity implements View.OnClickListener, IChangePassView {
    private Button btn_confirm;
    private EditText newpassedt,confirmpassedt;
    private String currentUsername=null;
    private IChangePassPresenter iChangePassPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        mapping(); // Line 42

        iChangePassPresenter = new ChangePassPresenter(this);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            currentUsername= extras.getString("username");
        } else {
            currentUsername= (String) savedInstanceState.getSerializable("username");
        }

        btn_confirm.setOnClickListener(this); // Reset Password
    }

    public void mapping() {
        btn_confirm = (Button) findViewById(R.id.btn_confirm); // Reset Password
        newpassedt = (EditText) findViewById(R.id.NewPassET); // New Password
        confirmpassedt = (EditText) findViewById(R.id.ConfirmPassET); // Confirm password
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_confirm) {
            String pass = newpassedt.getText().toString().trim();
            String config = confirmpassedt.getText().toString().trim();

            if (TextUtils.isEmpty(pass)) {
                newpassedt.requestFocus();
                newpassedt.setError("Không được để trống phần này");
                return;
            }

            // confirm password empty
            if (TextUtils.isEmpty(config)) {
                confirmpassedt.requestFocus();
                confirmpassedt.setError("Không được để trống phần này");
                return;
            }

            // new password matched confirm password
            if (!pass.equals(config)) {
                confirmpassedt.requestFocus();
                confirmpassedt.setError("Xác nhận mật khẩu và mật khẩu mới phải trùng khớp");
                return;
            }

            // --> Turn to ChangePassPresenter (Line 45)
            iChangePassPresenter.changePassword(currentUsername, newpassedt.getText().toString().trim());
        }
    }

    @Override
    public void updateSuccess(int checkresult) {}

    @Override
    public void responseChangePassword(String message) {
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        if(message.equals("Done"))
        {
            SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append("✓ ");
            builder.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.append("change password successfully");
            Toast.makeText(this, builder, Toast.LENGTH_LONG).show();
            // --> Turn to LoginActivity
            startActivity(new Intent(ChangePassActivity.this, LoginActivity.class));
        } else {
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        }
    }
}