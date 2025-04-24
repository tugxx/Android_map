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
import com.example.myapplication.presenter.ITClassListDetailPresenter;
import com.example.myapplication.presenter.TClassListDetailPresenter;
import com.example.myapplication.view.ITClassListDetailView;
import java.util.ArrayList;

public class TclassListDetailActivity extends AppCompatActivity implements ITClassListDetailView,View.OnClickListener{
    private IPConfigModel ipConfigModel = new IPConfigModel();
    private EditText editText;
    private ImageView img_btn_back,img_btn_home;
    private String class_id;
    //MVP
    private ListView list;
    private String id_teacher,class_name;
    private ITClassListDetailPresenter itClassListDetailPresenter = new TClassListDetailPresenter(this);
    ArrayList<StudentModel> List_Student;
    StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        AnhXa(); /// Turn to line 69
        LoadClassForStudent(); /// Turn to line 75

        img_btn_home.setOnClickListener(this); // Home
        img_btn_back.setOnClickListener(this); // Back

        //tìm kiếm

        // Funcion on Click list view
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentModel student_model = (StudentModel) studentAdapter.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , TDeTailStudentActivity.class); /// --> Turn to TDeTailStudentActivity
                intent.putExtra("STUDENT_ID", student_model.getStudent_id());
                intent.putExtra("STUDENT_NAME", student_model.getStudent_name());
                intent.putExtra("STUDENT_EMAIL", student_model.getStudent_mail());
                intent.putExtra("STUDENT_PHONE", student_model.getStudent_phone());
                intent.putExtra("STUDENT_DOB", student_model.getStudent_birth());
                intent.putExtra("STUDENT_CLASS", class_name);
                intent.putExtra("ID_TEACHER", id_teacher);
                intent.putExtra("ID_CLASS", class_id);
                intent.putExtra("CLASS_NAME", class_name);// Truyền ID_Class
                // Truyền Student
                startActivity(intent);
            }
        });

    }

    public void AnhXa() {
        list = findViewById(R.id.recyclerviewStudent); // List view
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home); // Home
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); // Back <
    }

    public void LoadClassForStudent() {
        Intent intent = getIntent();
        class_id =intent.getStringExtra("ID_CLASS");
        id_teacher =intent.getStringExtra("ID_TEACHER");
        class_name =intent.getStringExtra("CLASS_NAME");
        itClassListDetailPresenter.doLoadListStudent(class_id, this); /// --> Turn to TClassListDetailPresenter (Line 22)
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_home) { // Home
            Intent intent1 = new Intent(this, TeacherActivity.class);
            intent1.putExtra("ID_TEACHER", id_teacher);
            startActivity(intent1);
            finish();
        } else if (v.getId() == R.id.img_btn_back) { // Back <
            Intent intent = new Intent(this, TClassListActivity.class);
            intent.putExtra("ID_TEACHER", id_teacher);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onListClassStudentResult(ArrayList<StudentModel> List_Student) {
        studentAdapter = new StudentAdapter(this,List_Student);
        list.setAdapter(studentAdapter); /// -> Turn to StudentAdapter (Line 52)
    }
}
