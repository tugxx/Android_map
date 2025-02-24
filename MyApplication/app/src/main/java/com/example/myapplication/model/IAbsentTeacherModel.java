package com.example.myapplication.model;

import com.example.myapplication.view.IAbsentTimeTeacherView;
import com.example.myapplication.view.IPresentTimeTeacherView;

public interface IAbsentTeacherModel {
    String getStudent_id();
    String getStudent_name();

    void GetAbsentForClasstTeacherChoose(IAbsentTimeTeacherView context);
}
