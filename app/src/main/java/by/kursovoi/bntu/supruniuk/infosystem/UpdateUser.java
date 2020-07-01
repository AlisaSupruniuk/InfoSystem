package by.kursovoi.bntu.supruniuk.infosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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


public class UpdateUser extends AppCompatActivity {

    MaterialEditText email, surname, name, year, apartment, phone, gender;

    int userId;
    Cursor cursor;

    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        email = (MaterialEditText) findViewById(R.id.emailField);
        surname = (MaterialEditText) findViewById(R.id.surnameField);
        name = (MaterialEditText) findViewById(R.id.nameField);
        gender = (MaterialEditText) findViewById(R.id.genderField);
        year = (MaterialEditText) findViewById(R.id.yearField);
        apartment = (MaterialEditText) findViewById(R.id.apartmentField);
        phone = (MaterialEditText) findViewById(R.id.phoneField);

        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);

        dbHelper = new DBHelper(this);
        // подключаемся к базе
        db = dbHelper.getWritableDatabase();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getInt("id");
        }

        if (userId > 0) {
            // получаем элемент по id из бд
            cursor = db.rawQuery("select * from " + DBHelper.TABLE_PEOPLE + " where " +
                    PEOPLE_ID + "=?", new String[]{String.valueOf(userId)});

            cursor.moveToFirst();

            surname.setText(cursor.getString(1));
            name.setText(cursor.getString(2));
            gender.setText(cursor.getString(3));
            year.setText(String.valueOf(cursor.getInt(2)));
            apartment.setText(String.valueOf(cursor.getInt(2)));
            phone.setText(cursor.getString(6));
            email.setText(cursor.getString(7));

            cursor.close();

        } else {
            Toast.makeText(this, "Записи с таким id несуществует", Toast.LENGTH_LONG).show();
            btnUpdate.setVisibility(View.GONE);
        }
    }

    public void cancel(View view){
        goHome();
    }

    public void updateUser(View view){
        String surnameDate = surname.getText().toString();
        String nameDate = name.getText().toString();
        String genderDate = gender.getText().toString();
        int yearDate = Integer.parseInt(year.getText().toString());
        int apartmentDate = Integer.parseInt(apartment.getText().toString());
        String phoneDate = phone.getText().toString();
        String emailDate = email.getText().toString();


        if (!emptyField()){
            return;
        }

        //ContentValues содержит данные которые нужно записать в БД в виде Map
        // которая принимает два параметра ключ, значение с помощью метода put(key, value)
        ContentValues contentValues = new ContentValues();
        contentValues.put(PEOPLE_SURNAME, surnameDate);
        contentValues.put(PEOPLE_NAME, nameDate);
        contentValues.put(PEOPLE_GENDER, genderDate);
        contentValues.put(PEOPLE_YEAR, yearDate);
        contentValues.put(PEOPLE_APARTMENT, apartmentDate);
        contentValues.put(PEOPLE_PHONE, phoneDate);
        contentValues.put(PEOPLE_EMAIL, emailDate);

        //добавляем запись в бд
        db.update(TABLE_PEOPLE,  contentValues, PEOPLE_ID + "=" + String.valueOf(userId), null);
        //закрываем соединени с бд
        db.close();
        Toast.makeText(this, "Данные успешно обновлены.", Toast.LENGTH_SHORT).show();
        goHome();
    }

    private void goHome(){
        // закрываем подключение
        db.close();
        // переход к главной activity
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
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
}
