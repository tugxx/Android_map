package com.example.myapplication.model;

import com.example.myapplication.view.IAttendanceStudentView;

public interface IAttendanceStudentModel {
    String getClass_id();
    String getStudent_id();
    String getAttendance_time();
    String getStatus();
    void AddAttendanceStudentModel(IAttendanceStudentView iAttendanceStudentView);
}
