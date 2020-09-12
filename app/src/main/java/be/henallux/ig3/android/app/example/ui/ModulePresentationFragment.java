package be.henallux.ig3.android.app.example.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;

public abstract class ModulePresentationFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment_module_presentation, container, false);

        final TextView titleTextView = root.findViewById(R.id.module_presentation_title_text);
        final TextView descriptionTextView = root.findViewById(R.id.module_presentation_description_text);

        final Button startButton = root.findViewById(R.id.module_presentation_start_button);

        titleTextView.setText(getTitleResources());
        descriptionTextView.setText(getDescriptionResources());

        startButton.setOnClickListener(view ->
                Navigation.findNavController(view).navigate(getNextScreenNavigationAction()));

        return root;
    }

    protected abstract Integer getTitleResources();

    protected abstract Integer getDescriptionResources();

    protected abstract Integer getNextScreenNavigationAction();
}
