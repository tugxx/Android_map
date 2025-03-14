package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.IStudentModel;

import com.example.myapplication.model.StudentModel;
import com.example.myapplication.view.IStudentListView;

public class StudentListPresenter implements IStudentListPresenter {
    IStudentModel iStudent;
    IStudentListView iStudentListView;
    Handler handler;

    public StudentListPresenter(IStudentListView iStudentListView) {
        this.iStudentListView = iStudentListView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListStudent(String id, IStudentListView context) {
        iStudent = new StudentModel(id, context);
        iStudent.getDataStudentForIDStudent(id, context); // --> Turn to StudentModel
    }
}
