package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.IClassModel;
import com.example.myapplication.view.ISClassListView;
import com.example.myapplication.view.ITClassListView;

public class TClassListPresenter implements ITClassListPresenter{
    IClassModel iClass;
    ITClassListView itClassListView;
    Handler handler;

    public TClassListPresenter(ITClassListView itClassListView) {
        this.itClassListView = itClassListView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListTeacher(String id, ITClassListView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher2(id, context);
    }
}
