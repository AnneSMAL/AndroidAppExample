package be.henallux.ig3.android.app.example.ui.module4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import be.henallux.ig3.android.app.example.R;

public class RoomFragment extends Fragment {

    public RoomFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mod4_fragment_room, container, false);


        final Button goToViewModelButton = root.findViewById(R.id.go_to_view_model_button);
        final Button nextButton = root.findViewById(R.id.room_next_button);

        goToViewModelButton.setOnClickListener(this::goToViewModel);
        nextButton.setOnClickListener(this::goToNext);


        return root;
    }

    private void goToNext(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_mod4RoomFragment_to_mod4WhatIsARecyclerViewFragment);
    }
    private void goToViewModel(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_mod4RoomFragment_to_mod3PresentationFragment);
    }
}