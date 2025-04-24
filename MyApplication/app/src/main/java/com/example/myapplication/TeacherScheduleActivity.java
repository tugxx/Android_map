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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.adapter.ScheduleStudentAdapterActivity;
import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.model.ScheduleModel;
import com.example.myapplication.presenter.IScheduleStudentPresenter;
import com.example.myapplication.presenter.ITScheduleTeacherPresenter;
import com.example.myapplication.presenter.ScheduleStudentPresenter;
import com.example.myapplication.presenter.TScheduleTeacherPresenter;
import com.example.myapplication.view.ITScheduleTeacherView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TeacherScheduleActivity extends AppCompatActivity implements ITScheduleTeacherView, View.OnClickListener {
    //MVP
    private ListView list;
    private String id_teacher,class_name;
    private ITScheduleTeacherPresenter itScheduleTeacherPresenter = new TScheduleTeacherPresenter(this);
    ArrayList<ScheduleModel> List_Schedule;
    private ImageView img_btn_back;
    ScheduleStudentAdapterActivity scheduleStudentAdapterActivity;
    private TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_teacher);
        AnhXa(); /// Turn to line 81
        LoadScheduleForTeacher(); /// Turn to line 74

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ScheduleModel scheduleModel = (ScheduleModel) scheduleStudentAdapterActivity.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , ScheduleDetailStudentActivity.class); /// --> Turn to ScheduleDetailStudentActivity
                intent.putExtra("SCHEDULE_ID", scheduleModel.getS_id());
                intent.putExtra("SCHEDULE_NAME", scheduleModel.getS_name());
                intent.putExtra("SCHEDULE_TEACHER", scheduleModel.getTeacher_id());
                intent.putExtra("SCHEDULE_DAY", scheduleModel.getS_daybegin());
                intent.putExtra("SCHEDULE_TIME", scheduleModel.getS_tstart()+"-"+scheduleModel.getS_tend());
                intent.putExtra("SCHEDULE_LOCATION", scheduleModel.getS_location());
                intent.putExtra("SCHEDULE_NOTE", "Note is not Vlue");
                intent.putExtra("ID_TEACHER", id_teacher);
                startActivity(intent);
            }
        });
        img_btn_back.setOnClickListener(this);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedTime = now.format(formatter);
        textView8.setText("Ngày "+formattedTime);
    }

    public void LoadScheduleForTeacher() {
        Intent intent = getIntent();
        id_teacher =intent.getStringExtra("ID_TEACHER");
        itScheduleTeacherPresenter.doLoadListSchedule(id_teacher, this); /// --> Turn to TScheduleTeacherPresenter (Line 22)

    }

    public void AnhXa() {
        list = findViewById(R.id.recyclerView); // List view
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); // Back <
        textView8 = findViewById(R.id.textView8); // DateTime
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) { // Back <
            Intent intent = new Intent(this, TeacherActivity.class);
            intent.putExtra("ID_TEACHER", id_teacher);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onListScheduleStudentResult(ArrayList<ScheduleModel> List_Schedule) {
        scheduleStudentAdapterActivity = new ScheduleStudentAdapterActivity(this,List_Schedule);
        list.setAdapter(scheduleStudentAdapterActivity); /// --> Turn to ScheduleStudentAdapterActivity (Line 51)
    }
}
