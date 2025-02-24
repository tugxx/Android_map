package com.example.myapplication.model;

import com.example.myapplication.view.IProfileTeacherView;

public interface IProfileTeacherModel {
     void checkInforValidity(String ID, IProfileTeacherView iProfileTeacherView);
     void updateInforTeacher(String teacher_id, String teacher_name, String teacher_birth, String teacher_gender, String teacher_mail, String teacher_phone, String teacher_image, IProfileTeacherView iProfileTeacherView);
    void checkInforValidityMain(String id, IProfileTeacherView iProfileTeacherView);
}
