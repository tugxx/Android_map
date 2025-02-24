package com.example.myapplication.presenter;

import com.example.myapplication.view.IAttendanceStudentView;

public interface IAttendanceStudentPresenter {
    void AddAttendanceStudentPresenter(String class_id, String student_id, String attendance_time, String status, IAttendanceStudentView AttendanceStudentView);
}
