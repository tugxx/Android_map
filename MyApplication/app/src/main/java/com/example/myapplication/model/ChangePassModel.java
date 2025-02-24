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
import com.example.myapplication.view.IChangePassView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePassModel extends AppCompatActivity implements IChangePassModel {
    String password;
    private IChangePassView iChangePassView;
    private IPConfigModel ipConfigModel = new IPConfigModel();

    public ChangePassModel(String password, IChangePassView iChangePassView) {
    }

    @Override
    public void changePass(String password, String username, IChangePassView iChangePassView) {
        String url = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/updatepass.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) iChangePassView);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iChangePassView.responseChangePassword(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iChangePassView, error.toString().trim(), Toast.LENGTH_SHORT).show();
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

}

