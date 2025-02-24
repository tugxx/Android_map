package com.example.myapplication.model;

import android.content.Context;

import com.example.myapplication.view.ILoginView;
import com.example.myapplication.view.IProfileStudentView;

public interface IUserModel {
        String getUsername();
        String getPassword();
        Boolean getResults();
        void checkUserValidity(ILoginView context);
}
