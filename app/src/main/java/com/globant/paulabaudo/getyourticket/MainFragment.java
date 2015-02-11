package com.globant.paulabaudo.getyourticket;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ListView mListViewMovies;
    final String[] mMovies = new String[] { MovieConstants.MOVIE_PIRATES,
            MovieConstants.MOVIE_HOBBIT  ,
            MovieConstants.MOVIE_ERAGON,
            MovieConstants.MOVIE_AVENGERS,
            MovieConstants.MOVIE_THOR,
            MovieConstants.MOVIE_IRON,
            MovieConstants.MOVIE_TRANSFORMERS,
            MovieConstants.MOVIE_INCEPTION,
            MovieConstants.MOVIE_PRINCE,
            MovieConstants.MOVIE_AVATAR
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
                switch (mMovies[position]){
                    case MovieConstants.MOVIE_PIRATES:
                        getFragmentManager().beginTransaction().replace(R.id.container, new PiratesFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_HOBBIT:
                        getFragmentManager().beginTransaction().replace(R.id.container, new HobbitFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_AVATAR:
                        getFragmentManager().beginTransaction().replace(R.id.container, new AvatarFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_AVENGERS:
                        getFragmentManager().beginTransaction().replace(R.id.container, new AvengersFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_ERAGON:
                        getFragmentManager().beginTransaction().replace(R.id.container, new EragonFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_INCEPTION:
                        getFragmentManager().beginTransaction().replace(R.id.container, new InceptionFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_IRON:
                        getFragmentManager().beginTransaction().replace(R.id.container, new IronFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_PRINCE:
                        getFragmentManager().beginTransaction().replace(R.id.container, new PrinceFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_THOR:
                        getFragmentManager().beginTransaction().replace(R.id.container, new ThorFragment()).
                                addToBackStack(null).commit();
                        break;
                    case MovieConstants.MOVIE_TRANSFORMERS:
                        getFragmentManager().beginTransaction().replace(R.id.container, new TransformersFragment()).
                                addToBackStack(null).commit();
                        break;
                }
            }
        });
    }

}
