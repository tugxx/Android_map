package com.example.myapplication.model;

import com.example.myapplication.view.IPresentTimeStudentView;

public interface IPresentStudentModel {
    String getClass_id();
    String getStudent_id();
    String getAttendancetime();
    void GetAttendanceForClassStudentChoose(IPresentTimeStudentView context);
}
