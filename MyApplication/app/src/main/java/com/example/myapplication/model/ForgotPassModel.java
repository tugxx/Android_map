package com.example.myapplication.model;

import android.content.Context;
import android.widget.EditText;
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
import com.example.myapplication.view.IForgotPassView;
import com.example.myapplication.view.IProfileStudentView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForgotPassModel extends AppCompatActivity implements IForgotPassModel{
    private IForgotPassView iForgotPassView;
    String username, student_phone;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    public ForgotPassModel(String username, IForgotPassView iForgotPassView) {
        this.username = username;
        this.iForgotPassView = iForgotPassView;
    }


    @Override
    public void checkUser(String username,  IForgotPassView context) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/usercheck.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Error")) {
                } else {
                    try {
                        JSONObject object = new JSONObject(response);
                        if ((object.getString("username").trim()).equals(username))
                        {
                            iForgotPassView.showPhone(object.getString("student_phone").trim());
                        }
                        else
                        {
                            iForgotPassView.showPhone("Not Exist");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iForgotPassView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("username", username);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}

