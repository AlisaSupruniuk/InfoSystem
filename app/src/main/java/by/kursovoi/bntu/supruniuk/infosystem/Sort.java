package by.kursovoi.bntu.supruniuk.infosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper;


public class Sort extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rgSort;
    TextView tvSortWindow;
    Button btnSort;

    DBHelper dbHelper;
    SQLiteDatabase db;

    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        btnSort = (Button) findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);

        rgSort = (RadioGroup) findViewById(R.id.rgSort);

        dbHelper = new DBHelper(getApplicationContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = dbHelper.getReadableDatabase();
    }

    public  void  onClick(View view){

        String orderBy=null;

        switch (rgSort.getCheckedRadioButtonId()) {
            case R.id.rSurname:
                orderBy = "surname";
                break;
            case R.id.rYear:
                orderBy = "year";
                break;
            case R.id.rApartment:
                orderBy = "apartment";
                break;
        }

        // Делаем запрос
        cursor = db.query(
                DBHelper.TABLE_PEOPLE,   // таблица
                null,            // столбцы
                null,                  // столбцы для условия WHERE
                null,                  // значения для условия WHERE
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                orderBy);                   // порядок сортировки

        tvSortWindow = (TextView) findViewById(R.id.tvSortWindow);

        // Проходим через все ряды
        try {
            tvSortWindow.setText("Результат сортировки: \n\n");
            tvSortWindow.append(DBHelper.PEOPLE_ID + " - " +
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
                tvSortWindow.append(("\n" + currentID + " - " +
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
    public void  cancel(View view){
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }


}
