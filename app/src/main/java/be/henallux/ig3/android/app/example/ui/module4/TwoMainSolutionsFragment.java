package be.henallux.ig3.android.app.example.ui.module4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.ui.module1.ActivityLifecycleFragment;


public class TwoMainSolutionsFragment extends Fragment {

    public TwoMainSolutionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.mod4_fragment_two_main_solutions, container, false);

        final Button sharedPrefButton = root.findViewById(R.id.shared_preferences_button);
        final Button sqliteButton = root.findViewById(R.id.sqlite_button);
        sharedPrefButton.setOnClickListener(this::goToSharedPref);
        sqliteButton.setOnClickListener(this::goToSQLite);

        return root;
    }


    private void goToSharedPref(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_mod4TwoMainSolutionsFragment_to_mod4SharedPreferences);
    }
    private void goToSQLite(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_mod4TwoMainSolutionsFragment_to_mod4RoomFragment);
    }
}