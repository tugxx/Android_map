package com.example.myapplication.model;

import android.content.Context;

import com.example.myapplication.view.IProfileStudentView;

public interface IProfileStudentModel {
    void checkInforValidity(String ID, IProfileStudentView context);
    void updateInforStudent(String student_id, String student_name,String student_birth,String student_gender,String student_mail,String student_phone, String hinhanh, IProfileStudentView iProfileStudentView);
    void checkInforValidityMain(String id, IProfileStudentView iProfileStudentView);
}
