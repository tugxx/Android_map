package com.example.myapplication.Ultils;

import com.google.firebase.auth.PhoneAuthCredential;

public class OTPCode {
    private static String otp_code;
    private static String phoneNumber;
    private static String sms_code;

    public static String getSms_code() {
        return sms_code;
    }

    public static void setSms_code(String sms_code) {
        OTPCode.sms_code = sms_code;
    }

    public static String getOtp_code() {
        return otp_code;
    }

    public static void setOtp_code(String otp_code) {
        OTPCode.otp_code = otp_code;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        OTPCode.phoneNumber = phoneNumber;
    }
}
