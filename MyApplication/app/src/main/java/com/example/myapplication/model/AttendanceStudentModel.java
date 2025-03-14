package com.example.myapplication.model;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.StudentActivity;
import com.example.myapplication.presenter.LoginPresenter;
import com.example.myapplication.view.IAttendanceStudentView;
import com.example.myapplication.view.ILoginView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;

import java.io.Console;
import java.io.StringBufferInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//import com.example.myapplication.StudentActivity;
//import com.vishnusivadas.advanced_httpurlconnection.FetchData;
//import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

public class AttendanceStudentModel extends AppCompatActivity implements IAttendanceStudentModel {
    private String Class_id;
    private String Student_id;
    private String Attendance_time;
    private String Status;
    private IPConfigModel ipConfigModel = new IPConfigModel();
    private IAttendanceStudentView AttendanceStudentView;
    public AttendanceStudentModel() {

    }

    public AttendanceStudentModel(String class_id, String student_id, String attendance_time, String status, IAttendanceStudentView iAttendanceStudentView) {
        this.Class_id = class_id;
        this.Student_id = student_id;
        this.Attendance_time = attendance_time;
        this.Status = status;
        this.AttendanceStudentView = iAttendanceStudentView;
    }


    @Override
    public String getClass_id() {
        return null;
    }

    @Override
    public String getStudent_id() {
        return null;
    }

    @Override
    public String getAttendance_time() {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public void AddAttendanceStudentModel(IAttendanceStudentView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/attendance.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
//        System.out.println("AttendanceStudentModel + AddAttendanceStudentModel + "url);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { // --> Turn to AttendenceStudentActivity (Line 135)
//                System.out.println(response);
                if (response.equals("Done")) {
                    AttendanceStudentView.OnCheckattendanceResult(1);
                } else {
                    // Kiểm tra lỗi ở dây
                    AttendanceStudentView.OnCheckattendanceResult(0);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) AttendanceStudentView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("class_id", Class_id);
                params.put("student_id", Student_id);
                params.put("attendance_time", Attendance_time);
                params.put("status", Status);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
