package be.henallux.ig3.android.app.example.ui.module1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.henallux.ig3.android.app.example.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WhatIsAnActivityFragment extends Fragment {

    public WhatIsAnActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_what_is_an_activity, container, false);
    }
}
