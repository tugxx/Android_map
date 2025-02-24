package com.example.myapplication.view;

import com.example.myapplication.model.AbsentTeacherModel;
import com.example.myapplication.model.PresentTeacherModel;

import java.util.ArrayList;

public interface IAbsentTimeTeacherView {
    void onLisTimeTeacherResult(ArrayList<AbsentTeacherModel> list_absent);
}
