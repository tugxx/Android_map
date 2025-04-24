package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.TimePresentAdapterForStudentActivity;
import com.example.myapplication.adapter.TimePresentAdapterForTeacherActivity;
import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.PresentTeacherModel;
import com.example.myapplication.presenter.IPresentTeacherPresenter;
import com.example.myapplication.presenter.PresentTeacherPresenter;
import com.example.myapplication.view.IPresentTimeTeacherView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class PresentTimeTeacherActivity extends AppCompatActivity implements IPresentTimeTeacherView, View.OnClickListener {
    private TextView txt_search_time_teacher;
    private ListView list_time_for_teacher;
    private String Id_class_present;
    private String Class_time_start;
    IPresentTeacherPresenter PresentTeacherPresenter = new PresentTeacherPresenter(this);
    TimePresentAdapterForTeacherActivity timePresentAdapterForTeacher;
    String teacher_id;
    ImageView img_btn_back, img_btn_home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_present_teacher_list_time);
        mapping();

        txt_search_time_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Choosetime();
            } // Turn to line 79
        });

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("ID_TEACHER");

        img_btn_back.setOnClickListener(this); /// Back <
        img_btn_home.setOnClickListener(this); /// Home 
    }


    public void mapping() {
        txt_search_time_teacher = (TextView) findViewById(R.id.txt_search_time_teacher); // Choose date
        list_time_for_teacher = (ListView) findViewById(R.id.list_present_time_for_teacher); // List view
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); // Back <
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home); // Home

    }

    public void Loadtimepresentforteacher() {
        Intent intent = getIntent();
        Id_class_present = intent.getStringExtra("ID_CLASS");
        Class_time_start = intent.getStringExtra("CLASS_TIME"); // time For start class
        list_time_for_teacher.setAdapter(null);
        PresentTeacherPresenter.doLoadListTime(Id_class_present, txt_search_time_teacher.getText().toString(),Class_time_start ,this);
    }

    public void Choosetime() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txt_search_time_teacher.setText(simpleDateFormat.format(calendar.getTime()));
                Loadtimepresentforteacher(); // Turn to line 98
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onLisTimeTeacherResult(ArrayList<PresentTeacherModel> list_time) {
        timePresentAdapterForTeacher = new TimePresentAdapterForTeacherActivity(list_time);
        list_time_for_teacher.setAdapter(timePresentAdapterForTeacher); /// --> Turn to TimePresentAdapterForTeacherActivity (Line 42)
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) { // Back <
            Intent teacher1 = new Intent(this, PresentTeacherActivity.class); // --> Turn to PresentTeacherActivity
            teacher1.putExtra("ID_TEACHER", teacher_id);  // Truyền ID_TEACHER
            startActivity(teacher1);
            finish();
        } else if (v.getId() == R.id.img_btn_home) { // Home
            Intent teacher = new Intent(this, TeacherActivity.class); // --> Turn to TeacherActivity
            teacher.putExtra("ID_TEACHER", teacher_id);  // Truyền ID_TEACHER
            startActivity(teacher);
            finish();
        }
    }
}
