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

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.ClassListAdapterForTeacherActivity;
import com.example.myapplication.model.ClassModel;
import com.example.myapplication.presenter.AbsentTeacherPresenter;
import com.example.myapplication.presenter.IAbsentTeacherPresenter;
import com.example.myapplication.view.IAbsentTeacherView;

import java.util.ArrayList;

public class AbsentTeacherActivity extends AppCompatActivity implements IAbsentTeacherView,View.OnClickListener {
    private EditText editText_search;
    private ListView listView_class;
    ArrayList<ClassModel> listClass;
    ClassListAdapterForTeacherActivity classListAdapter;
    private String teacher_id;
    IAbsentTeacherPresenter absentTeacherPresenter = new AbsentTeacherPresenter(this);
    ImageView img_btn_back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_absent_teacher);
        mapping();
        LoadClassForTeacher(); // Turn to line 60

        listView_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassModel class_model = (ClassModel) classListAdapter.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext(), AbsentTimeTeacherActivity.class);
                intent.putExtra("ID_CLASS", class_model.getClass_id());  // Truyền ID_Class
                intent.putExtra("ID_TEACHER",teacher_id);
                startActivity(intent);
            }
        });

        img_btn_back.setOnClickListener(this); /// Back <
    }

    public void mapping() {
        editText_search = (EditText) findViewById(R.id.edt_search_class); // Search text
        listView_class = (ListView) findViewById(R.id.list_class); /// List view
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); /// Back <
    }

    public void LoadClassForTeacher() {
        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("ID_TEACHER");
        absentTeacherPresenter.doLoadListClass(teacher_id, this); // --> Turn to AbsentTeacherPresenter (Line 28)
    }

    @Override
    public void onListClassResult(ArrayList<ClassModel> List_Class) {
        classListAdapter = new ClassListAdapterForTeacherActivity(List_Class); /// --> Turn to ClassListAdapterForTeacherActivity (Line 42)
        listView_class.setAdapter(classListAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) { // Back <
            Intent teacher1 = new Intent(this, TeacherActivity.class); /// --> Turn to TeacherActivity
            teacher1.putExtra("ID_TEACHER", teacher_id);  // Passing the teacher ID
            startActivity(teacher1);
            finish();
        }
    }
}
