/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Chatapp {

    public static void main(String[] args) {
    

        Scanner input = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");

        System.out.print("What is your name: ");
        String Name = input.nextLine();

        System.out.print(" What is your last name: ");
        String LastName = input.nextLine();

        System.out.print("Enter your username (must contain _ and be 5 characters or less): ");
        String Username = input.nextLine();

        System.out.print("Enter your password (8+ characters, a capital, a number, a special character): ");
        String Password = input.nextLine();

        System.out.print("Enter your cell phone number (example +27800968386): ");
        String CellPhone = input.nextLine();

        
        Login user = new Login(Name, LastName, Username, Password, CellPhone);

        
        if (user.checkUserName() == true) {
            System.out.println("Username successfully captured.");
        }
        if (user.checkPasswordComplexity() == true) {
            System.out.println("Password successfully captured.");
        }
        if (user.checkCellPhoneNumber() == true) {
            System.out.println("Cell phone number successfully added.");
        }

        
        System.out.println(user.registerUser());

       
        System.out.println("");
        System.out.println("=== LOGIN ===");

        System.out.print("Username: ");
        String loginUsername = input.nextLine();

        System.out.print("Password: ");
        String loginPassword = input.nextLine();

        boolean loggedIn = user.loginUser(loginUsername, loginPassword);
        System.out.println(user.returnLoginStatus(loggedIn));
    }
}
    

