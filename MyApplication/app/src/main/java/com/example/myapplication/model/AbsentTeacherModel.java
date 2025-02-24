package com.example.myapplication.model;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.view.IAbsentTimeTeacherView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  AbsentTeacherModel implements IAbsentTeacherModel {
    private String class_id; // nhận giá trị này
    private String date_for_class; // nhận giá trị này
    private String student_id; // trả ra
    private String student_name; // trả ra
    private IAbsentTimeTeacherView iAbsentTimeTeacherView;
    //Db
    private String dbstudent_id;
    private String dbstudent_name;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    //Contructor
    public AbsentTeacherModel(String class_id, String date_for_class, IAbsentTimeTeacherView context) {
        this.class_id = class_id;
        this.date_for_class = date_for_class;
        this.iAbsentTimeTeacherView = context;
    }

    //Contructor for list data
    public AbsentTeacherModel(String student_id, String student_name) {
        this.student_id =student_id;
        this.student_name = student_name;
    }

    @Override
    public String getStudent_id() {
        return this.student_id;
    }

    @Override
    public String getStudent_name() {
        return this.student_name;
    }

    @Override
    public void GetAbsentForClasstTeacherChoose(IAbsentTimeTeacherView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getabsentlist.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    Toast.makeText((Context) iAbsentTimeTeacherView, "List is Empty ! Nobody absented !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<AbsentTeacherModel> ListAbsent = new ArrayList<AbsentTeacherModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbstudent_id = object.getString("student_id").trim();
                            dbstudent_name = object.getString("student_name").trim();
                            AbsentTeacherModel absentTeacher_data = new AbsentTeacherModel(dbstudent_id,dbstudent_name);
                            ListAbsent.add(absentTeacher_data);
                        }
                        iAbsentTimeTeacherView.onLisTimeTeacherResult(ListAbsent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iAbsentTimeTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("class_id", class_id);
                params.put("date_time", date_for_class);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
