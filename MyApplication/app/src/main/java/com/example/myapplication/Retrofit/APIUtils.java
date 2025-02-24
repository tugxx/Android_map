package com.example.myapplication.Retrofit;

import com.example.myapplication.model.IPConfigModel;

public class APIUtils {
    public static String Base_Ur = "";
    private static IPConfigModel ipConfigModel = new IPConfigModel();
    public static DataClient getData(){
        Base_Ur = "http://" + ipConfigModel.getIpconfig() + "/PHP_API/";
        return RetrofitClient.getClient(Base_Ur).create(DataClient.class);
    }
}
