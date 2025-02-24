package com.example.myapplication.presenter;

import com.example.myapplication.view.IAbsentTeacherView;
import com.example.myapplication.view.IAbsentTimeTeacherView;
import com.example.myapplication.view.IPresentTeacherView;
import com.example.myapplication.view.IPresentTimeTeacherView;

public interface IAbsentTeacherPresenter {
    void doLoadListClass(String id, IAbsentTeacherView context);
    void doLoadListStudent(String id, String date_time, IAbsentTimeTeacherView context);
}
