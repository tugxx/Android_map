package com.example.myapplication.model;

import android.content.Context;

import com.example.myapplication.view.ILoginView;

public interface IUser {
        String getUsername();
        String getPassword();
        Boolean getResults();
        void checkUserValidity(ILoginView context);
        void getdata(Context context);
}
