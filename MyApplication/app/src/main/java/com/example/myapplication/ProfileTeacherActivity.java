package com.example.myapplication;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.database.Cursor;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Retrofit.APIUtils;
import com.example.myapplication.Retrofit.DataClient;
import com.example.myapplication.model.IPConfigModel;
import com.example.myapplication.presenter.IProfileStudentPresenter;
import com.example.myapplication.presenter.IProfileTeacherPresenter;
import com.example.myapplication.presenter.ProfileTeacherPresenter;
import com.example.myapplication.view.IProfileTeacherView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileTeacherActivity extends AppCompatActivity implements IProfileTeacherView, View.OnClickListener {
    private EditText edt_fullname_teacher, edt_email_teacher, edt_phone_teacher, edt_major_teacher, edt_birthday_teacher, edt_ID_teacher;
    private RadioButton rb_male_teacher, rb_female_teacher;
    private ImageView img_btn_home, img_btn_back;
    private CircleImageView img_avatar_teacher;
    int SELECT_PICTURE = 200;
    private static int RESULT_LOAD_IMAGE = 1;
    private Button btn_update_teacher, btn_changepass_teacher, btn_choose_image;
    private String id_teacher;
    String realpath = "";
    private String hinhanhUrl;
    private IProfileTeacherPresenter profileTeacherPresenter = new ProfileTeacherPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile_teacher);
        mapping();

        Intent intent_teacher = getIntent();
        id_teacher = intent_teacher.getStringExtra("ID_TEACHER");

        //Initteacher
        profileTeacherPresenter.getIDTeacher(id_teacher, this); /// --> Turn to ProfileTeacherPresenter (Line 23)

        //Set Listener
        img_btn_home.setOnClickListener(this); // Home
        img_btn_back.setOnClickListener(this); // Back <

        btn_update_teacher.setOnClickListener(this);
        btn_changepass_teacher.setOnClickListener(this);

        btn_choose_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_PICTURE);
            }
        });
    }

    public void mapping() {
        edt_fullname_teacher = (EditText) findViewById(R.id.edt_fullname_teacher); // Full name
        edt_email_teacher = (EditText) findViewById(R.id.edt_email_teacher); // Email
        edt_phone_teacher = (EditText) findViewById(R.id.edt_phone_teacher); // Phone
        edt_major_teacher = (EditText) findViewById(R.id.edt_major_teacher); //  Major
        edt_birthday_teacher = (EditText) findViewById(R.id.edt_birthday_teacher); // Date Of Birth
        edt_ID_teacher = (EditText) findViewById(R.id.edt_ID_teacher); // Teacher ID
        btn_update_teacher = (Button) findViewById(R.id.btn_update_teacher); // Update
        img_btn_home = (ImageView) findViewById(R.id.img_btn_home_teacher); // Home
        img_btn_back = (ImageView) findViewById(R.id.img_btn_back_teacher); // Back <
        img_avatar_teacher = (CircleImageView) findViewById(R.id.img_avatar_teacher); // Avatar
        btn_changepass_teacher = (Button) findViewById(R.id.btn_changepass_teacher); // Change Password
        btn_choose_image = (Button) findViewById(R.id.btn_choose_image_teacher); // Choose
        rb_male_teacher = (RadioButton) findViewById(R.id.rb_male_teacher); // Male
        rb_female_teacher = (RadioButton) findViewById(R.id.rb_female_teacher); // Female
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SELECT_PICTURE && resultCode == RESULT_OK && data !=null)
        {
            Uri uri = data.getData();
            realpath = getRealPathFromURI(uri);
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img_avatar_teacher.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_home_teacher || v.getId() == R.id.img_btn_back_teacher) { // Home and Back <
            Intent teacher1 = new Intent(this, TeacherActivity.class); /// --> Turn to TeacherActivity
            teacher1.putExtra("ID_TEACHER", id_teacher);  // Truyền ID_teacher
            startActivity(teacher1);

        } else if (v.getId() == R.id.btn_update_teacher) { // Update
            enable(); /// Turn to line 204
            btn_changepass_teacher.setText("Save");
            btn_choose_image.setVisibility(View.VISIBLE);

        } else if (v.getId() == R.id.btn_changepass_teacher) { // Change Password
            if (btn_changepass_teacher.getText().toString().trim().equals("Save")) {
                if (edt_ID_teacher.getText().toString().trim().equals("")
                        || edt_phone_teacher.getText().toString().trim().equals("")
                        || edt_birthday_teacher.getText().toString().trim().equals("")
                        || edt_fullname_teacher.getText().toString().trim().equals("")
                        || edt_email_teacher.getText().toString().trim().equals("")) {
                    Toast.makeText(this, "Please complete all information!", Toast.LENGTH_SHORT).show();
                } else {
                    uploadimgaetoserver(); /// Turn to line 242
                    Intent teacher = new Intent(this, ProfileTeacherActivity.class); /// --> Turn to ProfileTeacherActivity
                    teacher.putExtra("ID_TEACHER", id_teacher);  // Truyền ID_teacher
                    startActivity(teacher);
                }
            } else {
                Intent teacher01 = new Intent(this, ChangePasswordTeacherActivity.class); /// --> Turn to ChangePasswordTeacherActivity
                teacher01.putExtra("ID_TEACHER", id_teacher);  // Truyền ID_teacher
                startActivity(teacher01);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showInforTeacher(String teacher_id, String teacher_name, String teacher_birth, String teacher_gender, String teacher_mail, String teacher_phone, String teacher_image) {
        edt_ID_teacher.setText(teacher_id);
        edt_email_teacher.setText(teacher_mail);
        edt_phone_teacher.setText(teacher_phone);
        edt_fullname_teacher.setText(teacher_name);
        edt_birthday_teacher.setText(teacher_birth);
        edt_major_teacher.setText("IT");
        IPConfigModel ipConfigModel = new IPConfigModel();
        hinhanhUrl = "http://"+ipConfigModel.getIpconfig()+"/PHP_API/Upload/teacher_images/"+teacher_image;
        Picasso.get().load(teacher_image).into(img_avatar_teacher);
        if (teacher_gender.equals("nam")) {
            rb_male_teacher.setChecked(true);
        } else {
            rb_female_teacher.setChecked(true);
        }
        disable(); /// Turn to line 191
        btn_choose_image.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateSuccessfully(int result) {
        if (result == 1) {
            Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Update Fail", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showInforTeacherMain(String teacher_id, String teacher_name, String teacher_image) {

    }

    private void disable() {
        edt_major_teacher.setFocusable(false);
        edt_ID_teacher.setFocusable(false);
        edt_email_teacher.setFocusable(false);
        edt_phone_teacher.setFocusable(false);
        edt_birthday_teacher.setFocusable(false);
        edt_fullname_teacher.setFocusable(false);
        rb_male_teacher.setEnabled(false);
        rb_female_teacher.setEnabled(false);
    }

    private void enable() {
        edt_email_teacher.setFocusableInTouchMode(true);
        edt_phone_teacher.setFocusableInTouchMode(true);
        edt_birthday_teacher.setFocusableInTouchMode(true);
        edt_fullname_teacher.setFocusableInTouchMode(true);
        edt_birthday_teacher.setFocusableInTouchMode(true);
        rb_male_teacher.setEnabled(true);
        rb_female_teacher.setEnabled(true);
    }

    public void updateInforTeacher(String hinhanhUrl) {
        String teacher_id = edt_ID_teacher.getText().toString().trim();
        String teacher_phone = edt_phone_teacher.getText().toString().trim();
        String teacher_birth = edt_birthday_teacher.getText().toString().trim();
        String teacher_name = edt_fullname_teacher.getText().toString().trim();
        String teacher_mail = edt_email_teacher.getText().toString().trim();
        String teacher_image = hinhanhUrl;
        String teacher_gender;
        if (rb_male_teacher.isChecked()) {
            teacher_gender = "nam";
        } else {
            teacher_gender = "nu";
        }
        profileTeacherPresenter.checkUpdate(teacher_id, teacher_name, teacher_birth, teacher_gender, teacher_mail, teacher_phone, hinhanhUrl, this);
    }

    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = {MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }

    public void uploadimgaetoserver()
    {
        if(realpath.equals(""))
        {
            updateInforTeacher(hinhanhUrl); /// Turn to line 214
        }
        else {
            File file = new File(realpath);
            String file_path = file.getAbsolutePath();
            String[] mangtenfile = file_path.split("\\.");

            file_path = mangtenfile[0] + System.currentTimeMillis() + "." + mangtenfile[1];
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);

            MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file", file_path, requestBody);

            DataClient dataClient = APIUtils.getData();
            retrofit2.Call<String> callback = dataClient.Uploadphoto(body);
            callback.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response != null) {
                        String message = response.body();
                        hinhanhUrl = APIUtils.Base_Ur + "image/" + message;
                        updateInforTeacher(hinhanhUrl); // Turn to line 214
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                }
            });
        }
    }
}
