package com.example.myapplication.model;

import com.example.myapplication.view.IAbsentTeacherView;
import com.example.myapplication.view.IPresentTeacherView;
import com.example.myapplication.view.IAttendenceTeacherView;
import com.example.myapplication.view.ISClassListView;
import com.example.myapplication.view.IPresentStudentView;
import com.example.myapplication.view.ITClassListView;

public interface IClassModel {
    String getClass_id();

    String getClass_name();

    String getClass_idteacher();

    String getClass_time();

    void getDataClassForIDTeacher(String id, IPresentTeacherView context);
    void getDataClassForIDTeacher(String id, IAbsentTeacherView context);
    int getClass_Totalstudent();

    void getDataClassForIDTeacher(String id,IAttendenceTeacherView context);
    void getDataClassForIDTeacher2(String id, ITClassListView context);
    void getDataClassForIDStudent(String id, ISClassListView context);
    void getDataClassForIDStudent(String id, IPresentStudentView context);
}
