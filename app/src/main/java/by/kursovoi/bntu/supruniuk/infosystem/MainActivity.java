package by.kursovoi.bntu.supruniuk.infosystem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import by.kursovoi.bntu.supruniuk.infosystem.models.Authentication;


public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Authentication auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        auth = new Authentication();
    }

    public void signIn(View view){
        if(!auth.validate(etEmail.getText().toString(), etPassword.getText().toString())){
            Toast.makeText(this, "Неверный логин/пароль.", Toast.LENGTH_LONG).show();
            return;
        }else {
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
        }
    }



}

