package com.example.myapplication.presenter;
import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.AbsentTeacherModel;
import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.IAbsentTeacherModel;
import com.example.myapplication.model.IClassModel;
import com.example.myapplication.model.PresentTeacherModel;
import com.example.myapplication.view.IAbsentTeacherView;
import com.example.myapplication.view.IAbsentTimeTeacherView;
import com.example.myapplication.view.IPresentTeacherView;

import java.util.ArrayList;

public class AbsentTeacherPresenter implements IAbsentTeacherPresenter {
    IClassModel iClass;
    IAbsentTeacherView iAbsentTeacherView;
    IAbsentTimeTeacherView iAbsentTimeTeacherView;
    IAbsentTeacherModel iAbsentTeacherModel;
    Handler handler;
    public AbsentTeacherPresenter(IAbsentTeacherView iAbsentTeacherView) {
        this.iAbsentTeacherView = iAbsentTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListClass(String id, IAbsentTeacherView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher(id, context);
    }
    public AbsentTeacherPresenter(IAbsentTimeTeacherView iAbsentTimeTeacherView) {
        this.iAbsentTimeTeacherView = iAbsentTimeTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListStudent(String id, String date_time, IAbsentTimeTeacherView context) {
        iAbsentTeacherModel = new AbsentTeacherModel(id,date_time,context);
        iAbsentTeacherModel.GetAbsentForClasstTeacherChoose(context);
    }
}
