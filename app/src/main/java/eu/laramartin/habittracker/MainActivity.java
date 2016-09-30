package eu.laramartin.habittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

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
    }


}
