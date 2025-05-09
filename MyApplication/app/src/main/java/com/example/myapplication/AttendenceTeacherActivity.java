package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.example.myapplication.presenter.AttendenceTeacherPresenter;
import com.example.myapplication.presenter.IAttendenceTeacherPresenter;
import com.example.myapplication.view.IAttendenceTeacherView;

import java.util.ArrayList;

public class AttendenceTeacherActivity extends AppCompatActivity implements IAttendenceTeacherView,View.OnClickListener {
    private EditText editText_search;
    private ListView listView_class;
    ImageView img_btn_back;
    IAttendenceTeacherPresenter attendenceTeacherPresenter = new AttendenceTeacherPresenter(this);
    ArrayList<ClassModel> listClass;
    ClassListAdapterForTeacherActivity classListAdapter;
    private String teacher_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_classlist_attendance_teacher);
        mapping();
        LoadClassForTeacher(); /// Turn to line 63

        listView_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassModel class_model = (ClassModel) classListAdapter.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , RenderQRActivity.class); // --> Turn to RenderQRActivity
                intent.putExtra("ID_CLASS", class_model.getClass_id());  // Truyền ID_Class
                startActivity(intent);
            }
        });

        img_btn_back.setOnClickListener(this); // Back <
    }

    public void mapping() {
        editText_search = (EditText) findViewById(R.id.edt_search_class); // Search text
        listView_class = (ListView) findViewById(R.id.list_class); // List view
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back_teacher); // Back <
    }

    public void LoadClassForTeacher() {
        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("ID_TEACHER");
        attendenceTeacherPresenter.doLoadListClass(teacher_id, this); // --> Turn to AttendenceTeacherPresenter (Line 23)
    }

    @Override
    public void onListClassResult(ArrayList<ClassModel> List_Class) {
        // setAdapter --> Tìm đến hàm getView
        classListAdapter = new ClassListAdapterForTeacherActivity(List_Class);
        listView_class.setAdapter(classListAdapter); // --> Turn to ClassListAdapterForTeacherActivity (Line 42)
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) {
            Intent teacher1 = new Intent(this, TeacherActivity.class); // --> Turn to TeacherActivity
            teacher1.putExtra("ID_TEACHER", teacher_id);  // Truyền ID_TEACHER
            startActivity(teacher1);
            finish();
        }
    }
}
