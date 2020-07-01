package by.kursovoi.bntu.supruniuk.infosystem;

import androidx.appcompat.app.AppCompatActivity;

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

public class DeleteUser extends AppCompatActivity {

    EditText etId;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
    }

    public void delete(View view) {

        etId = (EditText) findViewById(R.id.etIdUserForDelete);

        if (TextUtils.isEmpty(etId.getText().toString())){
            Toast.makeText(this, "Введите id для дальнейших действий", Toast.LENGTH_SHORT).show();
            return;
        }
        Cursor cursor;
        int id = Integer.parseInt(etId.getText().toString());
        if (id > 0) {
            // получаем элемент по id из бд
            cursor = db.rawQuery("select * from " + TABLE_PEOPLE + " where " +
                    PEOPLE_ID + "=?", new String[]{String.valueOf(id)});
            cursor.moveToFirst();
            //nameBox.setText(userCursor.getString(1));
            //yearBox.setText(String.valueOf(userCursor.getInt(2)));

            db.delete(TABLE_PEOPLE, "_id = ?", new String[]{String.valueOf(id)});
            cursor.close();
            return;
        }

    }

    public  void back(View view){

        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);

    }
}
