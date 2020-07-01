package by.kursovoi.bntu.supruniuk.infosystem.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "infosystem.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_PEOPLE = "people";
    public static final String PEOPLE_ID = "_id";
    public static final String PEOPLE_SURNAME = "surname";
    public static final String PEOPLE_NAME = "name";
    public static final String PEOPLE_GENDER = "gender";
    public static final String PEOPLE_YEAR = "year";
    public static final String PEOPLE_APARTMENT = "apartment";
    public static final String PEOPLE_PHONE = "number_phone";
    public static final String PEOPLE_EMAIL = "email";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_PEOPLE + " (" + PEOPLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PEOPLE_SURNAME + " TEXT, " + PEOPLE_NAME + " TEXT, " + PEOPLE_GENDER + " TEXT, " + PEOPLE_YEAR + " INTEGER, " + PEOPLE_APARTMENT + " INTEGER, "
                + PEOPLE_PHONE + " TEXT, " + PEOPLE_EMAIL + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);
        onCreate(db);
    }
}
//
//    public  void addUser(User user){
//
//        //получаем доступ к бд
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        //ContentValues содержит данные которые нужно записать в БД в виде Map
//        // которая принимает два параметра ключ, значение с помощью метода put(key, value)
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(PEOPLE_SURNAME, user.getSurname());
//        contentValues.put(PEOPLE_NAME, user.getName());
//        contentValues.put(PEOPLE_GENDER, user.getGender());
//        contentValues.put(PEOPLE_YEAR, user.getYear());
//        contentValues.put(PEOPLE_APARTMENT, user.getApartment());
//        contentValues.put(PEOPLE_PHONE, user.getPhone());
//        contentValues.put(PEOPLE_EMAIL, user.getEmail());
//
//        //добавляем запись в бд
//        db.insert(TABLE_PEOPLE, null, contentValues);
//        //закрываем соединени с бд
//        db.close();
//    }
//
//    public User getUser(int id){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_PEOPLE, new String[] { PEOPLE_ID, PEOPLE_SURNAME, PEOPLE_NAME, PEOPLE_GENDER, PEOPLE_YEAR, PEOPLE_PHONE, PEOPLE_APARTMENT, PEOPLE_EMAIL }, PEOPLE_ID + "=?",
//                new String[] {String.valueOf(id) }, null, null, null, null);
//
//        if (cursor != null){
//            cursor.moveToFirst();
//        }
//
//        User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
//                cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)),
//                Integer.parseInt(cursor.getString(5)), cursor.getString(6),
//                cursor.getString(7));
//        return user;
//    }
//
//    public List<User> getAllUsers(){
//        List<User> usersList = new ArrayList<User>();
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PEOPLE, null);
//
//        if (cursor.moveToFirst()){
//            do {
//                User user = new User();
//                user.setId(Integer.parseInt(cursor.getString(0)));
//                user.setSurname(cursor.getString(1));
//                user.setName(cursor.getString(2));
//                user.setGender(cursor.getString(3));
//                user.setYear(Integer.parseInt(cursor.getString(4)));
//                user.setApartment(Integer.parseInt(cursor.getString(5)));
//                user.setPhone(cursor.getString(6));
//                user.setEmail(cursor.getString(7));
//            } while (cursor.moveToNext());
//        }
//        return usersList;
//    }
//
//    public void deleteUser(User user){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_PEOPLE, null, null);
//        db.close();
//    }
//
//    public void deleteAllUsers(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_PEOPLE, null, null);
//        db.close();
//    }
//
//    public int updateUser(User user){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(PEOPLE_SURNAME, user.getSurname());
//        contentValues.put(PEOPLE_NAME, user.getName());
//        contentValues.put(PEOPLE_GENDER, user.getGender());
//        contentValues.put(PEOPLE_YEAR, user.getYear());
//        contentValues.put(PEOPLE_APARTMENT, user.getApartment());
//        contentValues.put(PEOPLE_PHONE, user.getPhone());
//        contentValues.put(PEOPLE_EMAIL, user.getEmail());
//
//        return db.update(TABLE_PEOPLE, contentValues, PEOPLE_ID + " =?",
//                new String[] { String.valueOf(user.getId()) });
//    }
//
//    public  int getUsersCount(){
//        // Создаем и открываем для чтения базу данных
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PEOPLE, null);
//        cursor.close();
//
//        return cursor.getCount();
//    }
//}
