package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.ScheduleStudentAdapterActivity;
import com.example.myapplication.adapter.StudentAdapter;
import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.model.ScheduleModel;
import com.example.myapplication.model.StudentModel;
import com.example.myapplication.presenter.IScheduleStudentPresenter;
import com.example.myapplication.presenter.IStudentListPresenter;
import com.example.myapplication.presenter.ScheduleStudentPresenter;

import com.example.myapplication.view.IScheduleStudentView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StudentScheduleActivity extends AppCompatActivity implements IScheduleStudentView,View.OnClickListener {
    //MVP
    private ListView list;
    private String id_student,class_name;
    private IScheduleStudentPresenter iScheduleStudentView = new ScheduleStudentPresenter(this);
    ArrayList<ScheduleModel> List_Schedule;
    private ImageView img_btn_back;
    ScheduleStudentAdapterActivity scheduleStudentAdapterActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_student);
        AnhXa(); // Turn to line 79
        LoadScheduleForStudent(); // Turn to line 72

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // Done
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // --> Turn to ScheduleStudentAdapterActivity (Line 39)
                ScheduleModel scheduleModel = (ScheduleModel) scheduleStudentAdapterActivity.getItem(position);

                //Do in Click Class
                Intent intent = new Intent(view.getContext() , ScheduleDetailStudentActivity.class); // --> Turn to ScheduleDetailStudentActivity
                intent.putExtra("SCHEDULE_ID", scheduleModel.getS_id());
                intent.putExtra("SCHEDULE_NAME", scheduleModel.getS_name());
                intent.putExtra("SCHEDULE_TEACHER", scheduleModel.getTeacher_id());
                intent.putExtra("SCHEDULE_DAY", scheduleModel.getS_daybegin());
                intent.putExtra("SCHEDULE_TIME", scheduleModel.getS_tstart()+"-"+scheduleModel.getS_tend());
                intent.putExtra("SCHEDULE_LOCATION", scheduleModel.getS_location());
                intent.putExtra("SCHEDULE_NOTE", "Note rỗng :v");// Truyền Schedule
                intent.putExtra("ID_STUDENT", id_student);
                startActivity(intent);
            }
        });

        img_btn_back.setOnClickListener(this); // Back <
    }

    public void LoadScheduleForStudent() {
        Intent intent = getIntent();
        id_student =intent.getStringExtra("ID_STUDENT");
//        System.out.println("StudentScheduleActivity + LoadScheduleForStudent");
        iScheduleStudentView.doLoadListSchedule(id_student, this); // --> Turn to ScheduleStudentPresenter (Line 25)
    }

    public void AnhXa() {
        list = findViewById(R.id.recyclerView); // List View
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); // Back <
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) {
            Intent intent = new Intent(this, StudentActivity.class);
            intent.putExtra("ID_STUDENT", id_student);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onListScheduleStudentResult(ArrayList<ScheduleModel> List_Schedule) {
        //        System.out.println("StudentScheduleActivity + onListScheduleStudentResult");

        // Change the ListView using getView in ScheduleStudentAdapterActivity (Line 49)
        scheduleStudentAdapterActivity = new ScheduleStudentAdapterActivity(this,List_Schedule);
        list.setAdapter(scheduleStudentAdapterActivity);
    }
}
