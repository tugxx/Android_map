package com.example.myapplication.presenter;


import com.example.myapplication.view.IScheduleStudentView;

public interface IScheduleStudentPresenter {
    void doLoadListSchedule(String id, IScheduleStudentView context);
}
