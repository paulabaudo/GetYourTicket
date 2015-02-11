package com.globant.paulabaudo.getyourticket;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends Fragment {

    public final static String CONFIRMATION_SUMMARY = "confirmation_summary";
    TextView mTextViewMessageSummary;

    public ConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_confirmation, container, false);
        prepareTextView(rootView);
        return rootView;
    }

    private void prepareTextView(View rootView) {
        mTextViewMessageSummary = (TextView) rootView.findViewById(R.id.text_view_message_summary);
        mTextViewMessageSummary.setText(getArguments().getString(CONFIRMATION_SUMMARY));
    }

}
