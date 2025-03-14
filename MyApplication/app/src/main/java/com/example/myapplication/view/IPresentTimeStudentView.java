package com.example.myapplication.view;

import com.example.myapplication.model.ClassModel;
import com.example.myapplication.model.PresentStudentModel;

import java.util.ArrayList;

public interface IPresentTimeStudentView {
    void onListTimeStudentResult(ArrayList<PresentStudentModel> List_Class);
}
