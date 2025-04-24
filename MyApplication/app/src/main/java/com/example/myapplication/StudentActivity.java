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
import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.presenter.IProfileStudentPresenter;
import com.example.myapplication.presenter.ProfileStudentPresenter;
import com.example.myapplication.view.IProfileStudentView;
import com.squareup.picasso.Picasso;

public class StudentActivity extends AppCompatActivity implements IProfileStudentView, View.OnClickListener {
    private Button btn_attendence_student, btn_information_student, btn_present_student, btn_schedule_student, btn_classlist_student, btn_studentlist_student, btn_about;
    private ImageView img_logout_student, img_avatar_main_student;
    private TextView fullname_main_student, numberId_main_student;
    private String id_student;
    private IProfileStudentPresenter profileStudentPresenter = new ProfileStudentPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_student);
        mapping();

        Intent intent_student = getIntent();
        id_student = intent_student.getStringExtra("ID_STUDENT");

//        System.out.println("StudentActivity");
        // --> Turn to ProfileStudentPresenter (Line 31) (Done)\
        profileStudentPresenter.getIDMainStudent(id_student, this); // tự động tải khi vào trang

        img_logout_student.setOnClickListener(this); // logout (Done)
        btn_attendence_student.setOnClickListener(this); // attendence (Done)
        btn_information_student.setOnClickListener(this); // information (Done)
        btn_present_student.setOnClickListener(this); // present (Done)
        btn_schedule_student.setOnClickListener(this); // Schedule (Done)
        btn_classlist_student.setOnClickListener(this); // class list (Done)
        btn_studentlist_student.setOnClickListener(this); // Student list (Done)
        // Search (NF) ??
        btn_about.setOnClickListener(this); // about (version app) (Done)
    }

    public void mapping() {
        img_logout_student = (ImageView) findViewById(R.id.img_logout); // logout
        btn_attendence_student = (Button) findViewById(R.id.btn_attendence_student); // attendence
        btn_information_student = (Button) findViewById(R.id.btn_information_student); // information
        btn_present_student = (Button) findViewById(R.id.btn_present_student); // present
        btn_schedule_student = (Button) findViewById(R.id.btn_schedule_student); // Schedule
        btn_classlist_student = (Button) findViewById(R.id.btn_classlist_student); // class list
        btn_studentlist_student = (Button) findViewById(R.id.btn_studentlist_student); // Student list
        img_avatar_main_student = (ImageView) findViewById(R.id.img_avatar_main_student); // avatar
        fullname_main_student = (TextView) findViewById(R.id.fullname_main_student); // Full Name
        numberId_main_student = (TextView) findViewById(R.id.Number_ID_main_teacher); // Student Number
        btn_about = (Button) findViewById(R.id.btn_about); // Version App
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_attendence_student) { // attendence (done)
            // --> Turn to AttendenceStudentActivity
//            System.out.println("StudentActivity + onClick + attendence");
            Intent studentattendance = new Intent(this, AttendenceStudentActivity.class); // --> Turn to AttendenceStudentActivity
            studentattendance.putExtra("ID_STUDENT", id_student);
            startActivity(studentattendance);

        } else if (v.getId() == R.id.btn_information_student) { // information (done)
            Intent student = new Intent(this, ProfileStudentActivity.class); // --> Turn to ProfileStudentActivity
            student.putExtra("ID_STUDENT", id_student);
            startActivity(student);

        } else if (v.getId() == R.id.btn_present_student) { // present (done)
            Intent studentpresent = new Intent(this, PresentStudentActivity.class); // --> Turn to PresentStudentActivity
            studentpresent.putExtra("ID_STUDENT", id_student);
            startActivity(studentpresent);

        } else if (v.getId() == R.id.btn_schedule_student) { // Schedule (Done)
            Intent studentschedule = new Intent(this, StudentScheduleActivity.class); // --> Turn to StudentScheduleActivity
            studentschedule.putExtra("ID_STUDENT", id_student);
            startActivity(studentschedule);

        } else if (v.getId() == R.id.btn_classlist_student) { // Class list (Done)
            Intent studentclasslist = new Intent(this, SClassListActivity.class); // --> Turn to SClassListActivity
            studentclasslist.putExtra("ID_STUDENT", id_student);
            startActivity(studentclasslist);

        } else if (v.getId() == R.id.btn_studentlist_student) { // Student list (Done)
            Intent studentlist = new Intent(this, StudentListActivity.class); // --> Turn to StudentListActivity (Done)
            studentlist.putExtra("ID_STUDENT", id_student);
            startActivity(studentlist);

        } else if (v.getId() == R.id.img_logout) { // Logout (Done)
            AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
            builder.setTitle("LOGOUT ACCOUNT")
                    .setMessage("You sure, that you want to logout?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class); // --> Turn to LoginActivity
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

        } else if (v.getId() == R.id.btn_about) { // Version App (Done)
            Intent about = new Intent(this, AboutActivity.class); // --> Turn to AboutActivity
            about.putExtra("ID_STUDENT", id_student);   // Truyền ID_STUDENT
            startActivity(about);
        }
    }

    @Override
    public void showInforStudent(String student_id, String student_name, String student_birth, String student_gender, String student_mail, String student_phone, String student_hinhanh) {

    }

    @Override
    public void updateSuccessfully(int result) {

    }

    @Override
    public void showInforStudentMain(String student_id, String student_name, String student_image) {
//        System.out.println("StudentActivity + showInforStudentMain" + student_name);
        numberId_main_student.setText(student_id);
        fullname_main_student.setText(student_name);
        IPConfigModel ipConfigModel = new IPConfigModel();
        String path = "http://"+ipConfigModel.getIpconfig()+"/PHP_API/Upload/student_images/"+student_image;
//        System.out.println("student_image "+path);
        Picasso.get().load(path).into(img_avatar_main_student);
    }
}
