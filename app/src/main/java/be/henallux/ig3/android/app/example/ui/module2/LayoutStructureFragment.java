package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;


public class LayoutStructureFragment extends Fragment {

    public LayoutStructureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mod2_fragment_layout_structure, container, false);

        final Button nextButton = root.findViewById(R.id.res_layouts_next_button);
        nextButton.setOnClickListener(view ->
                Navigation.findNavController(view).navigate(R.id.action_layoutStructureFragment_to_layoutViewBindingFragment));

        return root;
    }
}
