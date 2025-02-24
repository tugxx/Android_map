package com.example.myapplication.presenter;

import android.content.Context;
import android.widget.EditText;

import com.example.myapplication.view.IChangePassView;

public interface IChangePassPresenter {
    void OnCheckUser(EditText username, Context context);
    void checkpass(String password, IChangePassView iChangePassView);
    void changePassword(String username, String newPassword);
    void responseChangePassword(String message);
}
