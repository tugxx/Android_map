package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.IScheduleModel;
import com.example.myapplication.model.ScheduleModel;
import com.example.myapplication.view.IScheduleStudentView;
import com.example.myapplication.view.ITScheduleTeacherView;

public class TScheduleTeacherPresenter implements ITScheduleTeacherPresenter {
    IScheduleModel iSchedule;
    ITScheduleTeacherView itScheduleTeacherView;
    Handler handler;

    public TScheduleTeacherPresenter(ITScheduleTeacherView itScheduleTeacherView) {
        this.itScheduleTeacherView = itScheduleTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListSchedule(String id, ITScheduleTeacherView context) {
        iSchedule = new ScheduleModel(id, context);
        iSchedule.getDataScheduleForStudent(id, context); /// --> Turn to ScheduleModel (Line 191)
    }
}
