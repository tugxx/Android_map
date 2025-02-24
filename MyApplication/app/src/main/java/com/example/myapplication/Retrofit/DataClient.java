package com.example.myapplication.Retrofit;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DataClient {

    @Multipart
    @POST("uploadimage.php")
    Call<String> Uploadphoto(@Part MultipartBody.Part photo);
}
