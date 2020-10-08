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
import be.henallux.ig3.android.app.example.databinding.Mod3FragmentWhatIsAViewModelBinding;

public class WhatIsAViewModelFragment extends Fragment {

    private Mod3FragmentWhatIsAViewModelBinding binding;
    private WhatIsAViewModelViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Instantiate ViewModel
        // NEVER EVER use simple constructor ! Always use ViewModelProvider to create your
        // viewModels. It is necessary so that Android can manage their lifecycle
        viewModel = new ViewModelProvider(this).get(WhatIsAViewModelViewModel.class);

        // View Binding
        binding = Mod3FragmentWhatIsAViewModelBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // OnClickListeners
        binding.viewModelAddToCounterButton.setOnClickListener(view -> viewModel.incrementCounter());
        binding.whatIsAViewModelNextButton.setOnClickListener(view -> {
            Navigation.findNavController(view)
                    .navigate(WhatIsAViewModelFragmentDirections.actionWhatIsViewModelFragmentToDataBindingFragment());
        });

        // Subscribing LiveData
        viewModel.getMyCounter().observe(getViewLifecycleOwner(), incrementedCounterValue -> binding.viewModelMyCounterText
                .setText(getString(R.string.my_counter, incrementedCounterValue)));
        return root;
    }
}
