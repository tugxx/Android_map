package com.example.myapplication.presenter;

import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.ProfileStudentModel;
import com.example.myapplication.model.IProfileStudentModel;
import com.example.myapplication.view.IProfileStudentView;

import android.os.Handler;



public class ProfileStudentPresenter extends AppCompatActivity implements IProfileStudentPresenter {
    IProfileStudentModel iProfileStudentModel;
    IProfileStudentView iProfileStudentView;
    Handler handler;

    public ProfileStudentPresenter(IProfileStudentView iProfileStudentView) {
        this.iProfileStudentView = iProfileStudentView;
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void getIDStudent(String ID, IProfileStudentView iProfileStudentView) {
//        System.out.println("ProfileStudentPresenter + getIDStudent");
        iProfileStudentModel = new ProfileStudentModel(ID,iProfileStudentView);
        iProfileStudentModel.checkInforValidity(ID, iProfileStudentView); // --> Turn to ProfileStudentModel
    }
    @Override
    public void getIDMainStudent(String ID, IProfileStudentView iProfileStudentView) {
//        System.out.println("ProfileStudentPresenter - getIDMainStudent");
        iProfileStudentModel = new ProfileStudentModel(ID,iProfileStudentView);
        iProfileStudentModel.checkInforValidityMain(ID, iProfileStudentView); // --> Turn to ProfileStudentModel
    }

    public void checkUpdate (String student_id, String student_name,String student_birth,String student_gender,String student_mail,String student_phone, String hinhanh, IProfileStudentView iProfileStudentView)
    {
        iProfileStudentModel = new ProfileStudentModel(student_id, student_name, student_birth, student_gender, student_mail, student_phone, hinhanh, iProfileStudentView);
        iProfileStudentModel.updateInforStudent(student_id, student_name, student_birth, student_gender, student_mail, student_phone, hinhanh, iProfileStudentView);
    }


}
