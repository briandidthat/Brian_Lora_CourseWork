package com.trilogyed.gamestore.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordUtility {
    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String staffPassword = "password";
        String managerPassword = "password1";
        String adminPassword = "password2";

        String encodedStaff = enc.encode(staffPassword);
        String encodedManager = enc.encode(managerPassword);
        String encodedAdmin = enc.encode(adminPassword);


        System.out.println("Staff: " + encodedStaff);
        System.out.println("Manager: " + encodedManager);
        System.out.println("Admin: " + encodedAdmin);
    }

}
