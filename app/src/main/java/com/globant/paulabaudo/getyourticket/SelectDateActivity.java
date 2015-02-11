package com.globant.paulabaudo.getyourticket;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.CalendarView;


public class SelectDateActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_date, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        final static String MOVIE_DATE = "MOVIE_DATE";
        CalendarView mCalendarViewSelectDate;
        String mDateSelected;
        Button mButtonSelect;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_select_date, container, false);
            mCalendarViewSelectDate = (CalendarView) rootView.findViewById(R.id.calendar_view_movie_day);
            mButtonSelect = (Button) rootView.findViewById(R.id.button_select);
            prepareCalendarView();
            mButtonSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity activity = getActivity();
                    Intent intent = new Intent();
                    intent.putExtra(MOVIE_DATE,mDateSelected);
                    activity.setResult(Activity.RESULT_OK,intent);
                    activity.finish();
                }
            });
            return rootView;
        }

        private void prepareCalendarView() {
            mCalendarViewSelectDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    mDateSelected = getDate(year, (month+1), dayOfMonth);
                }

                private String getDate(int year, int month, int dayOfMonth) {
                    String date = Integer.toString(month)+"/"+Integer.toString(dayOfMonth)+"/"+Integer.toString(year);
                    return date;
                }
            });
        }
    }
}
