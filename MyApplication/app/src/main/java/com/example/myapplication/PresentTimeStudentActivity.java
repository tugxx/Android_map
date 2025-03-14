package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.example.myapplication.adapter.ClassAdapterForStudentActivity;
import com.example.myapplication.adapter.ClassListAdapterForTeacherActivity;
import com.example.myapplication.adapter.TimePresentAdapterForStudentActivity;
import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.PresentStudentModel;
import com.example.myapplication.presenter.IPresentStudentPresenter;
import com.example.myapplication.presenter.PresentStudentPresenter;
import com.example.myapplication.view.IPresentStudentView;
import com.example.myapplication.view.IPresentTimeStudentView;

import java.util.ArrayList;

public class PresentTimeStudentActivity extends AppCompatActivity implements IPresentTimeStudentView,View.OnClickListener {
    private EditText txt_search_time_student;
    private ListView list_time_for_student;
    private IPresentStudentPresenter PresentStudentPresenter = new PresentStudentPresenter(this);
    private String Id_class_present;
    private String Id_student_present;
    ImageView img_btn_back, img_btn_home;
    ArrayList<ClassModel> listClass;
    TimePresentAdapterForStudentActivity timePresentAdapterForStudent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_present_student_list_time);

        LoadTimeForStudent(); // Turn to line 61
        mapping();
        img_btn_back.setOnClickListener(this);
        img_btn_home.setOnClickListener(this);
    }

    public void mapping() {
        txt_search_time_student = (EditText) findViewById(R.id.txt_search_class_student); // Search Class
        list_time_for_student = (ListView) findViewById(R.id.list_present_time_for_student); // List View
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); // Back <
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home); // Home
    }

    public void LoadTimeForStudent() {
        Intent intent = getIntent();
        Id_class_present = intent.getStringExtra("ID_CLASS");
        Id_student_present = intent.getStringExtra("ID_STUDENT");
        // --> Turn to PresentStudentPresenter (Line 37)
        PresentStudentPresenter.doLoadtimepresent(Id_class_present, Id_student_present, this);
    }

    @Override
    public void onListTimeStudentResult(ArrayList<PresentStudentModel> List_time) {
        timePresentAdapterForStudent = new TimePresentAdapterForStudentActivity(List_time);
        list_time_for_student.setAdapter(timePresentAdapterForStudent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) {
            Intent student = new Intent(this, PresentStudentActivity.class); // --> Turn to PresentStudentActivity
            student.putExtra("ID_STUDENT", Id_student_present);  // Truyền ID_STUDENT
            startActivity(student);
        } else if (v.getId() == R.id.img_btn_home) {
            Intent student1 = new Intent(this, StudentActivity.class); // --> Turn to StudentActivity
            student1.putExtra("ID_STUDENT", Id_student_present);  // Truyền ID_STUDENT
            startActivity(student1);
        }
    }
}
