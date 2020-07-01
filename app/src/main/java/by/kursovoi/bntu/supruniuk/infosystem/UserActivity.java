package by.kursovoi.bntu.supruniuk.infosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper;
import by.kursovoi.bntu.supruniuk.infosystem.models.User;

public class UserActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dbHelper = new DBHelper(getApplicationContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        //открываем подключение
        db = dbHelper.getReadableDatabase();
        displayInfo();
    }

    public void displayInfo() {
        // Делаем запрос
        Cursor cursor = db.query(
                DBHelper.TABLE_PEOPLE,   // таблица
                null,            // столбцы
                null,                  // столбцы для условия WHERE
                null,                  // значения для условия WHERE
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // порядок сортировки

        TextView tvWorksWindow = (TextView) findViewById(R.id.tvWorksWindow);

        // Проходим через все ряды
        try {
            tvWorksWindow.setText("Таблица содержит " + cursor.getCount() + " жильцов.\n\n");
            tvWorksWindow.append(DBHelper.PEOPLE_ID + " - " +
                    DBHelper.PEOPLE_SURNAME + " - " +
                    DBHelper.PEOPLE_NAME + " - " +
                    DBHelper.PEOPLE_GENDER + " - " +
                    DBHelper.PEOPLE_YEAR + " - " +
                    DBHelper.PEOPLE_APARTMENT + " - " +
                    DBHelper.PEOPLE_PHONE + " - " +
                    DBHelper.PEOPLE_EMAIL + "\n");

            // Узнаем индекс каждого столбца
            int idColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_ID);
            int surnameColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_SURNAME);
            int nameColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_NAME);
            int genderColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_GENDER);
            int yearColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_YEAR);
            int apartmentColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_APARTMENT);
            int phoneColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_PHONE);
            int emailColumnIndex = cursor.getColumnIndex(DBHelper.PEOPLE_EMAIL);

            // Проходим через все ряды
            while (cursor.moveToNext()) {

                // Используем индекс для получения строки или числа
                int currentID = cursor.getInt(idColumnIndex);
                String currentSurname = cursor.getString(surnameColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentGender = cursor.getString(genderColumnIndex);
                int currentYear = cursor.getInt(yearColumnIndex);
                int currentApartment = cursor.getInt(apartmentColumnIndex);
                String currentPhone = cursor.getString(phoneColumnIndex);
                String currentEmail = cursor.getString(emailColumnIndex);

                // Выводим значения каждого столбца
                tvWorksWindow.append(("\n" + currentID + " - " +
                        currentSurname + " - " +
                        currentName + " - " +
                        currentGender + " - " +
                        currentYear + " - " +
                        currentApartment + " - " +
                        currentPhone + " - " +
                        currentEmail));

            }
        } finally {
            // Всегда закрываем курсор после чтения
            cursor.close();
        }
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //закдваем подключение и курсор
        db.close();
        cursor.close();
    }
}