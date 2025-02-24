package com.example.myapplication.model;

import com.example.myapplication.view.IPresentTimeTeacherView;

public interface IPresentTeacherModel {
    String getStudent_id();
    String getStudent_name();
    String getAttendancetime();
    String getStatusAttendance();
    void GetAttendanceForClasstTeacherChoose(IPresentTimeTeacherView context);
}
