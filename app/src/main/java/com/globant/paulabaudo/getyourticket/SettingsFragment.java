package com.globant.paulabaudo.getyourticket;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class SettingsFragment extends PreferenceFragment {

    public final static String USERNAME_PREFERENCE = "username_preference";
    public final static String EMAIL_PREFERENCE = "email_preference";
    public final static String PHONE_PREFERENCE = "phone_preference";

    public SettingsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
