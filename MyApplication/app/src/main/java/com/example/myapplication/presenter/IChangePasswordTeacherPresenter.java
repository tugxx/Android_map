package com.example.myapplication.presenter;

import com.example.myapplication.view.IChangePasswordTeacherView;

public interface IChangePasswordTeacherPresenter {
    void checkChangePass(String id_teacher, String old_password, String new_password, IChangePasswordTeacherView iChangePasswordTeacherView);
}
