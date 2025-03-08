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
import com.example.myapplication.view.ILoginView;

import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

//import com.example.myapplication.StudentActivity;
//import com.vishnusivadas.advanced_httpurlconnection.FetchData;
//import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class UserModelModel extends AppCompatActivity implements IUserModel {
    private String username;
    private String password;
    private String dbusername;
    private String dbpassword;
    private String dbteacher_id;
    private String dbstudent_id;
    private String dbrole;
    private Boolean results;
    private ILoginView loginView;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    public UserModelModel() {
    }

    public UserModelModel(String username, String password, ILoginView loginView) {
        this.loginView = loginView;
        this.username = username;
        this.password = password;
    }

    @Override
    public Boolean getResults() {
        return results;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void checkUserValidity(ILoginView context) {
        // use IPConfigModel class
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/getuser.php";
//        String url = "http://" + ipConfigModel.getIpconfig() + "/student_attendence/getuser.php";

//        System.out.println("UserModelModel - checkUserValidity "+url);
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        // requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                    Toast.makeText((Context) loginView, "Account is Error, Please check info again !", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        dbusername = object.getString("username").trim();
                        dbpassword = object.getString("password").trim();
                        // dbrole = "1" - Admin, "2" - Teacher, "3" - Student
                        dbrole = object.getString("i_role").trim();
                        dbstudent_id = object.getString("i_student").trim();
                        dbteacher_id = object.getString("i_teacher").trim();

//                        System.out.println("UserModelModel - checkUserValidity - onResponse");
                        if (object != null) {
                            // --> Turn to LoginActivity
                            loginView.onLoginResult(dbrole, dbteacher_id, dbstudent_id);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) loginView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

