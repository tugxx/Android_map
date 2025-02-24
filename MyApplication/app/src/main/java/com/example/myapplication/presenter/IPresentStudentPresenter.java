package com.example.myapplication.presenter;

import com.example.myapplication.view.IAttendenceTeacherView;
import com.example.myapplication.view.IPresentStudentView;
import com.example.myapplication.view.IPresentTimeStudentView;

public interface IPresentStudentPresenter {
    void doLoadListClass(String id, IPresentStudentView context);
    void doLoadtimepresent(String class_id, String student_id, IPresentTimeStudentView context);
}
