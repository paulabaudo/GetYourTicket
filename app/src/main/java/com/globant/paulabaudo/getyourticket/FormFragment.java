package com.globant.paulabaudo.getyourticket;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment{

    TextView mTextViewMovie;
    EditText mEditTextName;
    EditText mEditTextPhone;
    EditText mEditTextEmail;
    EditText mEditTextQuantity;
    Boolean[] mStates = { false };

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

        return rootView;
    }

    private void fillFormFromPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditTextName.setText(sharedPreferences.getString(SettingsFragment.USERNAME_PREFERENCE, ""));
        mEditTextPhone.setText(sharedPreferences.getString(SettingsFragment.PHONE_PREFERENCE, ""));
        mEditTextEmail.setText(sharedPreferences.getString(SettingsFragment.EMAIL_PREFERENCE, ""));
    }

    private void wireUpViews(View rootView) {
        mEditTextName = (EditText) rootView.findViewById(R.id.edit_text_name);
        mEditTextPhone = (EditText) rootView.findViewById(R.id.edit_text_phone);
        mEditTextEmail = (EditText) rootView.findViewById(R.id.edit_text_email);
        mEditTextQuantity = (EditText) rootView.findViewById(R.id.edit_text_quantity);
    }

    private void getMovieTitle(View rootView) {
        mTextViewMovie = (TextView) rootView.findViewById(R.id.text_view_movie_name);
        mTextViewMovie.setText(getArguments().getString(Constants.MOVIE));
    }

}
