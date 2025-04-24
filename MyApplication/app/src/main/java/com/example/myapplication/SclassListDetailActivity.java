package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.StudentAdapter;
import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.model.StudentModel;
import com.example.myapplication.presenter.ISClassListDetailPresenter;
import com.example.myapplication.presenter.SClassListDetailPresenter;
import com.example.myapplication.view.ISClassListDetailView;

import java.util.ArrayList;

public class SclassListDetailActivity extends AppCompatActivity implements ISClassListDetailView,View.OnClickListener{
    private IPConfigModel ipConfigModel = new IPConfigModel();
    private EditText editText;
    private ImageView img_btn_back,img_btn_home;
    private String class_id;
    //MVP
    private ListView list;
    private String id_student,class_name;
    private ISClassListDetailPresenter isClassListDetailPresenter = new SClassListDetailPresenter(this);
    ArrayList<StudentModel> List_Student;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        AnhXa();
        LoadClassForStudent(); // Turn to line 75

        //return Home
        img_btn_home.setOnClickListener(this);
        img_btn_back.setOnClickListener(this);


        // Funcion on Click list view
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentModel student_model = (StudentModel) studentAdapter.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , DetailStudentActivity.class); // --> Turn to DetailStudentActivity
                intent.putExtra("STUDENT_ID", student_model.getStudent_id());
                intent.putExtra("STUDENT_NAME", student_model.getStudent_name());
                intent.putExtra("STUDENT_EMAIL", student_model.getStudent_mail());
                intent.putExtra("STUDENT_PHONE", student_model.getStudent_phone());
                intent.putExtra("STUDENT_DOB", student_model.getStudent_birth());
                intent.putExtra("STUDENT_CLASS", class_name);
                intent.putExtra("ID_CLASS", class_id);
                intent.putExtra("ID_STUDENT", id_student);
                // Truyền Student
                startActivity(intent);
            }
        });
    }

    public void AnhXa() {
        list = (ListView) findViewById(R.id.recyclerviewStudent);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home);
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back);
    }

    public void LoadClassForStudent() {
        Intent intent = getIntent();
        class_id = intent.getStringExtra("ID_CLASS");
        id_student = intent.getStringExtra("ID_STUDENT");
        class_name = intent.getStringExtra("CLASS_NAME");
        isClassListDetailPresenter.doLoadListStudent(class_id, this); // --> Turn to SClassListDetailPresenter (Line 21)
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_home) { // Home
            Intent intent1 = new Intent(SclassListDetailActivity.this, StudentActivity.class); // --> Turn to StudentActivity
            intent1.putExtra("ID_STUDENT", id_student);
            startActivity(intent1);
            finish();
        } else if (v.getId() == R.id.img_btn_back) { // Back <
            Intent intent = new Intent(SclassListDetailActivity.this, SClassListActivity.class); // --> Turn to SClassListActivity
            intent.putExtra("ID_STUDENT", id_student);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onListClassStudentResult(ArrayList<StudentModel> List_Student) {
        // Với Adapter --> Tìm hàm getView
        studentAdapter = new StudentAdapter(this,List_Student); // --> Turn to StudentAdapter (Line 52)
        list.setAdapter(studentAdapter);
    }
}
