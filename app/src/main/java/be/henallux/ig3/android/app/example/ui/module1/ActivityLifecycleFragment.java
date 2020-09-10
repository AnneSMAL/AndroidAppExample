package be.henallux.ig3.android.app.example.ui.module1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityLifecycleFragment extends Fragment {

    public ActivityLifecycleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_activity_lifecycle, container, false);

        final Button goToLifecycleTestingActivityButton = root.findViewById(R.id.activity_lifecycle_go_to_testing_button);
        final Button nextButton = root.findViewById(R.id.activity_lifecycle_next_button);

        goToLifecycleTestingActivityButton.setOnClickListener(view -> goToLifecycleTestingActivity());
        //nextButton.setOnClickListener(this::goToNextFragment);

        return root;
    }

    private void goToLifecycleTestingActivity() {
        Intent intent = new Intent(getContext(), LifecycleTestingActivity.class);
        startActivity(intent);
    }

    /**
     * Navigates to the next screen. Do you know which one it will be ? Go to the
     * mobile_navigation.xml file to find it
     *
     * @param view View element calling the method
     */
    private void goToNextFragment(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_WhatIsAFragmentFragment_to_ActivityLifecycleFragment);
    }
}
