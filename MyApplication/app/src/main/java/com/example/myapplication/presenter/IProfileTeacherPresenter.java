package com.example.myapplication.presenter;

import com.example.myapplication.TeacherActivity;
import com.example.myapplication.view.IProfileTeacherView;

public interface IProfileTeacherPresenter {
    void getIDTeacher(String ID_Teacher, IProfileTeacherView context);
    void checkUpdate(String teacher_id, String teacher_name, String teacher_birth, String teacher_gender, String teacher_mail, String teacher_phone, String teacher_image, IProfileTeacherView profileTeacherView);

    void getIDMainTeacher(String id_teacher, TeacherActivity teacherActivity);
}
