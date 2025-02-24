package com.example.myapplication.view;

public interface IProfileTeacherView {
    void showInforTeacher(String teacher_id, String teacher_name,String teacher_birth,String teacher_gender,String teacher_mail,String teacher_phone, String teacher_image);
    void updateSuccessfully(int result);
    void showInforTeacherMain(String teacher_id, String teacher_name, String teacher_image);
}
