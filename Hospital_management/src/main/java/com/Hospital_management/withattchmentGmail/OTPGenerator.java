package com.Hospital_management.withattchmentGmail;

import java.util.Random;

public class OTPGenerator {
    public static void main(String[] args) {
        int otpLength = 6;
        String otp = generateOTP(otpLength);
        System.out.println("Your OTP is: " + otp);
    }
    
    private static String generateOTP(int otpLength) {
        Random random = new Random();
        StringBuilder otp = new StringBuilder(otpLength);
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
