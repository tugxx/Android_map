package com.example.myapplication.model;

import com.example.myapplication.view.ISClassListDetailView;
import com.example.myapplication.view.IStudentListView;
import com.example.myapplication.view.ITClassListDetailView;

public interface IStudentModel {
    void getDataStudentForIDClass(String id, ISClassListDetailView context);
    void getDataStudentForIDClass(String id, ITClassListDetailView context);
    void getDataStudentForIDStudent(String id, IStudentListView context);
}
