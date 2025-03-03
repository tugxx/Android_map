package com.example.myapplication.model;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.myapplication.view.IProfileStudentView;

import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class ProfileStudentModel extends AppCompatActivity implements IProfileStudentModel {
    private String student_id;
    private IProfileStudentView iProfileStudentView;
    String student_name, student_birth, student_gender, student_mail, student_phone, student_hinhanh;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    public ProfileStudentModel(String ID, IProfileStudentView iProfileStudentView) {
        this.student_id = ID;
        this.iProfileStudentView = iProfileStudentView;
    }

    public ProfileStudentModel(String student_id, String student_name, String student_birth, String student_gender, String student_mail, String student_phone, String hinhanh, IProfileStudentView iProfileStudentView) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_birth = student_birth;
        this.student_gender = student_gender;
        this.student_mail = student_mail;
        this.student_phone = student_phone;
        this.student_hinhanh = hinhanh;
        this.iProfileStudentView = iProfileStudentView;
    }

    @Override
    public void checkInforValidity(String ID, IProfileStudentView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/inforstudent.php";
//        System.out.println("ProfileStudentModel + checkInforValidity");
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // Take student info in table student
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    return;
                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        if ((object.getString("student_id").trim()).equals(ID)) {
                            // --> Turn to ProfileStudentActivity
                            iProfileStudentView.showInforStudent(object.getString("student_id").trim(),
                                    object.getString("student_name").trim(),
                                    object.getString("student_birth").trim(),
                                    object.getString("student_gender").trim(),
                                    object.getString("student_mail").trim(),
                                    object.getString("student_phone").trim(),
                                    object.getString("student_image").trim());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iProfileStudentView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("student_id", student_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void updateInforStudent(String ID, String student_name, String student_birth, String student_gender, String student_mail, String student_phone, String student_image, IProfileStudentView iProfileStudentView) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/updateinforstudent.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) iProfileStudentView);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int checkresult = 0;
                if (response.equals("Done")) {
                    checkresult = 1;
                    iProfileStudentView.updateSuccessfully(checkresult);

                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        iProfileStudentView.updateSuccessfully(checkresult);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iProfileStudentView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("student_id", ID);
                params.put("student_name", student_name);
                params.put("student_birth", student_birth);
                params.put("student_gender", student_gender);
                params.put("student_mail", student_mail);
                params.put("student_phone", student_phone);
                params.put("student_image", student_image);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void checkInforValidityMain(String id, IProfileStudentView iProfileStudentView) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/inforstudent.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) iProfileStudentView);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    System.out.println("error");
                    return;
                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        if ((object.getString("student_id").trim()).equals(id)) {
                            // --> Turn to ProfileStudentActivity
                            iProfileStudentView.showInforStudentMain(object.getString("student_id").trim(),
                                    object.getString("student_name").trim(),
                                    object.getString("student_image").trim());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iProfileStudentView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("student_id", student_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
