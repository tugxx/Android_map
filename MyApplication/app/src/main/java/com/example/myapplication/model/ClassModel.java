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
import com.example.myapplication.PresentStudentActivity;
import com.example.myapplication.view.IAbsentTeacherView;
import com.example.myapplication.view.IAttendenceTeacherView;
import com.example.myapplication.view.IPresentTeacherView;
import com.example.myapplication.view.ISClassListView;
import com.example.myapplication.view.IPresentStudentView;
import com.example.myapplication.view.ITClassListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassModel extends AppCompatActivity implements IClassModel {
    private String class_id;
    private String class_name;
    private String class_idteacher;
    private  String class_time;
    private int class_totalstudent;
    private  String student_id;
    // Db get
    private String dbclass_id;
    private String dbclass_name;
    private String dbclass_idteacher;
    private  String dbclass_classtime;
    private int dbclass_totalstudent;
    private String db_student_id;
    private  IPresentStudentView iPresentStudentView;
    private IAttendenceTeacherView iAttendenceTeacherView;
    private IPresentTeacherView iPresentTeacherView;
    private IAbsentTeacherView iAbsentTeacherView;
    private ISClassListView iClassListView;
    private ITClassListView itClassListView;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    public ClassModel() {

    }
// Funcion nhận tham số
    public ClassModel(String id, ITClassListView context) {
        this.class_idteacher = id;
        this.itClassListView = context;
    }
    public ClassModel(String id, ISClassListView context) {
        this.student_id = id;
        this.iClassListView = context;
    }
    public ClassModel(String id, IAttendenceTeacherView context) {
        this.class_idteacher = id;
        this.iAttendenceTeacherView = context;
    }
    public ClassModel(String id, IPresentStudentView context) {
        this.student_id = id;
        this.iPresentStudentView = context;
    }
    public ClassModel(String id, IAbsentTeacherView context) {
        this.class_idteacher = id;
        this.iAbsentTeacherView = context;
    }
    // Contructor Model

    public ClassModel(String Class_id, String Class_name, String Class_idteacher, int Class_totalstudent) {
        this.class_id = Class_id;
        this.class_name = Class_name;
        this.class_idteacher = Class_idteacher;
        this.class_totalstudent = Class_totalstudent;
    }
    public ClassModel(String Class_id, String Class_name, String Class_idteacher, String Class_time ,int Class_totalstudent) {
        this.class_id = Class_id;
        this.class_name = Class_name;
        this.class_idteacher = Class_idteacher;
        this.class_time = Class_time;
        this.class_totalstudent = Class_totalstudent;
    }
    public ClassModel(String Class_id, String Class_name) {
        this.class_id = Class_id;
        this.class_name = Class_name;
    }
    public ClassModel(String id, IPresentTeacherView context) {
        this.class_idteacher = id;
        this.iPresentTeacherView = context;
    }

    public ClassModel(String Class_id, String Class_name,int class_totalstudent) {
        this.class_id = Class_id;
        this.class_name = Class_name;
        this.class_totalstudent = class_totalstudent;
    }

    @Override
    public String getClass_id() {
        return this.class_id;
    }



    @Override
    public String getClass_name() {
        return this.class_name;
    }

    @Override
    public String getClass_idteacher() {
        return this.class_idteacher;
    }

    @Override
    public String getClass_time() {
        return this.class_time;
    }

    @Override
    public int getClass_Totalstudent() {
        return this.class_totalstudent;
    }

    @Override
    public void getDataClassForIDTeacher(String id, IAttendenceTeacherView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getclassforteacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Error")) {
                    Toast.makeText((Context) iAttendenceTeacherView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ClassModel> ListClass = new ArrayList<ClassModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbclass_id = object.getString("class_id").trim();
                            dbclass_name = object.getString("class_name").trim();
                            dbclass_idteacher = object.getString("teacher_id").trim();
                            dbclass_totalstudent = object.getInt("total_student");
                            ClassModel class_data = new ClassModel(dbclass_id, dbclass_name, dbclass_idteacher, dbclass_totalstudent);
                            ListClass.add(class_data);
                        }
//                        System.out.println("ClassModel + getDataClassForIDTeacher");
                        iAttendenceTeacherView.onListClassResult(ListClass); // --> Turn to AttendenceTeacherActivity (Line 70)
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iAttendenceTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("teacher_id", class_idteacher);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void getDataClassForIDStudent(String id, IPresentStudentView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getclassforstudent_present.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if ((response.trim().trim()).equals("Error")) {
                    Toast.makeText((Context) iPresentStudentView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ClassModel> ListClass = new ArrayList<ClassModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbclass_id = object.getString("class_id").trim();
                            dbclass_name = object.getString("class_name").trim();
                            ClassModel class_data = new ClassModel(dbclass_id, dbclass_name);
                            ListClass.add(class_data);
                        }
//                        System.out.println("ClassModel + getDataClassForIDStudent");
                        iPresentStudentView.onListClassStudentResult(ListClass); // --> Turn to PresentStudentActivity (Line 96)
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iAttendenceTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
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
    public void getDataClassForIDTeacher(String id, IPresentTeacherView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getclassforteacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Error")) {
                    Toast.makeText((Context) iPresentTeacherView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ClassModel> ListClass = new ArrayList<ClassModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbclass_id = object.getString("class_id").trim();
                            dbclass_name = object.getString("class_name").trim();
                            dbclass_idteacher = object.getString("teacher_id").trim();
                            dbclass_classtime = object.getString("class_time").trim();
                            dbclass_totalstudent = object.getInt("total_student");
                            ClassModel class_data = new ClassModel(dbclass_id, dbclass_name, dbclass_idteacher, dbclass_classtime ,dbclass_totalstudent);
                            ListClass.add(class_data);
                        }
                        /// --> Turn to PresentTeacherActivity (Line 67)
                        iPresentTeacherView.onListClassResult(ListClass); /// chưa trả giá trị ra
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iAttendenceTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("teacher_id", class_idteacher);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void getDataClassForIDTeacher(String id, IAbsentTeacherView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getclassforteacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Error")) {
                    Toast.makeText((Context) iAbsentTeacherView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ClassModel> ListClass = new ArrayList<ClassModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbclass_id = object.getString("class_id").trim();
                            dbclass_name = object.getString("class_name").trim();
                            dbclass_idteacher = object.getString("teacher_id").trim();
                            dbclass_classtime = object.getString("class_time").trim();
                            dbclass_totalstudent = object.getInt("totalstudent");
                            ClassModel class_data = new ClassModel(dbclass_id, dbclass_name, dbclass_idteacher, dbclass_classtime ,dbclass_totalstudent);
                            ListClass.add(class_data);
                        }
                        /// --> Turn to AbsentTeacherActivity (Line 67)
                        iAbsentTeacherView.onListClassResult(ListClass); /// Trả về Absent
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iAttendenceTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("teacher_id", class_idteacher);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    @Override
    public void getDataClassForIDTeacher2(String id, ITClassListView context) {
        String url ="http://" + ipConfigModel.getIpconfig() + "/PHP_API/dbTClassList.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Error")) {
                    Toast.makeText((Context) itClassListView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ClassModel> ListClass = new ArrayList<ClassModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbclass_id = object.getString("id").trim();
                            dbclass_name = object.getString("name").trim();
                            dbclass_totalstudent = object.getInt("total_student");
//                            System.out.println("getDataClassForIDTeacher2"+dbclass_totalstudent);
                            ClassModel class_data = new ClassModel(dbclass_id, dbclass_name, dbclass_totalstudent);
                            ListClass.add(class_data);
                        }
                        itClassListView.onListClassTeacherResult(ListClass); /// --> Turn to TClassListActivity (Line 86)
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) itClassListView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("teacher_id", class_idteacher);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void getDataClassForIDStudent(String id, ISClassListView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getclassforstudent_present.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Error")) {
                    Toast.makeText((Context) iClassListView, "List is Empty ! Please Update data again !  ", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        ArrayList<ClassModel> ListClass = new ArrayList<ClassModel>();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            dbclass_id = object.getString("class_id").trim();
                            dbclass_name = object.getString("class_name").trim();
                            ClassModel class_data = new ClassModel(dbclass_id, dbclass_name);
                            ListClass.add(class_data);
                        }
                        iClassListView.onListClassStudentResult(ListClass); // --> Turn to SClassListActivity (Line 92)
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iClassListView, error.toString().trim(), Toast.LENGTH_SHORT).show();
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
