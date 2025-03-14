package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.ForgotPassModel;
import com.example.myapplication.model.IForgotPassModel;
import com.example.myapplication.view.IForgotPassView;
import com.example.myapplication.view.IProfileStudentView;

public class forgotPassPresenter extends AppCompatActivity implements IforgotPassPresenter{
    IForgotPassView iForgotPassView;
    IForgotPassModel iForgotPassModel;
    Handler handler;

    public forgotPassPresenter(IForgotPassView iForgotPassView) {
        this.iForgotPassView = iForgotPassView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void checkUsername(String username, IForgotPassView iForgotPassView) {
        iForgotPassModel = new ForgotPassModel(username,iForgotPassView);
        // --> Turn to ForgotPassModel (Line 38)
        iForgotPassModel.checkUser(username, iForgotPassView);
    }
}
