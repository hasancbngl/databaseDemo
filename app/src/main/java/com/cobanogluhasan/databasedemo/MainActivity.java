package com.cobanogluhasan.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

              myDatabase.execSQL("CREATE TABLE IF NOT EXISTS theNewUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");
        //     myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)"); //add info to table

        /*    myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Hasan', 28) ");
               myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('djeau', 18) ");
               myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('krax', 15) ");

         */
         myDatabase.execSQL("DELETE FROM theNewUsers WHERE id =2 ");

          Cursor c = myDatabase.rawQuery("SELECT * FROM  theNewUsers",null);

            int nameIndex = c.getColumnIndex("name");                       //LIMIT 1 limits the results
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while (!c.isAfterLast()) {
                Log.i("UserResults-name", c.getString(nameIndex));
                Log.i("UserResults-age", Integer.toString(c.getInt(ageIndex)));
                Log.i("UserResults-id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }





        /*
        try {


            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("Users", MODE_PRIVATE, null);

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, year INT(3))");

            sqLiteDatabase.execSQL("INSERT INTO events (name,year) VALUES('year', 2020)");

            sqLiteDatabase.execSQL("INSERT INTO events (name, year) VALUES ('End of WW2', 1945)");

           Cursor c = myDatabase.rawQuery("SELECT * FROM users  WHERE name='Hasan' AND age<30", null); //WHERE age <25
            Cursor c = myDatabase.rawQuery("SELECT * FROM users  WHERE name LIKE '%e%' LIMIT 1 ", null);//gets everyname starts with H %a% everyname include letter a

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM events WHERE YEAR <2000 ", null);

            int name = cursor.getColumnIndex("name");
            int year = cursor.getColumnIndex("year");

            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {

                Log.i(TAG, "onCreate: event: "+ cursor.getString(name));
                Log.i(TAG, "onCreate: year: "+ Integer.toString(cursor.getInt(year)));

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
*/

    }
}