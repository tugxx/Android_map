package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.TeacherActivity;
import com.example.myapplication.model.IProfileTeacherModel;
import com.example.myapplication.model.ProfileTeacherModel;
import com.example.myapplication.view.IProfileTeacherView;

public class ProfileTeacherPresenter extends AppCompatActivity implements IProfileTeacherPresenter{
    IProfileTeacherModel iProfileTeacherModel;
    IProfileTeacherView iProfileTeacherView;
    Handler handler;

    public ProfileTeacherPresenter(IProfileTeacherView iProfileTeacherView) {
        this.iProfileTeacherView = iProfileTeacherView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void getIDTeacher(String ID, IProfileTeacherView iProfileTeacherView) {
        iProfileTeacherModel = new ProfileTeacherModel(ID,iProfileTeacherView);
        iProfileTeacherModel.checkInforValidity(ID, iProfileTeacherView); /// --> Turn to ProfileTeacherModel (Line 49)
    }

    public void checkUpdate (String teacher_id, String teacher_name,String teacher_birth,String teacher_gender,String teacher_mail,String teacher_phone, String teacher_image, IProfileTeacherView iProfileTeacherView)
    {
        iProfileTeacherModel = new ProfileTeacherModel(teacher_id, teacher_name, teacher_birth, teacher_gender, teacher_mail, teacher_phone,teacher_image, iProfileTeacherView);
        iProfileTeacherModel.updateInforTeacher(teacher_id, teacher_name, teacher_birth, teacher_gender, teacher_mail, teacher_phone,teacher_image, iProfileTeacherView);
    }

    @Override
    public void getIDMainTeacher(String id_teacher, TeacherActivity teacherActivity) {
//        System.out.println("ProfileTeacherPresenter + getIDMainTeacher");
        iProfileTeacherModel = new ProfileTeacherModel(id_teacher,iProfileTeacherView);
        iProfileTeacherModel.checkInforValidityMain(id_teacher, iProfileTeacherView); // --> Turn to ProfileTeacherModel (Line 140)
    }
}
