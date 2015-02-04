package com.globant.paulabaudo.getyourticket;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ListView mListViewMovies;
    final String[] mMovies = new String[] { "Pirates of the Caribbean",
            "The Hobbit",
            "Eragon",
            "The Avengers",
            "Thor",
            "Iron Man 2",
            "Transformers",
            "Inception",
            "Prince of Persia",
            "Avatar"
    };

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        prepareListViewMovie(rootView);
        return rootView;
    }

    private void prepareListViewMovie(View v) {
        mListViewMovies = (ListView) v.findViewById(R.id.list_view_movies);

        ArrayAdapter adapter = new ArrayAdapter(v.getContext(),android.R.layout.simple_list_item_1, mMovies);
        mListViewMovies.setAdapter(adapter);

        mListViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        getFragmentManager().beginTransaction().replace(R.id.container, new PiratesFragment()).commit();
                        break;
                    default:
                        Toast.makeText(view.getContext(),mMovies[position],Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

}
