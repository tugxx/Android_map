package com.example.myapplication.presenter;

import android.os.Looper;

import com.example.myapplication.model.IUserModel;
import com.example.myapplication.model.UserModelModel;
import com.example.myapplication.view.ILoginView;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPresenter extends AppCompatActivity implements ILoginPresenter {
    ILoginView iLoginView;
    IUserModel userlogin;
    Handler handler;
    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        handler = new Handler(Looper.getMainLooper());
    }
    private void initUser(String usern, String pass, ILoginView loginView){
        userlogin = new UserModelModel(usern,pass, loginView); // IUserModel --> UserModelModel
    }
    @Override
    public void doLogin(String user, String password, ILoginView loginView) {
//        System.out.println("LoginPresenter - doLogin");
        initUser(user ,password, loginView);
        userlogin.checkUserValidity(loginView); // --> Turn to UserModelModel
    }


}
