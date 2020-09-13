package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;


public class ResourcesTypesFragment extends Fragment {

    public ResourcesTypesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mod2_fragment_resources_types, container, false);

        final Button drawablesButton = root.findViewById(R.id.resources_types_drawable_button);
        final Button layoutsButton = root.findViewById(R.id.resources_types_layout_button);
        final Button menuButton = root.findViewById(R.id.resources_types_menu_button);
        final Button mipmapButton = root.findViewById(R.id.resources_types_mipmap_button);
        final Button navigationButton = root.findViewById(R.id.resources_types_navigation_button);
        final Button valuesButton = root.findViewById(R.id.resources_types_values_button);

        drawablesButton.setOnClickListener(view -> goToFragment(view, R.id.action_ResourcesTypesFragment_to_DrawableResourcesFragment));
        layoutsButton.setOnClickListener(view -> goToFragment(view, R.id.action_ResourcesTypesFragment_to_LayoutsPresentationFragment));
        menuButton.setOnClickListener(view -> goToFragment(view, R.id.action_ResourcesTypesFragment_to_menuResourcesFragment));
        mipmapButton.setOnClickListener(view -> goToFragment(view, R.id.action_ResourcesTypesFragment_to_DrawableResourcesFragment));
        navigationButton.setOnClickListener(view -> goToFragment(view, R.id.action_ResourcesTypesFragment_to_navigationResourcesFragment));
        valuesButton.setOnClickListener(view -> goToFragment(view, R.id.action_ResourcesTypesFragment_to_valuesResourcesFragment));

        return root;
    }

    private void goToFragment(View view, Integer actionId) {
        Navigation.findNavController(view).navigate(actionId);
    }
}
