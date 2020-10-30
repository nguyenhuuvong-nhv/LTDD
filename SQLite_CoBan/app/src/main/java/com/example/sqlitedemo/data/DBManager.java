package com.example.sqlitedemo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sqlitedemo.model.Student;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DBManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="student_manager";
    private static final String TABLE_NAME="students";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String ADDRESS="address";
    private static final String PHONE_NUMBER="phone";
    private static final String EMAIL="email";
    private static final int VERSION=1;

//    String SQLQuery = "CREATE TABLE "+TABLE_NAME +" (" +
//            ID +" integer primary key, "+
//            NAME + " TEXT, "+
//            EMAIL +" TEXT, "+
//            PHONE_NUMBER+" TEXT," +
//            ADDRESS +" TEXT)";

    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key, "+
                NAME + " TEXT, "+
                EMAIL +" TEXT, "+
                PHONE_NUMBER+" TEXT," +
                ADDRESS +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(NAME,student.getmName());
        values.put(ADDRESS,student.getmAddress());
        values.put(PHONE_NUMBER,student.getmPhoneNumber());
        values.put(EMAIL,student.getmEmail());

        db.insert(TABLE_NAME,null,values);
        db.close();

    }
    public List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<Student>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setmID(cursor.getInt(0));
                student.setmName(cursor.getString(1));
                student.setmEmail(cursor.getString(2));
                student.setmPhoneNumber(cursor.getString(3));
                student.setmAddress(cursor.getString(4));
                listStudent.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listStudent;
    }
    public int updateStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,student.getmName());
        contentValues.put(ADDRESS,student.getmAddress());
        contentValues.put(EMAIL,student.getmEmail());
        contentValues.put(PHONE_NUMBER,student.getmPhoneNumber());
        return db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(student.getmID())});
    }
    public int deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[] {String.valueOf(id)});
    }

}
