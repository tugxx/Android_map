package com.example.myapplication.model;

import com.example.myapplication.view.IChangePasswordStudentView;

public interface IChangePasswordStudentModel {
    void Changepasswordstudent(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView);
}
