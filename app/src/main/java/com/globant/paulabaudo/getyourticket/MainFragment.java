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
    final String[] mMovies = new String[] { Constants.MOVIE_PIRATES,
            Constants.MOVIE_HOBBIT  ,
            Constants.MOVIE_ERAGON,
            Constants.MOVIE_AVENGERS,
            Constants.MOVIE_THOR,
            Constants.MOVIE_IRON,
            Constants.MOVIE_TRANSFORMERS,
            Constants.MOVIE_INCEPTION,
            Constants.MOVIE_PRINCE,
            Constants.MOVIE_AVATAR
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
                    case Constants.MOVIE_PIRATES:
                        getFragmentManager().beginTransaction().replace(R.id.container, new PiratesFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_HOBBIT:
                        getFragmentManager().beginTransaction().replace(R.id.container, new HobbitFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_AVATAR:
                        getFragmentManager().beginTransaction().replace(R.id.container, new AvatarFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_AVENGERS:
                        getFragmentManager().beginTransaction().replace(R.id.container, new AvengersFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_ERAGON:
                        getFragmentManager().beginTransaction().replace(R.id.container, new EragonFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_INCEPTION:
                        getFragmentManager().beginTransaction().replace(R.id.container, new InceptionFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_IRON:
                        getFragmentManager().beginTransaction().replace(R.id.container, new IronFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_PRINCE:
                        getFragmentManager().beginTransaction().replace(R.id.container, new PrinceFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_THOR:
                        getFragmentManager().beginTransaction().replace(R.id.container, new ThorFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                    case Constants.MOVIE_TRANSFORMERS:
                        getFragmentManager().beginTransaction().replace(R.id.container, new TransformersFragment()).
                                addToBackStack(Constants.MOVIE_FRAGMENT).commit();
                        break;
                }
            }
        });
    }

}
