package by.kursovoi.bntu.supruniuk.infosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper;

import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_APARTMENT;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_EMAIL;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_GENDER;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_ID;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_NAME;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_PHONE;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_SURNAME;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_YEAR;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.TABLE_PEOPLE;

public class AdminActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        dbHelper = new DBHelper(this);
        // подключаемся к базе
        db = dbHelper.getReadableDatabase();
    }

    public void allUsers(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    public void addUser(View view) {
        Intent intent = new Intent(this, RegisterForm.class);
        startActivity(intent);
    }

    public void update(View view) {
        Intent intent = new Intent(this, UpdateForm.class);
        startActivity(intent);
    }

    public void deleteAllUser(View view) {
        db.delete(TABLE_PEOPLE, null, null);
        Toast.makeText(this, "Список жильцов успешно очищен.", Toast.LENGTH_LONG).show();
    }

    public void deleteUser(View view) {
        Intent intent = new Intent(this, DeleteUser.class);
        startActivity(intent);
    }

    public void setBtnSort(View view) {
        Intent intent = new Intent(this, Sort.class);
        startActivity(intent);
    }

}
