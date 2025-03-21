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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.example.myapplication.adapter.ClassAdapterForStudentActivity;
import com.example.myapplication.adapter.ClassListAdapterForTeacherActivity;
import com.example.myapplication.model.ClassModel;
import com.example.myapplication.presenter.IPresentStudentPresenter;
import com.example.myapplication.presenter.PresentStudentPresenter;
import com.example.myapplication.view.IPresentStudentView;

import java.util.ArrayList;

public class PresentStudentActivity extends AppCompatActivity implements IPresentStudentView, View.OnClickListener {
    private EditText txt_search_class_student;
    private ListView list_class_for_student;
    private String student_id;
    private IPresentStudentPresenter PresentStudentPresenter = new PresentStudentPresenter(this);
    ArrayList<ClassModel> listClass;
    private ClassAdapterForStudentActivity classAdapterForStudent;
    ImageView img_btn_back, img_btn_home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_present_student);
        // Auto load when log in page
        LoadClassForStudent(); // Turn to line 92
        mapping();

        // tìm kiem
        txt_search_class_student.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                System.out.println("PresentStudentActivity + SearchClass + TextListener");
//                PresentStudentActivity.this.classAdapterForStudent.getFilter().filter(s);
                // Not Working (need repair)
                classAdapterForStudent.getFilter().filter(s); // --> Turn to ClassAdapterForStudentActivity (Line 67)
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Funcion on Click list view (Done)
        list_class_for_student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassModel class_model = (ClassModel) classAdapterForStudent.getItem(position);
                //Do in Click Class
                Intent intent = new Intent(view.getContext() , PresentTimeStudentActivity.class); // --> Turn to PresentTimeStudentActivity
                intent.putExtra("ID_CLASS", class_model.getClass_id());  // Truyền ID_Class
                intent.putExtra("ID_STUDENT",student_id);
                startActivity(intent);
            }
        });

        img_btn_back.setOnClickListener(this); // Done
        img_btn_home.setOnClickListener(this); // Done
    }

    public void mapping() {
        txt_search_class_student = (EditText) findViewById(R.id.txt_search_class_student); // Search class (text)
        list_class_for_student = (ListView) findViewById(R.id.list_class_for_student); // List View
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back); // Back <
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home); // Home
    }

    public void LoadClassForStudent() {
        Intent intent = getIntent();
        student_id =intent.getStringExtra("ID_STUDENT");
        PresentStudentPresenter.doLoadListClass(student_id, this); // --> Turn to PresentStudentPresenter (Line 31)
    }

    @Override
    public void onListClassStudentResult(ArrayList<ClassModel> List_Class) {
//        System.out.println("PresentStudentActivity + onListClassStudentResult");
        classAdapterForStudent = new ClassAdapterForStudentActivity(List_Class);
        list_class_for_student.setAdapter(classAdapterForStudent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_back) { // Back <
            Intent student = new Intent(this, StudentActivity.class); // --> Turn to StudentActivity
            student.putExtra("ID_STUDENT", student_id);  // Truyền ID_STUDENT
            startActivity(student);
        } else if (v.getId() == R.id.img_btn_home) { // Home
            Intent student = new Intent(this, StudentActivity.class); // --> Turn to StudentActivity
            student.putExtra("ID_STUDENT", student_id);  // Truyền ID_STUDENT
            startActivity(student);
        }
    }
}
