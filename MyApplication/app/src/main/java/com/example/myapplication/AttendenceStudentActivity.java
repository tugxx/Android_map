package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.example.myapplication.presenter.AttendanceStudentPresenter;
import com.example.myapplication.presenter.DateTime_Format;
import com.example.myapplication.presenter.IAttendanceStudentPresenter;
import com.example.myapplication.view.IAttendanceStudentView;

import java.util.Calendar;
import java.util.Date;

import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;

public class AttendenceStudentActivity extends AppCompatActivity implements IAttendanceStudentView {
    private CodeScanner mCodeScanner;
    PopupWindow popupSucessfull;
    PopupWindow popupError;
    private IAttendanceStudentPresenter iAttendanceStudentPresenter = new AttendanceStudentPresenter(this);
    private String student_id;
    private DateTime_Format dateTime_format = new DateTime_Format();
    private String Class_id_scan;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;

    @Override // --> Auto log in onResume
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        System.out.println("AttendenceStudentActivity + onCreate");
        setContentView(R.layout.acctivity_attendence_student);
        Intent intent_student = getIntent();
        student_id = intent_student.getStringExtra("ID_STUDENT");
        CodeScannerView scannerView = findViewById(R.id.scanner_view);

        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() { // Phan tich QRcode quet dc
            @Override
            public void onDecoded(@NonNull final Result result) {
//                System.out.println("onDecoded");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Class_id_scan = result.getText(); // Tra text quet dc tu QRcode
                        infoAttendance();
                    }
                });
            }
        });

        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("scannerView.setOnClickListener");
                mCodeScanner.startPreview();
            }
        });
    }

    public void infoAttendance() {
        Intent intent = getIntent();
        student_id = intent.getStringExtra("ID_STUDENT");
//        System.out.println("AttendenceStudentActivity + infoAttendance");
        Date currentTime = Calendar.getInstance().getTime();
        String Attendance_time = dateTime_format.getDateString(currentTime) + " " + dateTime_format.getTime12String(currentTime);
//        System.out.println(Attendance_time);
        // --> Turn to AttendanceStudentPresenter
        iAttendanceStudentPresenter.AddAttendanceStudentPresenter(Class_id_scan, student_id, Attendance_time, "1", this);
    }

    public void ReturnLayout() {
//        System.out.println("AttendenceStudentActivity + ReturnLayout");
        Intent student = new Intent(this, StudentActivity.class); // --> Turn to StudentActivity
        student.putExtra("ID_STUDENT", student_id);  // Truyền ID_STUDENT
        startActivity(student);
    }

    private void requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            mCodeScanner.startPreview(); // Permission already granted, start the scanner
        }
    }

    @Override // After the user makes their choice, the Android system automatically calls onRequestPermissionsResult() method
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) { // Permission granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mCodeScanner.startPreview();
            } else { // Permission denied
//                System.out.println("camera denied");
                Intent studentActivity = new Intent(this, StudentActivity.class);
                studentActivity.putExtra("ID_STUDENT", student_id);
                startActivity(studentActivity);
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestCameraPermission();
    }

    @Override
    protected void onPause() { // When the device's screen turns off, onPause() is called
        mCodeScanner.releaseResources();
        super.onPause();
    }

    @Override
    public void OnCheckattendanceResult(int checkattendance) {
        // result
        if (checkattendance == 1) {
            // show popup checking
            LayoutInflater inflater_sucess = (LayoutInflater)
            getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater_sucess.inflate(R.layout.popup_success, null);
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            popupSucessfull = new PopupWindow(popupView, width, height, focusable);
            popupSucessfull.setAnimationStyle(R.style.Animation);
            popupSucessfull.showAtLocation(popupView, Gravity.CENTER, 0, 0);

            //Map button ok
            Button btnpopupSucessfull = (Button) popupView.findViewById(R.id.btnOKpopupSucessful);
            // dismiss the popup window when touched
            btnpopupSucessfull.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupSucessfull.dismiss();
                    ReturnLayout(); // Turn to line 91
                }
            });
        } else {
            // Error - run here
            LayoutInflater inflater_error = (LayoutInflater)
            getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater_error.inflate(R.layout.popup_error, null);
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            popupError = new PopupWindow(popupView, width, height, focusable);
            popupError.setAnimationStyle(R.style.Animation);
            popupError.showAtLocation(popupView, Gravity.CENTER, 0, 0);

            //Map button ok
            Button btnpopupSucessfull = (Button) popupView.findViewById(R.id.btnOKError);
            // dismiss the popup window when touched
            btnpopupSucessfull.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupError.dismiss();
                    ReturnLayout();
                }
            });
        }
    }
}
