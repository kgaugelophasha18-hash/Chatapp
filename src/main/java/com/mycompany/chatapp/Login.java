/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

    

/**
 *
 * @author Student
 */
public class Login {
    
    private String Name;
    private String LastName;
    private String Username;
    private String Password;
    private String CellPhoneNumber;

    public Login(String Name, String LastName, String Username,String Password, String CellPhoneNumber){
        this.Name = Name;
        this.LastName = LastName;
        this.Username = Username;
        this.Password = Password;
        this.CellPhoneNumber = CellPhoneNumber;
    }
    public boolean checkUserName(){
        if (Username.contains("_") && Username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity() {
        String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specials = "!@#$%^&*()_-+=<>?/[]{}.,;:'\"\\|~`";

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < Password.length(); i++) {

            String letter = Password.substring(i, i + 1);

            if (capitals.contains(letter)) {
                hasCapital = true;
            }
            if (numbers.contains(letter)) {
                hasNumber = true;
            }
            if (specials.contains(letter)) {
                hasSpecial = true;
            }
        }

        if (Password.length() >= 8 && hasCapital && hasNumber && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCellPhoneNumber() {
        return CellPhoneNumber.matches("\\+27[0-9]{9}");
    }

    public String registerUser() {

        if (checkUserName() == false) {
            return "Username is not correctly formatted; please ensure that your "
                 + "username contains an underscore and is no more than five "
                 + "characters in length.";
        }

        if (checkPasswordComplexity() == false) {
            return "Password is not correctly formatted; please ensure that the "
                 + "password contains at least eight characters, a capital letter, "
                 + "a number, and a special character.";
        }

        if (checkCellPhoneNumber() == false) {
            return "Cell number is incorrectly formatted or does not contain an "
                 + "international code; please correct the number and try again.";
        }

        return "Welcome " + Name + " " + LastName + " it is great to see you again.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (Username.equals(enteredUsername) && Password.equals(enteredPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful == true) {
            return "Welcome " + Name + " " + LastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
