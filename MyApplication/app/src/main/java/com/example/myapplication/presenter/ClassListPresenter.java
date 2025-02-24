package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.IClassModel;
import com.example.myapplication.view.ISClassListView;


public class ClassListPresenter implements IClassListPresenter{
    IClassModel iClass;
    ISClassListView iClassListView;
    Handler handler;

    public ClassListPresenter(ISClassListView iClassListView) {
        this.iClassListView = iClassListView;
        handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void doLoadListClass(String id, ISClassListView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDStudent(id, context);
    }
}
