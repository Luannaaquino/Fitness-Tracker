package co.tiagoaguiar.codelab.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SqlHelper  extends SQLiteOpenHelper {

    private static final String DB_NAME = "fitness_tracker.db";
    private static int DB_VERSION = 1;
    private static SqlHelper INSTANCE;

    static SqlHelper getInstance(Context context){
        if(INSTANCE == null)
            INSTANCE = new SqlHelper(context);
        return INSTANCE;
    }

    private SqlHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE calc(id INTEGER primary key, type_calc TEXT, res DECIMAL, create_date DATETIME)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("Teste", "on Upgrade disparado");
    }

    long addItem(String type, double response){
        SQLiteDatabase db = getWritableDatabase();

        long calId = 0;
        try{
            db.beginTransaction();

            ContentValues values = new ContentValues();
            values.put("type_calc", type);
            values.put("res", response);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("pt", "BR"));
            String now = sdf.format(new Date());
            values.put("create_date", now);

           calId =  db.insertOrThrow("calc", null, values);

            db.setTransactionSuccessful();

        }catch (Exception e) {
            Log.e("SQLITE", e.getMessage(), e);
        } finally {
            if(db.isOpen())
                db.endTransaction();
        }
        return calId;
    }
}
