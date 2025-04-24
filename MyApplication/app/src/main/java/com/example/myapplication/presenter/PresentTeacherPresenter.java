package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.IClassModel;
import com.example.myapplication.model.IPresentTeacherModel;
import com.example.myapplication.model.PresentTeacherModel;
import com.example.myapplication.view.IAttendenceTeacherView;
import com.example.myapplication.view.IPresentTeacherView;
import com.example.myapplication.view.IPresentTimeTeacherView;

public class PresentTeacherPresenter implements IPresentTeacherPresenter {
    IClassModel iClass;
    IPresentTeacherView iPresentTeacherView;
    Handler handler;

    IPresentTeacherModel iPresentTeacherModel;
    IPresentTimeTeacherView iPresentTimeTeacherView;

    public PresentTeacherPresenter(IPresentTeacherView iPresentTeacherView) {
        this.iPresentTeacherView = iPresentTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListClass(String id, IPresentTeacherView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher(id, context); // --> Turn to ClassModel (Line 228)
    }

    public PresentTeacherPresenter(IPresentTimeTeacherView iPresentTimeTeacherView) {
        this.iPresentTimeTeacherView = iPresentTimeTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void doLoadListTime(String id, String date_time, String hour_star_for_class, IPresentTimeTeacherView context) {
        iPresentTeacherModel = new PresentTeacherModel(id,date_time,hour_star_for_class ,context);
        iPresentTeacherModel.GetAttendanceForClasstTeacherChoose(context);
    }
}
