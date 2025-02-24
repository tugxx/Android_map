package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.IStudentModel;
import com.example.myapplication.model.StudentModel;
import com.example.myapplication.view.ISClassListDetailView;
import com.example.myapplication.view.ITClassListDetailView;

public class TClassListDetailPresenter implements ITClassListDetailPresenter {
    IStudentModel iStudent;
    ITClassListDetailView itClassListDetailView;
    Handler handler;

    public TClassListDetailPresenter(ITClassListDetailView itClassListDetailView) {
        this.itClassListDetailView = itClassListDetailView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListStudent(String id, ITClassListDetailView context) {
        iStudent = new StudentModel(id, context);
        iStudent.getDataStudentForIDClass(id, context);
    }
}
