package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.databinding.Mod2FragmentNavigationResourcesBinding;


public class NavigationResourcesFragment extends Fragment {

    // Binding
    private Mod2FragmentNavigationResourcesBinding binding;

    // Args
    private String myFirstSafeArg;

    public NavigationResourcesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myFirstSafeArg = NavigationResourcesFragmentArgs.fromBundle(getArguments()).getMyFirstSafeArg();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Mod2FragmentNavigationResourcesBinding.inflate(inflater, container, false);

        binding.resNavigationDoneButton.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(NavigationResourcesFragmentDirections.actionNavigationResourcesFragmentToResourcesTypesFragment()));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (myFirstSafeArg != null) {
            Toast.makeText(getActivity(), myFirstSafeArg, Toast.LENGTH_SHORT).show();
        }
    }
}
