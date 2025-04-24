package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ScheduleStudentAdapterActivity;
import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.model.ScheduleModel;
import com.example.myapplication.model.StudentModel;
import com.example.myapplication.model.Teacher;

import java.util.ArrayList;

public class ScheduleDetailStudentActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView img_btn_back,img_btn_home;
    TextView textView_Class_Name, textView_Teacher_Name, textView_Date,
            textView_repeat, textView_location,textView_Schedule_Note,textView_Time,textView_Class_NameA;
    String s_id, s_name,s_tstart,s_tend,s_daybegin,s_dayend,student_id,s_location,teacher_id,s_note;
    String teacher_login, id_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduledetail_student);
        AnhXa(); // Turn to line 70

        Intent intent1 = getIntent();
        teacher_login = intent1.getStringExtra("ID_TEACHER");

        //lay thong tin
        Intent intent = getIntent();
        student_id =intent.getStringExtra("STUDENT_ID");
        s_id =intent.getStringExtra("SCHEDULE_ID");
        s_name = intent.getStringExtra("SCHEDULE_NAME");
        s_tstart = intent.getStringExtra("SCHEDULE_TIME");
        s_tend = intent.getStringExtra("SCHEDULE_TIME");
        s_daybegin = intent.getStringExtra("SCHEDULE_DAY");
        s_dayend = intent.getStringExtra("SCHEDULE_DAY");
        s_location = intent.getStringExtra("SCHEDULE_LOCATION");
        teacher_id = intent.getStringExtra("SCHEDULE_TEACHER");
        s_note = intent.getStringExtra("SCHEDULE_NOTE");

        // return Home
        img_btn_home.setOnClickListener(this);
        img_btn_back.setOnClickListener(this);

        // hiện thông tin
        textView_Class_Name.setText(s_name);
        textView_Class_NameA.setText(s_id);

        // co id teacher --> lay dc ten
        textView_Teacher_Name.setText(teacher_id);
        textView_Date.setText(s_daybegin);
        //textView_repeat.setText(schedule.getS_daybegin());
        textView_location.setText(s_location);
        textView_Schedule_Note.setText(s_note);
        textView_Time.setText(s_tend);
    }

    public void AnhXa() {
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home); // Home
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); // Back <
        textView_Class_Name = (TextView) findViewById(R.id.textView_Class_Name); // Class name
        textView_Teacher_Name = (TextView) findViewById(R.id.textView_Teacher_Name); // Teacher name
        textView_Date = (TextView) findViewById(R.id.textView_Date); // Date
        //textView_repeat = (TextView) findViewById(R.id.textView_repeat);
        textView_location = (TextView) findViewById(R.id.textView_location); // Location
        textView_Schedule_Note = (TextView) findViewById(R.id.textView_Schedule_Note); // Note
        textView_Time = (TextView) findViewById(R.id.textView_Time); // Time
        textView_Class_NameA = (TextView) findViewById(R.id.textView_Class_NameA); // Class name
    }

    @Override
    public void onClick(View v) {
        Intent id = getIntent();
        id_student =id.getStringExtra("ID_STUDENT");
        if (teacher_login == null) // Người dùng là sinh viên
        {
            if (v.getId() == R.id.img_btn_home) { // Home
                Intent intent = new Intent(this, StudentActivity.class); // --> Turn to StudentActivity
                intent.putExtra("ID_STUDENT", id_student);
                startActivity(intent);
                finish();
            } else if (v.getId() == R.id.img_btn_back) { // Back
                Intent intent1 = new Intent(this, StudentScheduleActivity.class); // --> Turn to StudentScheduleActivity
                intent1.putExtra("ID_STUDENT", id_student);
                startActivity(intent1);
                finish();
            }

        } else { // Người dùng là giáo viên
            if (v.getId() == R.id.img_btn_home) { // Home
                Intent intent = new Intent(this, TeacherActivity.class); // --> Turn to TeacherActivity
                intent.putExtra("ID_TEACHER", teacher_id);
                startActivity(intent);
                finish();
            } else if (v.getId() == R.id.img_btn_back) { // Back <
                Intent intent1 = new Intent(this, TeacherScheduleActivity.class); // // --> Turn to TeacherScheduleActivity
                intent1.putExtra("ID_TEACHER", teacher_id);
                startActivity(intent1);
                finish();
            }
        }
    }
}
