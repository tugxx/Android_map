package com.example.myapplication.presenter;

import android.content.Context;
import android.widget.EditText;

import com.example.myapplication.view.ILoginView;

public interface ILoginPresenter {
        void doLogin(String user, String password, ILoginView context);

}
