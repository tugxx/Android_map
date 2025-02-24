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

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.ClassModel;
import com.example.myapplication.adapter.ClassSAdapterActivity;
import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.presenter.ClassListPresenter;
import com.example.myapplication.presenter.IClassListPresenter;
import com.example.myapplication.view.ISClassListView;

import java.util.ArrayList;

public class SClassListActivity extends AppCompatActivity implements ISClassListView, View.OnClickListener {
    private IPConfigModel ipConfigModel = new IPConfigModel();
    private EditText editText;
    private ImageView img_btn_back;
    private String id_student;
    //MVP
    private ListView list;
    private String student_id;
    private IClassListPresenter ClassListPresenter = new ClassListPresenter(this);
    ArrayList<ClassModel> List_Class;
    ClassSAdapterActivity classAdapterForStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classlist_student);
        AnhXa();
        //lay id ma session luu
        LoadClassForStudent();

        //bắt sự kiện click
        img_btn_back.setOnClickListener(this);
        //tìm kiem
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SClassListActivity.this.classAdapterForStudent.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Funcion on Click list view
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassModel class_model = (ClassModel) classAdapterForStudent.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , SclassListDetailActivity.class);
                intent.putExtra("ID_CLASS", class_model.getClass_id());
                intent.putExtra("CLASS_NAME", class_model.getClass_name());// Truyền ID_Class
                intent.putExtra("ID_STUDENT",student_id);
                startActivity(intent);
            }
        });
    }

    public void AnhXa() {
        list = (ListView) findViewById(R.id.recyclerViewStudent);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back);
    }

    public void LoadClassForStudent() {
        Intent intent = getIntent();
        student_id =intent.getStringExtra("ID_STUDENT");
        ClassListPresenter.doLoadListClass(student_id, this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) {
            Intent intent = new Intent(SClassListActivity.this, StudentActivity.class);
            intent.putExtra("ID_STUDENT", student_id);
            startActivity(intent);
            finish();
        }

    }


    @Override
    public void onListClassStudentResult(ArrayList<ClassModel> List_Class) {
        classAdapterForStudent = new ClassSAdapterActivity(this,List_Class);
        list.setAdapter(classAdapterForStudent);
    }
}
