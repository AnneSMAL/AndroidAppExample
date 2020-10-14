package be.henallux.ig3.android.app.example.ui.module4;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.navigation.Navigation;
import be.henallux.ig3.android.app.example.R;

public class SharedPreferencesFragment extends Fragment {
    EditText preferredValue;
    SharedPreferences sharedPref;

    public SharedPreferencesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("LongLogTag")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.mod4_fragment_shared_preferences, container, false);

        preferredValue = root.findViewById(R.id.preferred_value_edit_text);
        // get preferences
        sharedPref = this.getActivity().getPreferences(getContext().MODE_PRIVATE);

        int value = sharedPref.getInt(getString(R.string.module_4_preferred_value), 42);
        preferredValue.setText(Integer.toString(value));


        final Button saveButton = root.findViewById(R.id.shared_preferences_write_button);
        final Button displayButton = root.findViewById(R.id.shared_preferences_read_button);

        saveButton.setOnClickListener(this::savePreferredValue);
        displayButton.setOnClickListener(this::displayPreferredValue);


        return root;
    }

    private void savePreferredValue(View view) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.module_4_preferred_value), Integer.valueOf(preferredValue.getText().toString()));
        editor.commit();
    }
    private void displayPreferredValue(View view) {
        int value = sharedPref.getInt(getString(R.string.module_4_preferred_value), 42);
        preferredValue.setText(Integer.toString(value));
    }

}