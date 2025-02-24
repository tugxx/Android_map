package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DeatailStudentActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvClass, tvPhone, tvEmail, tvDoB, tvSId,tvName;
    private ImageView img_btn_back,img_btn_home;
    String student_id,student_name ,student_mail, student_phone,student_dob,student_class ;
    String id_student,class_id,checklayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_studentdetail);
        AnhXa();
        //lay thong tin
        Intent intent = getIntent();
        student_id =intent.getStringExtra("STUDENT_ID");
        student_name =intent.getStringExtra("STUDENT_NAME");
        student_mail =intent.getStringExtra("STUDENT_EMAIL");
        student_phone =intent.getStringExtra("STUDENT_PHONE");
        student_dob =intent.getStringExtra("STUDENT_DOB");
        student_class =intent.getStringExtra("STUDENT_CLASS");
        id_student =intent.getStringExtra("ID_STUDENT");
        class_id = intent.getStringExtra("ID_CLASS");
        checklayout = intent.getStringExtra("checklayout");
        tvClass.setText(student_class);
        tvName.setText(student_name);
        tvDoB.setText(student_dob);
        tvPhone.setText(student_phone);
        tvEmail.setText(student_mail);
        tvSId.setText(student_id);
        //bắt sự kiện click
        img_btn_home.setOnClickListener(this);
        img_btn_back.setOnClickListener(this);
    }

    private void AnhXa() {
        tvName = (TextView) findViewById(R.id.tvName);
        tvClass = (TextView) findViewById(R.id.tvClass);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDoB = (TextView) findViewById(R.id.tvDoB);
        tvSId = (TextView) findViewById(R.id.tvSId);
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home);
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.img_btn_home:
//                Intent intent = new Intent(this, StudentActivity.class);
//                intent.putExtra("ID_STUDENT", id_student);
//                startActivity(intent);
//                finish();
//                break;
//            case R.id.img_btn_back:
//                if (checklayout.equals("1"))
//                {
//                    Intent intent1 = new Intent(this, StudentListActivity.class);
//                    intent1.putExtra("ID_STUDENT", id_student);
//                    intent1.putExtra("ID_CLASS", class_id);
//                    startActivity(intent1);
//                    finish();
//                } else
//                {
//                    Intent intent1 = new Intent(this, SclassListDetailActivity.class);
//                    intent1.putExtra("ID_STUDENT", id_student);
//                    intent1.putExtra("ID_CLASS", class_id);
//                    intent1.putExtra("CLASS_NAME", student_class);
//                    startActivity(intent1);
//                    finish();
//                    break;
//                }
//
//        }

        if (v.getId() == R.id.img_btn_home) {
            Intent intent = new Intent(this, StudentActivity.class);
            intent.putExtra("ID_STUDENT", id_student);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.img_btn_back) {
            if (checklayout.equals("1")) {
                Intent intent1 = new Intent(this, StudentListActivity.class);
                intent1.putExtra("ID_STUDENT", id_student);
                intent1.putExtra("ID_CLASS", class_id);
                startActivity(intent1);
                finish();
            } else {
                Intent intent1 = new Intent(this, SclassListDetailActivity.class);
                intent1.putExtra("ID_STUDENT", id_student);
                intent1.putExtra("ID_CLASS", class_id);
                intent1.putExtra("CLASS_NAME", student_class);
                startActivity(intent1);
                finish();
            }
        }
    }
}
