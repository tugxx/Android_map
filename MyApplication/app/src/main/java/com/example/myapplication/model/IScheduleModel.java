package com.example.myapplication.model;

import com.example.myapplication.view.IScheduleStudentView;
import com.example.myapplication.view.ITScheduleTeacherView;

public interface IScheduleModel {
    void getDataScheduleForStudent(String id, IScheduleStudentView context);
    void getDataScheduleForStudent(String id, ITScheduleTeacherView context);
}
