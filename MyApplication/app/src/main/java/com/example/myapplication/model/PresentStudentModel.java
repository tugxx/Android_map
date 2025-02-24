package com.example.myapplication.model;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.view.IPresentTimeStudentView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PresentStudentModel extends AppCompatActivity implements IPresentStudentModel {
    private String class_id;
    private String student_id;
    private String attendance_time;
    private IPresentTimeStudentView iPresentTimeStudentView;

    // db_get
    private String db_attendance_time;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    public PresentStudentModel(String class_id, String student_id, IPresentTimeStudentView context) {
        this.class_id = class_id;
        this.student_id = student_id;
        this.iPresentTimeStudentView = context;
    }
    public PresentStudentModel(String attendance_time)
    {
        this.attendance_time = attendance_time;
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
    public String getAttendancetime() {
        return this.attendance_time;
    }

    @Override
    public void GetAttendanceForClassStudentChoose(IPresentTimeStudentView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getTimepresentforstudent.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    Toast.makeText((Context) iPresentTimeStudentView, "List is Empty ! Nobody attendanced !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<PresentStudentModel> ListTimePresent = new ArrayList<PresentStudentModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            PresentStudentModel time_present_data = new PresentStudentModel(object.getString("attendance_time").trim());
                            ListTimePresent.add(time_present_data);
                        }
                        iPresentTimeStudentView.onLisTimeStudentResult(ListTimePresent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iPresentTimeStudentView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("class_id", class_id);
                params.put("student_id", student_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
