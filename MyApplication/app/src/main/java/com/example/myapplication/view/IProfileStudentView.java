package com.example.myapplication.view;

public interface  IProfileStudentView {
    void showInforStudent(String student_id, String student_name,String student_birth,String student_gender,String student_mail, String student_phone, String student_hinhanh);
    void updateSuccessfully(int result);
    void showInforStudentMain(String student_id, String student_name, String student_image);
}
