package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.IClassModel;
import com.example.myapplication.view.IAttendenceTeacherView;

public class AttendenceTeacherPresenter extends AppCompatActivity implements IAttendenceTeacherPresenter {
    IClassModel iClass;
    IAttendenceTeacherView iAttendenceTeacherView;
    Handler handler;

    public AttendenceTeacherPresenter(IAttendenceTeacherView iAttendenceTeacherView) {
        this.iAttendenceTeacherView = iAttendenceTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLoadListClass(String id, IAttendenceTeacherView context) {
        iClass = new ClassModel(id, context);
        iClass.getDataClassForIDTeacher(id, context); // --> Turn to ClassModel (Line 129)
    }
}
