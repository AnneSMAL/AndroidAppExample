package be.henallux.ig3.android.app.example.ui.module5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;

public class WhatIsRetrofitFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.mod5_fragment_what_is_retrofit, container, false);

        Button nextButton = root.findViewById(R.id.what_is_retrofit_next_button);
        nextButton.setOnClickListener(view -> Navigation.findNavController(view)
                .navigate(R.id.action_whatIsRetrofitFragment_to_retrofitExampleFragment));
        return root;
    }
}
