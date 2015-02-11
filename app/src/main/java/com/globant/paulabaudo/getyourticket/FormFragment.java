package com.globant.paulabaudo.getyourticket;


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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    TextView mTextViewMovie;
    EditText mEditTextName;
    EditText mEditTextPhone;
    EditText mEditTextEmail;
    EditText mEditTextQuantity;
    Button mButtonBookTikets;
    Spinner mSpinnerTime;
    Boolean[] mStates = { true, true, false, false, false, false };
    String mStringTimeSelected;

    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_form, container, false);
        getMovieTitle(rootView);
        wireUpViews(rootView);
        fillFormFromPreferences();

        mSpinnerTime = (Spinner) rootView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.movies_schedule_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerTime.setAdapter(adapter);
        mSpinnerTime.setOnItemSelectedListener(this);

        return rootView;
    }

    private void fillFormFromPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditTextName.setText(sharedPreferences.getString(SettingsFragment.USERNAME_PREFERENCE, ""));
        mEditTextPhone.setText(sharedPreferences.getString(SettingsFragment.PHONE_PREFERENCE, ""));
        mEditTextEmail.setText(sharedPreferences.getString(SettingsFragment.EMAIL_PREFERENCE, ""));
    }

    private void wireUpViews(View rootView) {
        mEditTextQuantity = (EditText) rootView.findViewById(R.id.edit_text_quantity); // mStates[2]
        mEditTextName = (EditText) rootView.findViewById(R.id.edit_text_name); // mStates[3]
        mEditTextPhone = (EditText) rootView.findViewById(R.id.edit_text_phone); // mStates[4]
        mEditTextEmail = (EditText) rootView.findViewById(R.id.edit_text_email); // mStates[5]
        mButtonBookTikets = (Button) rootView.findViewById(R.id.button_book);
        setTextWatchers();
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
