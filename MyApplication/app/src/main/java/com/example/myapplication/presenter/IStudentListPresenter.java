package com.example.myapplication.presenter;

import com.example.myapplication.view.IStudentListView;

public interface IStudentListPresenter {
    void doLoadListStudent(String id, IStudentListView context);
}
