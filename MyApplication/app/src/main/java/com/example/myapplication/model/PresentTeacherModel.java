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
import com.example.myapplication.view.IPresentTimeStudentView;
import com.example.myapplication.view.IPresentTimeTeacherView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PresentTeacherModel implements IPresentTeacherModel {
    private String class_id; // nhận giá trị nàt
    private String student_id; // trả ra
    private String student_name; // trả ra
    private String date_for_class; // nhận giá trị này
    private String hour_start_for_class; // nhận giá trị này
    private String attendance_time; // trả ra
    private String status_attendance; // trả ra
    private IPresentTimeTeacherView iPresentTimeTeacherView;
    // DB
    private String dbstudent_id;
    private String dbstudent_name;
    private String dbattendance_time;
    private String dbstatus_attendance;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    //Contructor
    public PresentTeacherModel(String class_id, String date_for_class, String hour_start_for_class ,IPresentTimeTeacherView context) {
        this.class_id = class_id;
        this.date_for_class = date_for_class;
        this.hour_start_for_class =hour_start_for_class;
        this.iPresentTimeTeacherView = context;
    }

    // contructor for list data
    public PresentTeacherModel(String student_id, String student_name, String attendance_time, String stutus_attendance) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.attendance_time = attendance_time;
        this.status_attendance = stutus_attendance;
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
    public String getAttendancetime() {
        return this.attendance_time;
    }

    @Override
    public String getStatusAttendance() {
        return this.status_attendance;
    }

    @Override
    public void GetAttendanceForClasstTeacherChoose(IPresentTimeTeacherView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getTimepresentforteacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    Toast.makeText((Context) iPresentTimeTeacherView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<PresentTeacherModel> ListTimePresent = new ArrayList<PresentTeacherModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbstudent_id = object.getString("student_id").trim();
                            dbstudent_name = object.getString("student_name").trim();
                            dbattendance_time = object.getString("attendance_time").trim();
                            if (CheckDates(gethourforattendance(dbattendance_time), hour_start_for_class))
                                dbstatus_attendance = "On time";
                            else  dbstatus_attendance = "Late";
                            PresentTeacherModel time_present_data = new PresentTeacherModel(dbstudent_id,dbstudent_name,dbattendance_time,dbstatus_attendance);
                            ListTimePresent.add(time_present_data);
                        }
                      iPresentTimeTeacherView.onLisTimeTeacherResult(ListTimePresent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iPresentTimeTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
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
    // Check time "ontime" or "Late"
    public boolean CheckDates(String timeattendacce, String timestartclass) {

        SimpleDateFormat dfDate = new SimpleDateFormat("hh:mm:ss a");

        boolean b = false;

        try {
            if (dfDate.parse(timeattendacce).before(dfDate.parse(timestartclass))) {
                b = true;  // If start date is before end date.
            } else if (dfDate.parse(timeattendacce).equals(dfDate.parse(timestartclass))) {
                b = true;  // If two dates are equal.
            } else {
                b = false; // If start date is after the end date.
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // b = true là on time , b = false là Late
        return b;
    }
    // get hour for attendance
    public String gethourforattendance(String input) {
        String[] parts = input.split(" ", 2);
        return parts[1];
    }
}
