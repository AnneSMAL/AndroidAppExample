package be.henallux.ig3.android.app.example.ui.module3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.databinding.Mod3FragmentPassArgumentsBinding;

public class PassArgumentsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // To pass arguments to ViewModel, you need to create a dedicated Factory
        PassArgumentsViewModel.Factory viewModelFactory = new PassArgumentsViewModel
                .Factory(PassArgumentsFragmentArgs.fromBundle(getArguments()).getPreviousCounter());
        // And pass it to the ViewModelProvider
        PassArgumentsViewModel viewModel = new ViewModelProvider(this, viewModelFactory)
                .get(PassArgumentsViewModel.class);

        Mod3FragmentPassArgumentsBinding binding = Mod3FragmentPassArgumentsBinding
                .inflate(inflater, container, false);
        binding.setPassArgumentsViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getPreviousCounter().observe(getViewLifecycleOwner(), counter ->
                binding.passArgumentsMyCounterText.setText(getString(R.string.module_3_previous_counter_value, counter)));

        binding.passArgumentsNextButton.setOnClickListener(view -> Navigation.findNavController(view)
                .navigate(PassArgumentsFragmentDirections.actionPassArgumentsFragmentToAndroidArchitectureFragment()));

        return binding.getRoot();
    }
}
