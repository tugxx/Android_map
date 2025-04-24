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

import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.presenter.IProfileTeacherPresenter;
import com.example.myapplication.presenter.ProfileTeacherPresenter;
import com.example.myapplication.view.IProfileTeacherView;
import com.squareup.picasso.Picasso;

public class TeacherActivity extends AppCompatActivity implements IProfileTeacherView, View.OnClickListener {
    private Button btn_attendence_teacher, btn_information_teacher, btn_classlist_teacher, btn_schedule_teacher, btn_present_teacher, btn_absent_teacher,btn_about;
    private ImageView img_logout_teacher, img_avatar_main_teacher;
    private String id_teacher;
    private TextView numberId_main_teacher, fullname_main_teacher;
    private IProfileTeacherPresenter profileTeacherPresenter = new ProfileTeacherPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.acctivity_main_teacher);
        mapping(); // Turn to line 50
        Intent intent_teacher = getIntent();
        id_teacher = intent_teacher.getStringExtra("ID_TEACHER");
//        System.out.println("TeacherActivity + onCreate");
        profileTeacherPresenter.getIDMainTeacher(id_teacher, this); // --> Turn into ProfileTeacherPresenter (Line 35) (Done)

        btn_attendence_teacher.setOnClickListener(this); // Attendence
        btn_present_teacher.setOnClickListener(this); // Present
        btn_absent_teacher.setOnClickListener(this); // Absent
        btn_classlist_teacher.setOnClickListener(this); // Class list
        btn_schedule_teacher.setOnClickListener(this); // Schedule
        img_logout_teacher.setOnClickListener(this); // Logout
        btn_information_teacher.setOnClickListener(this); // Information
        btn_about.setOnClickListener(this); // Version app
    }

    public void mapping() {
        btn_attendence_teacher = (Button) findViewById(R.id.btn_attendence_teacher); // Attendence
        img_logout_teacher = (ImageView) findViewById(R.id.img_logout); // Logout
        btn_information_teacher = (Button) findViewById(R.id.btn_information_teacher); // Information
        img_avatar_main_teacher = (ImageView) findViewById(R.id.img_avatar_main_teacher); // Avatar
        fullname_main_teacher = (TextView) findViewById(R.id.fullname_main_teacher); // Full name
        numberId_main_teacher = (TextView) findViewById(R.id.Number_ID_main_teacher); // Teacher number
        btn_present_teacher = (Button) findViewById(R.id.btn_present_teacher); // Present
        btn_absent_teacher = (Button) findViewById(R.id.btn_absent_teacher); // Absent
        btn_classlist_teacher = (Button) findViewById(R.id.btn_classlist_teacher); // Class list
        btn_schedule_teacher = (Button) findViewById(R.id.btn_schedule_teacher); // Schedule
        btn_about = (Button) findViewById(R.id.btn_about); // Version app
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_attendence_teacher) { // Attendence (Done)
            Intent teacher = new Intent(this, AttendenceTeacherActivity.class); /// --> Turn to AttendenceTeacherActivity
            teacher.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacher);

        } else if (v.getId() == R.id.btn_present_teacher) { // Present (Done)
            Intent teacher1 = new Intent(this, PresentTeacherActivity.class); /// --> Turn to PresentTeacherActivity
            teacher1.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacher1);

        } else if (v.getId() == R.id.btn_absent_teacher) { // Absent (Done)
            Intent teacher2 = new Intent(this, AbsentTeacherActivity.class); /// --> Turn to AbsentTeacherActivity
            teacher2.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacher2);

        } else if (v.getId() == R.id.img_logout) { // Logout (Done)
            AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivity.this);
            builder.setTitle("LOGOUT ACCOUNT")
                    .setMessage("You sure, that you want to logout?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class); /// --> Turn to LoginActivity
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert11 = builder.create();
            alert11.show();

        } else if (v.getId() == R.id.btn_classlist_teacher) { // Class list (Done)
            Intent teacherClassList = new Intent(this, TClassListActivity.class); /// --> Turn to TClassListActivity
            teacherClassList.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacherClassList);

        } else if (v.getId() == R.id.btn_schedule_teacher) { // Schedule (Done)
            Intent teacherSchedule = new Intent(this, TeacherScheduleActivity.class); /// --> Turn to TeacherScheduleActivity
            teacherSchedule.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacherSchedule);

        } else if (v.getId() == R.id.btn_information_teacher) { // Information (Done)
            Intent teacher01 = new Intent(this, ProfileTeacherActivity.class); /// --> Turn to ProfileTeacherActivity
            teacher01.putExtra("ID_TEACHER", id_teacher);
            startActivity(teacher01);

        } else if (v.getId() == R.id.btn_about) { // Version app
            Intent about = new Intent(this, AboutActivity.class); /// --> Turn to AboutActivity
            about.putExtra("ID_TEACHER", id_teacher);
            startActivity(about);
        }
    }

    @Override
    public void showInforTeacher(String teacher_id, String teacher_name, String teacher_birth, String teacher_gender, String teacher_mail, String teacher_phone, String teacher_image) {}

    @Override
    public void updateSuccessfully(int result) {}

    @Override
    public void showInforTeacherMain(String teacher_id, String teacher_name, String teacher_image) {
        numberId_main_teacher.setText(teacher_id);
        fullname_main_teacher.setText(teacher_name);
        IPConfigModel ipConfigModel = new IPConfigModel();
        String path = "http://"+ipConfigModel.getIpconfig()+"/PHP_API/Upload/teacher_images/"+teacher_image;
//        System.out.println("TeacherActivity + showInforTeacherMain "+path);
        Picasso.get().load(path).into(img_avatar_main_teacher);
    }
}
