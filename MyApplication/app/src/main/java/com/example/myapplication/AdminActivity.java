package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity  extends AppCompatActivity implements View.OnClickListener{
    private Button btn_usermanager_admin, btn_student_admin,btn_teacher_admin, btn_class_admin;
    private ImageView btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_admin);
        mapping();

        btn_usermanager_admin.setOnClickListener(this);
        btn_student_admin.setOnClickListener(this);
        btn_teacher_admin.setOnClickListener(this);
        btn_class_admin.setOnClickListener(this);
    }

    public void mapping() {
        btn_usermanager_admin = (Button) findViewById(R.id.btn_manageruser_admin);
        btn_student_admin = (Button) findViewById(R.id.btn_student_admin);
        btn_teacher_admin = (Button) findViewById(R.id.btn_teacher_admin);
        btn_class_admin = (Button) findViewById(R.id.btn_class_admin);
        btn_logout = (ImageView) findViewById(R.id.img_logout);

    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_manageruser_admin:
//                startActivity(new Intent(AdminActivity.this, UserAdminActivity.class));
//                finish();
//                break;
//            case R.id.btn_student_admin:
//                startActivity(new Intent(AdminActivity.this, StudentAdminActivity.class));
//                finish();
//                break;
//            case R.id.btn_teacher_admin:
//                startActivity(new Intent(AdminActivity.this, TeacherAdminActivity.class));
//                finish();
//                break;
//            case R.id.btn_class_admin:
//                startActivity(new Intent(AdminActivity.this, ClassAdminActivity.class));
//                finish();
//                break;
//            case R.id.img_logout:
//                AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
//                builder.setTitle("Confirmation PopUp!").
//                        setMessage("You sure, that you want to logout?");
//                builder.setPositiveButton("Yes",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                finish();
//                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                                startActivity(intent);
//                            }
//                        });
//                builder.setNegativeButton("No",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//                AlertDialog alert11 = builder.create();
//                alert11.show();
//                break;
//        }

        if (v.getId() == R.id.btn_manageruser_admin) {
            startActivity(new Intent(AdminActivity.this, UserAdminActivity.class));
            finish();
        } else if (v.getId() == R.id.btn_student_admin) {
            startActivity(new Intent(AdminActivity.this, StudentAdminActivity.class));
            finish();
        } else if (v.getId() == R.id.btn_teacher_admin) {
            startActivity(new Intent(AdminActivity.this, TeacherAdminActivity.class));
            finish();
        } else if (v.getId() == R.id.btn_class_admin) {
            startActivity(new Intent(AdminActivity.this, ClassAdminActivity.class));
            finish();
        } else if (v.getId() == R.id.img_logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
            builder.setTitle("Confirmation PopUp!")
                    .setMessage("Are you sure you want to logout?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder.create();
            alert11.show();
        }
    }
}
