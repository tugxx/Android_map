package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.example.myapplication.Ultils.OTPCode;

import java.util.concurrent.TimeUnit;

public class VerifyOTPActivity extends AppCompatActivity {

    EditText inputCode1, inputCode2, inputCode3, inputCode4, inputCode5, inputCode6;
    TextView phoneNumber,tvResend;
    Button btnVerifyOTP;
    private String str_otp_entered=null;
    private String smsCode = null;

    // nếu code gửi fail, sử dụng tính năng resend
    private PhoneAuthProvider.ForceResendingToken forceResendingToken;

    // hàm để nhận biết code đã đc gửi hay chưa
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    private String mVerificationId; // giữ OTP/ verify OTP

    // Kết nối với firebase gọi ra để dùng
    private FirebaseAuth firebaseAuth;

    private static final String TAG = "MAIN_TAG";


    // progres dialog cái này để hiển thị cái màn hình chờ gửi code
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        initView();
        smsCode = OTPCode.getSms_code();
        btnVerifyOTP.setOnClickListener(v -> {
            str_otp_entered = inputCode1.getText().toString() + inputCode2.getText().toString() + inputCode3.getText().toString() + inputCode4.getText().toString()
                    + inputCode5.getText().toString() + inputCode6.getText().toString();
            if(str_otp_entered.length()<6)
            {
                inputCode6.requestFocus();
                inputCode6.setError("Need fill enough 6 digits of OTP");
                return;
            }
            PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                    OTPCode.getOtp_code(),
                    str_otp_entered
            );
            FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        ///change screen
                        Intent intent = new Intent(VerifyOTPActivity.this,ChangePassActivity.class);
                        if (savedInstanceState == null) {
                            Bundle extras = getIntent().getExtras();
                            intent.putExtra("username", extras.getString("username"));
                        } else {
                            intent.putExtra("username",  (String) savedInstanceState.getSerializable("username"));
                        }
                            startActivity(intent);
                    }
                    else
                    {

                        Toast.makeText(VerifyOTPActivity.this, "Mã OTP không đúng !", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
        tvResend.setOnClickListener(v ->{
            resendPhoneNumberVerification(OTPCode.getPhoneNumber(),forceResendingToken);
        });

        // trong progress dialog
        pd = new ProgressDialog(this);
        pd.setTitle("Please wait....");
        pd.setCanceledOnTouchOutside(false);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            // verify thành công
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                OTPCode.setSms_code(phoneAuthCredential.getSmsCode());
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }


            // verify cái code bị sai
            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                pd.dismiss();
                Toast.makeText(VerifyOTPActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            // Cái này sau khi nó chạy xong cái màn hình dialog và gửi code tới đth
            // thì ẩn cái phoneLl đi hiện cái codeLl lên
            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                super.onCodeSent(verificationId, forceResendingToken);
                Log.d(TAG, "onCodeSent: " + verificationId);
                mVerificationId = verificationId;
                forceResendingToken = token;
                pd.dismiss();
                OTPCode.setOtp_code(verificationId);
                inputCode1.setText("");
                inputCode2.setText("");
                inputCode3.setText("");
                inputCode4.setText("");
                inputCode5.setText("");
                inputCode6.setText("");

                //change screen to Verify OTP SCreen
                ///change screen
                Toast.makeText(VerifyOTPActivity.this, "Verification code has been resend.....", Toast.LENGTH_SHORT).show();

            }
        };
    }

    void initView()
    {
        inputCode1 = findViewById(R.id.inputCode1);
        inputCode2 = findViewById(R.id.inputCode2);
        inputCode3 = findViewById(R.id.inputCode3);
        inputCode4 = findViewById(R.id.inputCode4);
        inputCode5 = findViewById(R.id.inputCode5);
        inputCode6 = findViewById(R.id.inputCode6);

        phoneNumber = findViewById(R.id.phoneNumber);
        tvResend = findViewById(R.id.tvResend);

        btnVerifyOTP = findViewById(R.id.btnVerifyOTP);

        inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1) inputCode2.requestFocus();
            }
        });
        inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1) inputCode3.requestFocus();
            }
        });
        inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1) inputCode4.requestFocus();
            }
        });
        inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1) inputCode5.requestFocus();
            }
        });
        inputCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1) inputCode6.requestFocus();
            }
        });
    }

    // hàm resend code khi chưa nhận được
    private void resendPhoneNumberVerification(String phone, PhoneAuthProvider.ForceResendingToken token) {
        pd.setMessage("Resending code");
        pd.show();

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(phone)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(VerifyOTPActivity.this)
                        .setCallbacks(mCallbacks)
                        .setForceResendingToken(token)
                        .build();

        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    // Hàm verify cái code nhận được
    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        pd.setMessage("Verifying code");
        pd.show();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithPhoneAuthCredential(credential);

    }

    // hàm này để kiểm tra cái code và login vào
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        pd.setMessage("Logging in");
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //Sucessfully
                        pd.dismiss();
                        String phone = firebaseAuth.getCurrentUser().getPhoneNumber();
                        Toast.makeText(VerifyOTPActivity.this, "Logged In as", Toast.LENGTH_SHORT).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // failure
                        pd.dismiss();
                        Toast.makeText(VerifyOTPActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }



}