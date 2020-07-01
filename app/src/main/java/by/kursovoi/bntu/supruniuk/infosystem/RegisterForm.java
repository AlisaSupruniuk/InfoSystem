package by.kursovoi.bntu.supruniuk.infosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper;

import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_APARTMENT;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_EMAIL;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_GENDER;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_NAME;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_PHONE;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_SURNAME;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_YEAR;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.TABLE_PEOPLE;

public class RegisterForm extends AppCompatActivity {

    MaterialEditText email, surname, name, year, apartment, phone, gender;

    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        email = (MaterialEditText) findViewById(R.id.emailField);
        surname = (MaterialEditText) findViewById(R.id.surnameField);
        name = (MaterialEditText) findViewById(R.id.nameField);
        gender = (MaterialEditText) findViewById(R.id.genderField);
        year = (MaterialEditText) findViewById(R.id.yearField);
        apartment = (MaterialEditText) findViewById(R.id.apartmentField);
        phone = (MaterialEditText) findViewById(R.id.phoneField);

        dbHelper = new DBHelper(this);
        // подключаемся к базе
        db = dbHelper.getWritableDatabase();

    }

    public void cancel(View view) {
        goHome();
    }

    public void createUser(View view) {

        if (!emptyField()){
            return;
        }

        //ContentValues содержит данные которые нужно записать в БД в виде Map
        // которая принимает два параметра ключ, значение с помощью метода put(key, value)
        String surnameDate = surname.getText().toString();
        String nameDate = name.getText().toString();
        String genderDate = gender.getText().toString();
        int yearDate = Integer.parseInt(year.getText().toString());
        int apartmentDate = Integer.parseInt(apartment.getText().toString());
        String phoneDate = phone.getText().toString();
        String emailDate = email.getText().toString();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PEOPLE_SURNAME, surnameDate);
        contentValues.put(PEOPLE_NAME, nameDate);
        contentValues.put(PEOPLE_GENDER, genderDate);
        contentValues.put(PEOPLE_YEAR, yearDate);
        contentValues.put(PEOPLE_APARTMENT, apartmentDate);
        contentValues.put(PEOPLE_PHONE, phoneDate);
        contentValues.put(PEOPLE_EMAIL, emailDate);

        //добавляем запись в бд
        db.insert(TABLE_PEOPLE, null, contentValues);
        //закрываем соединени с бд
        db.close();
        Toast.makeText(this, "Новый житель успешно добавлен.", Toast.LENGTH_SHORT).show();

        goHome();
    }

    private boolean emptyField() {
        DataValidation dv = new DataValidation();
        boolean valid = true;
        if (!dv.emptyFieldSurname(surname.getText().toString())) {
            surname.setError("Заполните поле.");
            valid = false;
        }

        if (!dv.emptyFieldName(name.getText().toString())) {
            name.setError("Заполните поле.");
            valid = false;
        }

        if (!dv.emptyFieldGender(gender.getText().toString())) {
            gender.setError("Заполните поле.");
            valid = false;
        }

        if (!dv.emptyFieldYear(year.getText().toString())){
            year.setError("Заполните поле.");
            valid = false;
        }

        if (!dv.emptyFieldApartment(apartment.getText().toString())) {
            apartment.setError("Заполните поле.");
            valid = false;
        }

        if (!dv.emptyFieldPhone(phone.getText().toString())) {
            phone.setError("Заполните поле.");
            valid = false;
        }

        if (!dv.emptyFieldEmail(email.getText().toString())) {
            email.setError("Заполните поле.");
            valid = false;
        }
        return valid;
    }

    private void goHome(){
        // закрываем подключение
        db.close();
        // переход к главной activity
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}