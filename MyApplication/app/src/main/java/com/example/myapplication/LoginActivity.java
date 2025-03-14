package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.presenter.ILoginPresenter;
import com.example.myapplication.presenter.LoginPresenter;
import com.example.myapplication.view.ILoginView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import androidx.core.graphics.drawable.DrawableCompat;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private EditText edt_user,edt_password;
    private Button btn_login;
    private TextView btn_text_forgot;
    private ILoginPresenter loginPresenter;
    private CheckBox cb_remeberme;
    private ImageView ic_eye;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE); // displayed without the default title bar
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // fullscreen mode
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("DataLogin", MODE_PRIVATE);
        mapping(); // Line 59

        // Set text (rarely use)
        edt_user.setText(sharedPreferences.getString("email","student"));
        edt_password.setText(sharedPreferences.getString("password","1234"));
        cb_remeberme.setChecked(sharedPreferences.getBoolean("checked",false));

        // static type: ILoginPresenter, dynamic type: LoginPresenter
        loginPresenter = new LoginPresenter(this); // ILoginPresenter --> LoginPresenter (Line 16)

        //Set button Listener
        btn_login.setOnClickListener(this); // Done
        btn_text_forgot.setOnClickListener(this); // Half Done
        ic_eye.setOnClickListener(this); // Done
    }

    public void mapping() {
        edt_user = (EditText) findViewById(R.id.edt_username); // Username
        edt_password = (EditText) findViewById((R.id.edt_password)); // Password
        btn_login = (Button) findViewById(R.id.btn_login); // Login
        btn_text_forgot = (TextView) findViewById(R.id.btn_text_forgot); // Forgot Password
        cb_remeberme = (CheckBox) findViewById(R.id.cb_remeberme); // Remember me
        ic_eye = (ImageView) findViewById(R.id.ic_eye_new); // Show Password
    }

    @Override
    public void onClick(View v) {
        // press login button
        if (v.getId() == R.id.btn_login) {
            // Turn to CheckLogin() Line 150
            if (CheckLogin() == 1) { // either the username or password field is empty
//                System.out.println("LoginActivity Line 73");
                Toast.makeText(this, "Username hoặc Password trống ! Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
            } else if (CheckLogin() == 2) { // username contains special characters
//                System.out.println("LoginActivity Line 76");
                Toast.makeText(this, "Username chứa kí tự đặc biệt ! Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
            } else { // validation passed
//                System.out.println("LoginActivity + onClick + validation passed");
                // --> Turn to LoginPresenter (Line 24)
                loginPresenter.doLogin(edt_user.getText().toString().trim(), edt_password.getText().toString().trim(), this);
            }

        // press Forgot Password Button
        } else if (v.getId() == R.id.btn_text_forgot) {
//            System.out.println("LoginActivity - onClick -- Forgot Password");
            // --> Turn to ForgotPassActivity
            startActivity(new Intent(LoginActivity.this, ForgotPassActivity.class));

        // press Eye Icon for Password Visibility
        } else if (v.getId() == R.id.ic_eye_new) {
            if (ic_eye.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.eye).getConstantState())) {
                ic_eye.setImageResource(R.drawable.eye_closed);
                edt_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                ic_eye.setImageResource(R.drawable.eye);
                edt_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        }
    }

    @Override
    public void onLoginResult(String role, String id_teacher, String id_student) {
        if (role.equals("1")) { // Admin
            handlePreferences();
            // --> Turn to AdminActivity
            System.out.println("LoginActivity + onLoginResult + Admin");
            startActivity(new Intent(LoginActivity.this, AdminActivity.class));
            finish();
        } else if (role.equals("2")) { // Teacher
            System.out.println("LoginActivity + onLoginResult + Teacher");
            handlePreferences();
            // --> Turn to TeacherActivity
            Intent teacher = new Intent(this, TeacherActivity.class);
            teacher.putExtra("ID_TEACHER", id_teacher); // Truyền ID_TEACHER
            startActivity(teacher);
            finish();
        } else if (role.equals("3")) { // Student
            handlePreferences();
            // --> Turn to StudentActivity
            Intent student = new Intent(this, StudentActivity.class);
            student.putExtra("ID_STUDENT", id_student); // Truyền ID_STUDENT
            startActivity(student);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void handlePreferences() { // Remember me button
        if(cb_remeberme.isChecked()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", edt_user.getText().toString());
            editor.putString("password",edt_password.getText().toString());
            editor.putBoolean("checked",true);
            editor.apply();
        }
        else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("email");
            editor.remove("password");
            editor.remove("checked");
            editor.apply();
        }
    }
    public int CheckLogin() {
        String username = edt_user.getText().toString().trim();
        String password = edt_password.getText().toString().trim();
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(username);
        boolean b = matcher.find();

        if (username.equals("") || password.equals(""))
            return 1;
        else if (b == true)
            return 2;
        else
            return 0;
    }

}
