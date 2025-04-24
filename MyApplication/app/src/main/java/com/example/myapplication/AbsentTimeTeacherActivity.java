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

import com.example.myapplication.adapter.AbsentAdappterForTeacher;
import com.example.myapplication.adapter.TimePresentAdapterForTeacherActivity;
import com.example.myapplication.model.AbsentTeacherModel;
import com.example.myapplication.presenter.AbsentTeacherPresenter;
import com.example.myapplication.presenter.IAbsentTeacherPresenter;
import com.example.myapplication.view.IAbsentTimeTeacherView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
public class AbsentTimeTeacherActivity extends AppCompatActivity implements IAbsentTimeTeacherView,View.OnClickListener {
    private TextView txt_choose_time_teacher;
    private ListView list_absent_for_teacher;
    private String Id_class_absent;
    // no adapter
    IAbsentTeacherPresenter absentTeacherPresenter = new AbsentTeacherPresenter(this);
    AbsentAdappterForTeacher absentAdappterForTeacher;
    ImageView img_btn_back, img_btn_home;
    String teacher_id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_absent_teacher_list);
        mapping();

        txt_choose_time_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Choosetime();
            } // Turn to line 73
        });

        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("ID_TEACHER");

        img_btn_back.setOnClickListener(this); // Back <
        img_btn_home.setOnClickListener(this); // Home
    }

    public void mapping() {
        txt_choose_time_teacher = (TextView) findViewById(R.id.txt_choose_time_teacher); // Choose Date
        list_absent_for_teacher = (ListView) findViewById(R.id.list_absent_for_teacher); // List view
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); /// Back <
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home); /// Home
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
                txt_choose_time_teacher.setText(simpleDateFormat.format(calendar.getTime()));
                LoadtimeAbsentforteacher(); // Turn to line 84
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    public void LoadtimeAbsentforteacher() {
        Intent intent = getIntent();
        Id_class_absent = intent.getStringExtra("ID_CLASS");
        list_absent_for_teacher.setAdapter(null);
        /// --> Turn to AbsentTeacherPresenter (Line 39)
        absentTeacherPresenter.doLoadListStudent(Id_class_absent, txt_choose_time_teacher.getText().toString(),this);
    }

    @Override
    public void onLisTimeTeacherResult(ArrayList<AbsentTeacherModel> list_absent) {
        absentAdappterForTeacher = new AbsentAdappterForTeacher(list_absent);
        list_absent_for_teacher.setAdapter(absentAdappterForTeacher); /// --> Turn to AbsentAdappterForTeacher (Line 42)
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) { // Back <
            Intent teacher1 = new Intent(this, AbsentTeacherActivity.class); // --> Turn to AbsentTeacherActivity
            teacher1.putExtra("ID_TEACHER", teacher_id);  // Passing teacher ID
            startActivity(teacher1);
            finish();
        } else if (v.getId() == R.id.img_btn_home) { /// Home
            Intent teacher = new Intent(this, TeacherActivity.class); /// --> Turn to TeacherActivity
            teacher.putExtra("ID_TEACHER", teacher_id);  // Passing teacher ID
            startActivity(teacher);
            finish();
        }
    }
}
