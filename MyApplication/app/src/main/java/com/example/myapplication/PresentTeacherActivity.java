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
import com.example.myapplication.presenter.IPresentTeacherPresenter;
import com.example.myapplication.presenter.PresentTeacherPresenter;
import com.example.myapplication.view.IPresentTeacherView;

import java.util.ArrayList;
public class PresentTeacherActivity extends AppCompatActivity implements IPresentTeacherView, View.OnClickListener {
    private EditText editText_search;
    private ListView listView_class;
    ArrayList<ClassModel> listClass;
    ClassListAdapterForTeacherActivity classListAdapter;
    IPresentTeacherPresenter PresentTeacherPresenter = new PresentTeacherPresenter(this);
    ImageView img_btn_back;

    private String teacher_id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_classlist_present_teacher);
        mapping();
        LoadClassForTeacher();

        listView_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassModel class_model = (ClassModel) classListAdapter.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , PresentTimeTeacherActivity.class);
                intent.putExtra("ID_CLASS", class_model.getClass_id());  // Truyền ID_Class
                intent.putExtra("CLASS_TIME", class_model.getClass_time()); // Truyền thời gian bắt đầu của môn học đó
                intent.putExtra("ID_TEACHER",teacher_id);
                startActivity(intent);
            }
        });
        img_btn_back.setOnClickListener(this);
    }
    public void LoadClassForTeacher() {
        Intent intent = getIntent();
        teacher_id = intent.getStringExtra("ID_TEACHER");
        PresentTeacherPresenter.doLoadListClass(teacher_id, this);
    }
    public void mapping() {
        editText_search = (EditText) findViewById(R.id.edt_search_class);
        listView_class = (ListView) findViewById(R.id.list_class);
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back);
    }

    @Override
    public void onListClassResult(ArrayList<ClassModel> List_Class) {
        classListAdapter = new ClassListAdapterForTeacherActivity(List_Class);
        listView_class.setAdapter(classListAdapter);
    }
    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.img_btn_back:
//                Intent teacher1 = new Intent(this, TeacherActivity.class);
//                teacher1.putExtra("ID_TEACHER", teacher_id);  // Truyền ID_TEACHER
//                startActivity(teacher1);
//                finish();
//                break;
//        }

        if (v.getId() == R.id.img_btn_back) {
            Intent teacher1 = new Intent(this, TeacherActivity.class);
            teacher1.putExtra("ID_TEACHER", teacher_id);  // Truyền ID_TEACHER
            startActivity(teacher1);
            finish();
        }

    }
}
