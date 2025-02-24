package com.example.myapplication.model;

import com.example.myapplication.view.IChangePassView;
import com.example.myapplication.view.IProfileStudentView;

public interface IChangePassModel {
    void changePass(String password, String username, IChangePassView iChangePassView);
}
