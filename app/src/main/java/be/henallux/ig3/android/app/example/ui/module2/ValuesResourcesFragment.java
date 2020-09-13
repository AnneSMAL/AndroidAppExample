package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import be.henallux.ig3.android.app.example.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ValuesResourcesFragment extends Fragment {

    public ValuesResourcesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.mod2_fragment_values_resources, container, false);
    }
}
