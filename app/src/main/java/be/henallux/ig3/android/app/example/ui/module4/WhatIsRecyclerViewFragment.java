package be.henallux.ig3.android.app.example.ui.module4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import be.henallux.ig3.android.app.example.R;


public class WhatIsRecyclerViewFragment extends Fragment {


    public WhatIsRecyclerViewFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mod4_fragment_what_is_recycler_view, container, false);

        final Button nextButton = root.findViewById(R.id.recycler_view_next_button);
        nextButton.setOnClickListener(this::goToNext);

        return root;
    }

    private void goToNext(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_mod4WhatIsARecyclerViewFragment_to_mod4RecyclerViewFragment);
    }
}