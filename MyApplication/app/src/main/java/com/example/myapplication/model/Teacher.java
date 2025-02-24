package com.example.myapplication.model;

public class Teacher {
    private String teacher_id;
    private String teacher_name;
    private String teacher_birth;
    private String teacher_gender;
    private String teacher_mail;
    private String teacher_phone;
    private String teacher_image;
    private int status;

    public Teacher(String teacher_id, String teacher_name, String teacher_birth, String teacher_gender, String teacher_mail, String teacher_phone, String teacher_image, int status) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_birth = teacher_birth;
        this.teacher_gender = teacher_gender;
        this.teacher_mail = teacher_mail;
        this.teacher_phone = teacher_phone;
        this.teacher_image = teacher_image;
        this.status = status;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_birth() {
        return teacher_birth;
    }

    public void setTeacher_birth(String teacher_birth) {
        this.teacher_birth = teacher_birth;
    }

    public String getTeacher_gender() {
        return teacher_gender;
    }

    public void setTeacher_gender(String teacher_gender) {
        this.teacher_gender = teacher_gender;
    }

    public String getTeacher_mail() {
        return teacher_mail;
    }

    public void setTeacher_mail(String teacher_mail) {
        this.teacher_mail = teacher_mail;
    }

    public String getTeacher_phone() {
        return teacher_phone;
    }

    public void setTeacher_phone(String teacher_phone) {
        this.teacher_phone = teacher_phone;
    }

    public String getTeacher_image() {
        return teacher_image;
    }

    public void setTeacher_image(String teacher_image) {
        this.teacher_image = teacher_image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
