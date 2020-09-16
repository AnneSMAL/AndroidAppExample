package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
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

        drawablesButton.setOnClickListener(view -> goToFragment(view,
                ResourcesTypesFragmentDirections.actionResourcesTypesFragmentToDrawableResourcesFragment()));
        layoutsButton.setOnClickListener(view -> goToFragment(view,
                ResourcesTypesFragmentDirections.actionResourcesTypesFragmentToLayoutStructureFragment()));
        menuButton.setOnClickListener(view -> goToFragment(view,
                ResourcesTypesFragmentDirections.actionResourcesTypesFragmentToMenuResourcesFragment()));
        mipmapButton.setOnClickListener(view -> goToFragment(view,
                ResourcesTypesFragmentDirections.actionResourcesTypesFragmentToDrawableResourcesFragment()));
        navigationButton.setOnClickListener(view -> goToFragment(view,
                ResourcesTypesFragmentDirections.actionResourcesTypesFragmentToNavigationResourcesFragment(getMyFirstSafeArg())));
        valuesButton.setOnClickListener(view -> goToFragment(view,
                ResourcesTypesFragmentDirections.actionResourcesTypesFragmentToValuesResourcesFragment()));

        return root;
    }

    private String getMyFirstSafeArg() {
        return getString(R.string.module_2_navigation_getting_first_safe_arg);
    }

    private void goToFragment(View view, NavDirections direction) {
        Navigation.findNavController(view).navigate(direction);
    }
}
