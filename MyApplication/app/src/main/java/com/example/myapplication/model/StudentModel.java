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
import com.example.myapplication.view.ISClassListDetailView;
import com.example.myapplication.view.ISClassListView;
import com.example.myapplication.view.IStudentListView;
import com.example.myapplication.view.ITClassListDetailView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentModel implements IStudentModel, Serializable {
    private String class_id;
    private String student_id;
    private String student_name;
    private String student_birth;
    private String student_gender;
    private String student_mail;
    private String student_phone;
    private String student_image;
    private int status;

    private ISClassListDetailView isClassListDetailView;
    private ITClassListDetailView itClassListDetailView;
    private IStudentListView iStudentListView;

    private IPConfigModel ipConfigModel = new IPConfigModel();

    public StudentModel(String class_id, ITClassListDetailView itClassListDetailView) {
        this.class_id = class_id;
        this.itClassListDetailView = itClassListDetailView;
    }

    public StudentModel(String class_id, ISClassListDetailView isClassListDetailView) {
        this.class_id = class_id;
        this.isClassListDetailView = isClassListDetailView;
    }
    public StudentModel(String student_id, IStudentListView iStudentListView) {
        this.student_id = student_id;
        this.iStudentListView = iStudentListView;
    }
    public StudentModel(String student_id, String student_name, String student_birth, String student_gender, String student_mail, String student_phone, String student_image, int status) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_birth = student_birth;
        this.student_gender = student_gender;
        this.student_mail = student_mail;
        this.student_phone = student_phone;
        this.student_image = student_image;
        this.status = status;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_birth() {
        return student_birth;
    }

    public void setStudent_birth(String student_birth) {
        this.student_birth = student_birth;
    }

    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }

    public String getStudent_mail() {
        return student_mail;
    }

    public void setStudent_mail(String student_mail) {
        this.student_mail = student_mail;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_image() {
        return student_image;
    }

    public void setStudent_image(String student_image) {
        this.student_image = student_image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public void getDataStudentForIDClass(String id, ISClassListDetailView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/classSListDetail.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    Toast.makeText((Context) isClassListDetailView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                        try {
                        ArrayList<StudentModel> ListStudent = new ArrayList<StudentModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            student_id = object.getString("id").trim();
                            student_name = object.getString("fname").trim();
                            student_birth = object.getString("birth").trim();
                            student_gender = object.getString("gender").trim();
                            student_mail = object.getString("mail").trim();
                            student_phone = object.getString("phone").trim();
                            student_image = object.getString("image").trim();
                            status = object.getInt("status");
                            StudentModel student_data = new StudentModel(student_id, student_name,student_birth,
                                    student_gender,student_mail, student_phone, student_image,status);
                            ListStudent.add(student_data);
                        }
                        isClassListDetailView.onListClassStudentResult(ListStudent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) isClassListDetailView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("class_id", class_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void getDataStudentForIDClass(String id, ITClassListDetailView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/classSListDetail.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    Toast.makeText((Context) itClassListDetailView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<StudentModel> ListStudent = new ArrayList<StudentModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            student_id = object.getString("id").trim();
                            student_name = object.getString("fname").trim();
                            student_birth = object.getString("birth").trim();
                            student_gender = object.getString("gender").trim();
                            student_mail = object.getString("mail").trim();
                            student_phone = object.getString("phone").trim();
                            student_image = object.getString("image").trim();
                            status = object.getInt("status");
                            StudentModel student_data = new StudentModel(student_id, student_name,student_birth,
                                    student_gender,student_mail, student_phone, student_image,status);
                            ListStudent.add(student_data);
                        }
                        itClassListDetailView.onListClassStudentResult(ListStudent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) itClassListDetailView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("class_id", class_id);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void getDataStudentForIDStudent(String id, IStudentListView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/dbStudentList.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    Toast.makeText((Context) iStudentListView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<StudentModel> ListStudent = new ArrayList<StudentModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            student_id = object.getString("id").trim();
                            student_name = object.getString("fname").trim();
                            student_birth = object.getString("birth").trim();
                            student_gender = object.getString("gender").trim();
                            student_mail = object.getString("mail").trim();
                            student_phone = object.getString("phone").trim();
                            student_image = object.getString("image").trim();
                            status = object.getInt("status");
                            StudentModel student_data = new StudentModel(student_id, student_name,student_birth,
                                    student_gender,student_mail, student_phone, student_image,status);
                            ListStudent.add(student_data);
                        }
                        iStudentListView.onListClassStudentResult(ListStudent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iStudentListView, error.toString().trim(), Toast.LENGTH_SHORT).show();
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
}
