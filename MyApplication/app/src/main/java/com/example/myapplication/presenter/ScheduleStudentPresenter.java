package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.IScheduleModel;
import com.example.myapplication.model.IStudentModel;
import com.example.myapplication.model.ScheduleModel;
import com.example.myapplication.model.StudentModel;
import com.example.myapplication.view.ISClassListDetailView;
import com.example.myapplication.view.IScheduleStudentView;

public class ScheduleStudentPresenter implements IScheduleStudentPresenter {

    IScheduleModel iSchedule;
    IScheduleStudentView iScheduleStudentView;
    Handler handler;

    public ScheduleStudentPresenter(IScheduleStudentView iScheduleStudentView) {
        this.iScheduleStudentView = iScheduleStudentView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListSchedule(String id, IScheduleStudentView context) {
        iSchedule = new ScheduleModel(id, context);
//        System.out.println("ScheduleStudentPresenter + doLoadListSchedule");
        iSchedule.getDataScheduleForStudent(id, context); // --> Turn to ScheduleModel (Line 138)
    }
}
