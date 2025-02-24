package com.example.myapplication.presenter;

import com.example.myapplication.ChangePasswordStudentActivity;
import com.example.myapplication.view.IChangePasswordStudentView;

public interface IChangePasswordStudentPresenter {
    void checkChangePass(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView);
}
