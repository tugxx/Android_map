package com.example.myapplication.presenter;

import com.example.myapplication.view.IAttendenceTeacherView;
import com.example.myapplication.view.IPresentTeacherView;
import com.example.myapplication.view.IPresentTimeTeacherView;

public interface IPresentTeacherPresenter {
    void doLoadListClass(String id, IPresentTeacherView context);
    void doLoadListTime(String id, String date_time, String hour_star_for_class ,IPresentTimeTeacherView context);
}
