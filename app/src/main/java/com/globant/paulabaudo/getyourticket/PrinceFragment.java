package com.globant.paulabaudo.getyourticket;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrinceFragment extends Fragment {

    private Button mButtonGetTickets;

    public PrinceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prince, container, false);
        prepareGetTicketsButton(rootView);
        return rootView;
    }

    private void prepareGetTicketsButton(View rootView) {
        mButtonGetTickets = (Button) rootView.findViewById(R.id.button_get_tickets_prince);
        mButtonGetTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormFragment form = new FormFragment();
                Bundle arguments = new Bundle();
                arguments.putString(Constants.MOVIE, Constants.MOVIE_PRINCE);
                form.setArguments(arguments);
                getFragmentManager().beginTransaction().replace(R.id.container, form).
                        addToBackStack(Constants.FORM_FRAGMENT).commit();
            }
        });
    }
}
