package com.globant.paulabaudo.getyourticket;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    final static Integer REQUEST_CODE = 0;
    TextView mTextViewMovie;
    EditText mEditTextName;
    EditText mEditTextPhone;
    EditText mEditTextEmail;
    EditText mEditTextQuantity;
    Button mButtonBookTikets;
    Spinner mSpinnerTime;
    Boolean[] mStates = { false, true, false, false, false, false };
    String mStringTimeSelected;
    Button mButtonDatePicker;
    TextView mTextViewDate;

    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_form, container, false);
        getMovieTitle(rootView);
        wireUpViews(rootView);
        setTextWatchers();
        fillFormFromPreferences();
        prepareSpinner();

        mButtonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SelectDateActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                mTextViewDate.setText(data.getStringExtra(SelectDateActivity.PlaceholderFragment.MOVIE_DATE));
                mStates[0]=true;
            }
        }
    }

    private void prepareSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.movies_schedule_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerTime.setAdapter(adapter);
        mSpinnerTime.setOnItemSelectedListener(this);
    }

    private void fillFormFromPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditTextName.setText(sharedPreferences.getString(SettingsFragment.USERNAME_PREFERENCE, ""));
        mEditTextPhone.setText(sharedPreferences.getString(SettingsFragment.PHONE_PREFERENCE, ""));
        mEditTextEmail.setText(sharedPreferences.getString(SettingsFragment.EMAIL_PREFERENCE, ""));
    }

    private void wireUpViews(View rootView) {
        mTextViewDate = (TextView) rootView.findViewById(R.id.text_view_date_selected); // mStates[0]
        mEditTextQuantity = (EditText) rootView.findViewById(R.id.edit_text_quantity); // mStates[2]
        mEditTextName = (EditText) rootView.findViewById(R.id.edit_text_name); // mStates[3]
        mEditTextPhone = (EditText) rootView.findViewById(R.id.edit_text_phone); // mStates[4]
        mEditTextEmail = (EditText) rootView.findViewById(R.id.edit_text_email); // mStates[5]
        mButtonBookTikets = (Button) rootView.findViewById(R.id.button_book);
        mSpinnerTime = (Spinner) rootView.findViewById(R.id.spinner);
        mButtonDatePicker = (Button) rootView.findViewById(R.id.button_date_picker);
    }

    private void setTextWatchers() {
        mEditTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mStates[3] = (!TextUtils.isEmpty(s.toString()));
                mButtonBookTikets.setEnabled(formIsComplete());
            }
        });
        mEditTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mStates[4] = (!TextUtils.isEmpty(s.toString()));
                mButtonBookTikets.setEnabled(formIsComplete());
            }
        });
        mEditTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mStates[5] = (!TextUtils.isEmpty(s.toString()));
                mButtonBookTikets.setEnabled(formIsComplete());
            }
        });
        mEditTextQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mStates[2] = (!TextUtils.isEmpty(s.toString()));
                mButtonBookTikets.setEnabled(formIsComplete());
            }
        });
    }

    private void getMovieTitle(View rootView) {
        mTextViewMovie = (TextView) rootView.findViewById(R.id.text_view_movie_name);
        mTextViewMovie.setText(getArguments().getString(Constants.MOVIE));
    }

    private Boolean formIsComplete(){
        int i = 0;

        while (i<mStates.length && mStates[i]){
            i++;
        }
        return (i==mStates.length);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mStringTimeSelected = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
