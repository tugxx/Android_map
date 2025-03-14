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
import com.example.myapplication.view.IScheduleStudentView;
import com.example.myapplication.view.ITScheduleTeacherView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ScheduleModel implements IScheduleModel {
    private IPConfigModel ipConfigModel = new IPConfigModel();
    private IScheduleStudentView iScheduleStudentView;
    private ITScheduleTeacherView itScheduleTeacherView;
    private String s_id;
    private String s_name;
    private String s_tstart;
    private String s_tend;
    private String s_daybegin;
    private String s_dayend;
    private String student_id;
    private String s_location;
    private String teacher_id;

    public ScheduleModel( String teacher_id,ITScheduleTeacherView itScheduleTeacherView) {
        this.itScheduleTeacherView = itScheduleTeacherView;
        this.teacher_id = teacher_id;
    }

    public ScheduleModel(String student_id, IScheduleStudentView iScheduleStudentView) {
        this.iScheduleStudentView = iScheduleStudentView;
        this.student_id = student_id;
    }

    public ScheduleModel(String s_id, String s_name, String s_tstart, String s_tend, String s_daybegin, String s_dayend,
                         String student_id, String s_location, String teacher_id) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_tstart = s_tstart;
        this.s_tend = s_tend;
        this.s_daybegin = s_daybegin;
        this.s_dayend = s_dayend;
        this.student_id = student_id;
        this.s_location = s_location;
        this.teacher_id = teacher_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_tstart() {
        return s_tstart;
    }

    public void setS_tstart(String s_tstart) {
        this.s_tstart = s_tstart;
    }

    public String getS_tend() {
        return s_tend;
    }

    public void setS_tend(String s_tend) {
        this.s_tend = s_tend;
    }

    public String getS_daybegin() {
        return s_daybegin;
    }

    public void setS_daybegin(String s_daybegin) {
        this.s_daybegin = s_daybegin;
    }

    public String getS_dayend() {
        return s_dayend;
    }

    public void setS_dayend(String s_dayend) {
        this.s_dayend = s_dayend;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getS_location() {
        return s_location;
    }

    public void setS_location(String s_location) {
        this.s_location = s_location;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    @Override
    public void getDataScheduleForStudent(String id, IScheduleStudentView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/dbScheduleStudent.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Error")) {
                    Toast.makeText((Context) iScheduleStudentView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ScheduleModel> ListClass = new ArrayList<ScheduleModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            s_id = object.getString("s_id").trim();
                            s_name = object.getString("s_name").trim();
                            s_tstart = object.getString("s_tstart").trim();
                            s_tend = object.getString("s_tend").trim();
                            s_daybegin = object.getString("s_daybegin").trim();
                            s_dayend = object.getString("s_dayend").trim();
                            student_id = object.getString("student_id").trim();
                            s_location = object.getString("s_location").trim();
                            teacher_id = object.getString("teacher_id").trim();
                            ScheduleModel schedule_data = new ScheduleModel(s_id, s_name,s_tstart,s_tend,s_daybegin,s_dayend
                                    ,student_id,s_location,teacher_id);
                            ListClass.add(schedule_data);
                        }

                        iScheduleStudentView.onListScheduleStudentResult(ListClass); // --> Turn to StudentScheduleActivity (Line 94)
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iScheduleStudentView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("student_id", student_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void getDataScheduleForStudent(String id, ITScheduleTeacherView context) {
        String url = "http://"+ ipConfigModel.getIpconfig() +"/PHP_API/dbScheduleTeacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Error")) {
                    Toast.makeText((Context) itScheduleTeacherView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ScheduleModel> ListClass = new ArrayList<ScheduleModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            s_id = object.getString("s_id").trim();
                            s_name = object.getString("s_name").trim();
                            s_tstart = object.getString("s_tstart").trim();
                            s_tend = object.getString("s_tend").trim();
                            s_daybegin = object.getString("s_daybegin").trim();
                            s_dayend = object.getString("s_dayend").trim();
                            student_id = object.getString("student_id").trim();
                            s_location = object.getString("s_location").trim();
                            teacher_id = object.getString("teacher_id").trim();
                            ScheduleModel schedule_data = new ScheduleModel(s_id, s_name,s_tstart,s_tend,s_daybegin,s_dayend
                                    ,student_id,s_location,teacher_id);
                            ListClass.add(schedule_data);
                        }
                        itScheduleTeacherView.onListScheduleStudentResult(ListClass);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) itScheduleTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("teacher_id", teacher_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
