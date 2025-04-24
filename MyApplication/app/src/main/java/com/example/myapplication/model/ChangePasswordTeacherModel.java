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
import com.example.myapplication.ChangePasswordTeacherActivity;
import com.example.myapplication.view.IChangePasswordTeacherView;
import com.example.myapplication.view.IProfileTeacherView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePasswordTeacherModel extends AppCompatActivity implements IChangePasswordTeacherModel{
    private String id_teacher, old_password, new_password;
    private IChangePasswordTeacherView iChangePasswordTeacherView;
    private IPConfigModel ipConfigModel =  new IPConfigModel();

    public ChangePasswordTeacherModel(String id_teacher, String old_password, String new_password, IChangePasswordTeacherView iChangePasswordTeacherView) {
        this.id_teacher = id_teacher;
        this.old_password = old_password;
        this.new_password = new_password;
        this.iChangePasswordTeacherView = iChangePasswordTeacherView;
    }

    @Override
    public void Changepasswordteacher(String id_teacher, String old_password, String new_password, IChangePasswordTeacherView iChangePasswordTeacherView) {
        String url = "http://"+ipConfigModel.getIpconfig()+"/PHP_API/changpasswordteacher.php";
        RequestQueue requestQueue = Volley.newRequestQueue((Context) iChangePasswordTeacherView);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int checkresult = 0;
                if (response.equals("Done")) {
                    checkresult = 1;
                    iChangePasswordTeacherView.ChangeResult(checkresult); /// --> Turn to ChangePasswordTeacherActivity (Line 114)

                } else {
                    iChangePasswordTeacherView.ChangeResult(checkresult); /// --> Turn to ChangePasswordTeacherActivity (Line 114)
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText((Context) iChangePasswordTeacherView, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                // params.put("type","login");
                params.put("i_teacher", id_teacher);
                params.put("oldpass", old_password);
                params.put("password", new_password);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
