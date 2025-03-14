package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;
import com.example.myapplication.model.IStudentModel;
import com.example.myapplication.model.StudentModel;
import com.example.myapplication.view.ISClassListDetailView;

public class SClassListDetailPresenter implements  ISClassListDetailPresenter{
    IStudentModel iStudent;
    ISClassListDetailView iSClassListDetailView;
    Handler handler;

    public SClassListDetailPresenter(ISClassListDetailView iSClassListDetailView) {
        this.iSClassListDetailView = iSClassListDetailView;
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void doLoadListStudent(String id, ISClassListDetailView context) {
        iStudent = new StudentModel(id, context);
        iStudent.getDataStudentForIDClass(id, context); // --> Turn to StudentModel (Line 136)
    }
}
