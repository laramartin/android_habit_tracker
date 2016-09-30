package eu.laramartin.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);

        habitDbHelper.insertHabit(dateInt, HabitContract.HabitEntry.HABIT_PROGRAMMING,
                "SQLite in Android");
        habitDbHelper.insertHabit(dateInt, HabitContract.HabitEntry.HABIT_UDACITY,
                "Working on a project");
        Cursor cursor = habitDbHelper.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) + " " + cursor.getString(3));
        }
    }


}
