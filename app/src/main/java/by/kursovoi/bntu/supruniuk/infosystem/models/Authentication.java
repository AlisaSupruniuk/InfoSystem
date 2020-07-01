package by.kursovoi.bntu.supruniuk.infosystem.models;

import android.content.Intent;
import android.widget.Toast;

import by.kursovoi.bntu.supruniuk.infosystem.AdminActivity;

public class Authentication {
    public boolean  validate(String email, String password){
        boolean valid = true;
        if (email.equals("alisa") && password.equals("alisa")){
            valid = true;
        }else {
            valid = false;
        }
        return valid;
    }
}
