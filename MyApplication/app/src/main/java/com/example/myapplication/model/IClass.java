package com.example.myapplication.model;

import com.example.myapplication.view.IAttendenceTeacherView;

public interface IClass {
    String getClass_id();

    String getClass_name();

    String getClass_idteacher();

    int getClass_Totalstudent();

    void getDataClassForID(String id,IAttendenceTeacherView context);
}
