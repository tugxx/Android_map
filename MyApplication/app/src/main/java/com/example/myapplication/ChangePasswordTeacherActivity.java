package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.presenter.ChangePasswordTeacherPresenter;
import com.example.myapplication.presenter.IChangePasswordTeacherPresenter;
import com.example.myapplication.view.IChangePasswordTeacherView;

public class ChangePasswordTeacherActivity extends AppCompatActivity implements IChangePasswordTeacherView, View.OnClickListener {
    private ImageView img_btn_home, img_btn_back, ic_eye_new, ic_eye_old, ic_eye_confirm;
    private EditText edt_oldpassword, edt_newpassword, edt_confirmpassword;
    private Button btn_changepass;
    String id_teacher;
    private IChangePasswordTeacherPresenter changePasswordTeacherPresenter = new ChangePasswordTeacherPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_change_password_teacher);
        mapping();

        img_btn_back.setOnClickListener(this); // Back <
        img_btn_home.setOnClickListener(this); // Home
        btn_changepass.setOnClickListener(this); // Change Password
        ic_eye_new.setOnClickListener(this); // Eye in old password
        ic_eye_old.setOnClickListener(this); // Eye in New Password
        ic_eye_confirm.setOnClickListener(this); // Eye in Confirm password
    }

    public void mapping() {
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home_teacher); // Home
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back_teacher); // Back <
        edt_oldpassword = (EditText) findViewById(R.id.edt_oldpassword); // Old Password
        edt_newpassword = (EditText) findViewById(R.id.edt_newpassword); // New Password
        edt_confirmpassword = (EditText) findViewById(R.id.edt_confirm_password); // Confirm password
        btn_changepass = (Button) findViewById(R.id.btn_update_teacher); // Change Password
        ic_eye_new = (ImageView) findViewById(R.id.ic_eye_new); // Eye in Old Password
        ic_eye_old = (ImageView) findViewById(R.id.ic_eye_old); // Eye in New Password
        ic_eye_confirm = (ImageView) findViewById(R.id.ic_eye_confirm); // Eye in Confirm password
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_home_teacher) { // Home
            Intent teacher = new Intent(this, TeacherActivity.class); /// --> Turn to TeacherActivity
            teacher.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacher);

        } else if (v.getId() == R.id.img_btn_back_teacher) { // Back <
            Intent teacherinfor = new Intent(this, ProfileTeacherActivity.class); /// --> Turn to ProfileTeacherActivity
            teacherinfor.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacherinfor);

        } else if (v.getId() == R.id.btn_update_teacher) { // Change Password
            if (edt_newpassword.getText().toString().trim().equals(edt_confirmpassword.getText().toString().trim())) {
                changepassword(); /// Turn to line 104
            } else {
                Toast.makeText(this, "Confirm password incorrect!", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.ic_eye_new) { // Eye in Old Password
            if (ic_eye_new.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.eye).getConstantState())) {
                ic_eye_new.setImageResource(R.drawable.eye_closed);
                edt_oldpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                ic_eye_new.setImageResource(R.drawable.eye);
                edt_oldpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }

        } else if (v.getId() == R.id.ic_eye_old) { // Eye in New Password
            if (ic_eye_old.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.eye).getConstantState())) {
                ic_eye_old.setImageResource(R.drawable.eye_closed);
                edt_newpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                ic_eye_old.setImageResource(R.drawable.eye);
                edt_newpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }

        } else if (v.getId() == R.id.ic_eye_confirm) { // Eye in Confirm password
            if (ic_eye_confirm.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.eye).getConstantState())) {
                ic_eye_confirm.setImageResource(R.drawable.eye_closed);
                edt_confirmpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                ic_eye_confirm.setImageResource(R.drawable.eye);
                edt_confirmpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        }
    }

    public void changepassword() {
        Intent intent_student = getIntent();
        id_teacher = intent_student.getStringExtra("ID_TEACHER");
        String old_password = edt_oldpassword.getText().toString().trim();
        String new_password = edt_newpassword.getText().toString().trim();
        /// --> Turn to ChangePasswordTeacherPresenter (Line 24)
        changePasswordTeacherPresenter.checkChangePass(id_teacher, old_password, new_password, this);
    }

    @Override
    public void ChangeResult(int checkresult) {
        if (checkresult == 1) {
            Toast.makeText(this, "Change Password Successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Old Password Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }
}
