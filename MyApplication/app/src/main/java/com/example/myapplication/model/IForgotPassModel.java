package com.example.myapplication.model;

import android.widget.EditText;

import com.example.myapplication.view.IForgotPassView;

public interface IForgotPassModel {
    void checkUser (String username,  IForgotPassView context);

}
