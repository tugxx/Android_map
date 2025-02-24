package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddTeacherAdminActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView img_btn_back_teacher, img_btn_home_teacher;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_addteacher_admin);
        mapping();

        img_btn_back_teacher.setOnClickListener(this);
        img_btn_home_teacher.setOnClickListener(this);
    }
    private void mapping() {
        img_btn_back_teacher = (ImageView) findViewById(R.id.img_btn_back_teacher);
        img_btn_home_teacher = (ImageView) findViewById(R.id.img_btn_home_teacher);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.img_btn_back_teacher:
//                startActivity(new Intent(AddTeacherAdminActivity.this, TeacherAdminActivity.class));
//                finish();
//                break;
//            case R.id.img_btn_home_teacher:
//                startActivity(new Intent(AddTeacherAdminActivity.this, AdminActivity.class));
//                finish();
//                break;
//
//        }

        if (v.getId() == R.id.img_btn_back_teacher) {
            startActivity(new Intent(AddTeacherAdminActivity.this, TeacherAdminActivity.class));
            finish();
        } else if (v.getId() == R.id.img_btn_home_teacher) {
            startActivity(new Intent(AddTeacherAdminActivity.this, AdminActivity.class));
            finish();
        }
    }
}
