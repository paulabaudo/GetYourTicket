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
public class EragonFragment extends Fragment {

    private Button mButtonGetTickets;

    public EragonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_eragon, container, false);
        prepareGetTicketsButton(rootView);
        return rootView;
    }

    private void prepareGetTicketsButton(View rootView) {
        mButtonGetTickets = (Button) rootView.findViewById(R.id.button_get_tickets_eragon);
        mButtonGetTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormFragment form = new FormFragment();
                Bundle arguments = new Bundle();
                arguments.putString(MovieConstants.MOVIE, MovieConstants.MOVIE_ERAGON);
                form.setArguments(arguments);
                getFragmentManager().beginTransaction().replace(R.id.container, form).
                        addToBackStack(null).commit();
            }
        });
    }


}
