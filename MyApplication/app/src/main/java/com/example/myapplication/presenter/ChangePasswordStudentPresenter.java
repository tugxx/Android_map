package com.example.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ChangePasswordStudentActivity;
import com.example.myapplication.model.ChangePasswordStudentModel;
import com.example.myapplication.model.IChangePasswordStudentModel;
import com.example.myapplication.view.IChangePasswordStudentView;

public class ChangePasswordStudentPresenter extends AppCompatActivity implements IChangePasswordStudentPresenter {
    IChangePasswordStudentModel iChangePasswordStudentModel;
    IChangePasswordStudentView iChangePasswordStudentView;
    Handler handler;

    public ChangePasswordStudentPresenter(IChangePasswordStudentView iChangePasswordStudentView) {
        this.iChangePasswordStudentView = iChangePasswordStudentView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void checkChangePass(String id_student, String old_password, String new_password, IChangePasswordStudentView iChangePasswordStudentView) {
        iChangePasswordStudentModel = new ChangePasswordStudentModel(id_student, old_password, new_password, iChangePasswordStudentView);
        // --> Turn to ChangePasswordStudentModel
        iChangePasswordStudentModel.Changepasswordstudent(id_student, old_password, new_password, iChangePasswordStudentView);
    }

}
