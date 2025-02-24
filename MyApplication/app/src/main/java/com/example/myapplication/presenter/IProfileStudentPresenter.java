package com.example.myapplication.presenter;

import com.example.myapplication.view.IProfileStudentView;

public interface IProfileStudentPresenter {
    void getIDStudent(String ID_Student, IProfileStudentView context);
    void getIDMainStudent(String ID_Student, IProfileStudentView context);
    void checkUpdate(String student_id, String student_name,String student_birth,String student_gender,String student_mail,String student_phone, String hinhanh, IProfileStudentView iProfileStudentView);
}
