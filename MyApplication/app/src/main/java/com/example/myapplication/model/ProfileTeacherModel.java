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
import com.example.myapplication.view.IProfileTeacherView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProfileTeacherModel extends AppCompatActivity implements IProfileTeacherModel{
    private String teacher_id;
    private IProfileTeacherView iProfileTeacherView;
    private String teacher_name, teacher_birth, teacher_gender, teacher_mail, teacher_phone, teacher_image;
    private IPConfigModel ipConfigModel = new IPConfigModel();
    public ProfileTeacherModel() {

    }
    public ProfileTeacherModel(String ID, IProfileTeacherView iProfileTeacherView) {
        this.teacher_id = ID;
        this.iProfileTeacherView = iProfileTeacherView;
    }

    public ProfileTeacherModel(String teacher_id, String teacher_name, String teacher_birth, String teacher_gender, String teacher_mail, String teacher_phone, String teacher_image, IProfileTeacherView iProfileTeacherView) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_birth = teacher_birth;
        this.teacher_gender = teacher_gender;
        this.teacher_mail = teacher_mail;
        this.teacher_phone = teacher_phone;
        this.teacher_image = teacher_image;
        this.iProfileTeacherView = iProfileTeacherView;
    }

    @Override
    public void checkInforValidity(String ID, IProfileTeacherView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/inforteacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        if ((object.getString("teacher_id").trim()).equals(ID)) {
                            iProfileTeacherView.showInforTeacher(object.getString("teacher_id").trim(),
                                    object.getString("teacher_name").trim(),
                                    object.getString("teacher_birth").trim(),
                                    object.getString("teacher_gender").trim(),
                                    object.getString("teacher_mail").trim(),
                                    object.getString("teacher_phone").trim(),
                                    object.getString("teacher_image").trim());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iProfileTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("teacher_id", teacher_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void updateInforTeacher(String ID, String teacher_name, String teacher_birth, String teacher_gender, String teacher_mail, String teacher_phone, String teacher_image, IProfileTeacherView iProfileTeacherView) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/updateinforteacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) iProfileTeacherView);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int checkresult = 0;
                if (response.equals("Done")) {
                    checkresult = 1;
                    iProfileTeacherView.updateSuccessfully(checkresult);

                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        iProfileTeacherView.updateSuccessfully(checkresult);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iProfileTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("teacher_id", ID);
                params.put("teacher_name", teacher_name);
                params.put("teacher_birth", teacher_birth);
                params.put("teacher_gender", teacher_gender);
                params.put("teacher_mail", teacher_mail);
                params.put("teacher_phone", teacher_phone);
                params.put("teacher_image", teacher_image);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void checkInforValidityMain(String id, IProfileTeacherView iProfileTeacherView) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/inforteacher.php";
//        System.out.println(url);
        RequestQueue requestQueue = Volley.newRequestQueue((Context) iProfileTeacherView);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        if ((object.getString("teacher_id").trim()).equals(id)) {
                            iProfileTeacherView.showInforTeacherMain(object.getString("teacher_id").trim(),
                                    object.getString("teacher_name").trim(),
                                    object.getString("teacher_image").trim());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iProfileTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("teacher_id", teacher_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
