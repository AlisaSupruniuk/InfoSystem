package by.kursovoi.bntu.supruniuk.infosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper;

import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.PEOPLE_ID;
import static by.kursovoi.bntu.supruniuk.infosystem.models.DBHelper.TABLE_PEOPLE;

public class UpdateForm extends AppCompatActivity {

    EditText etId;
    DBHelper dbHelper;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_form);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    public void update(View view) {

        etId = (EditText) findViewById(R.id.etIdUserForDelete);

        if (TextUtils.isEmpty(etId.getText().toString())) {
            Toast.makeText(this, "Введите id для дальнейших действий", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, UpdateUser.class);
        intent.putExtra("id", Integer.parseInt(etId.getText().toString()));
        startActivity(intent);

    }

    public void back(View view) {

        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);

    }
}
