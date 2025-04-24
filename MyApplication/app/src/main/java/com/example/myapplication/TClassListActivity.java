package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.ClassListAdapterForTeacherActivity;

import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.IPConfigModel;

import com.example.myapplication.presenter.ITClassListPresenter;
import com.example.myapplication.presenter.TClassListPresenter;

import com.example.myapplication.view.ITClassListView;

import java.util.ArrayList;

public class TClassListActivity extends AppCompatActivity implements ITClassListView,View.OnClickListener {
    private IPConfigModel ipConfigModel = new IPConfigModel();
    private EditText editText;
    private ImageView img_btn_back;
    private String id_student;
    //MVP
    private ListView list;
    private String teacher_id;
    private ITClassListPresenter TClassListPresenter = new TClassListPresenter(this);
    ArrayList<ClassModel> List_Class;
    ClassListAdapterForTeacherActivity classListAdapterForTeacherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist_teacher);
        AnhXa(); /// Turn to line 63
        LoadClassForStudent(); /// Turn to line 68

        //bắt sự kiện click
        img_btn_back.setOnClickListener(this);

        // Funcion on Click list view
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassModel class_model = (ClassModel) classListAdapterForTeacherActivity.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , TclassListDetailActivity.class); /// --> Turn to TclassListDetailActivity
                intent.putExtra("ID_CLASS", class_model.getClass_id());
                intent.putExtra("CLASS_NAME", class_model.getClass_name());// Truyền ID_Class
                intent.putExtra("ID_TEACHER",teacher_id);
                startActivity(intent);
            }
        });
    }

    public void AnhXa() {
        list = findViewById(R.id.recyclerView3);
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back_teacher);
    }

    public void LoadClassForStudent() {
        Intent intent = getIntent();
        teacher_id =intent.getStringExtra("ID_TEACHER");
        TClassListPresenter.doLoadListTeacher(teacher_id, this); /// --> Turn to TClassListPresenter (Line 22)
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back_teacher) { // Back <
            Intent intent = new Intent(this, TeacherActivity.class); /// --> Turn to TeacherActivity
            intent.putExtra("ID_TEACHER", teacher_id);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onListClassTeacherResult(ArrayList<ClassModel> List_Class) {
        classListAdapterForTeacherActivity = new ClassListAdapterForTeacherActivity(List_Class);
        list.setAdapter(classListAdapterForTeacherActivity); /// --> Turn to ClassListAdapterForTeacherActivity (Line 42)
    }
}
