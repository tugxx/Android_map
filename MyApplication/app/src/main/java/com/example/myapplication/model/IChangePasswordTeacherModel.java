package com.example.myapplication.model;

import com.example.myapplication.view.IChangePasswordTeacherView;

public interface IChangePasswordTeacherModel {
    void Changepasswordteacher(String id_teacher, String old_password, String new_password, IChangePasswordTeacherView iChangePasswordTeacherView);
}
