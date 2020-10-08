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
import be.henallux.ig3.android.app.example.databinding.Mod3FragmentDataBindingBinding;

public class DataBindingFragment extends Fragment {

    private DataBindingViewModel viewModel;
    private Mod3FragmentDataBindingBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(DataBindingViewModel.class);

        binding = Mod3FragmentDataBindingBinding.inflate(inflater, container, false);
        binding.setDataBindingViewModel(viewModel);
        binding.setLifecycleOwner(this);

        binding.dataBindingNextButton.setOnClickListener(view -> {
            viewModel.fixCounter();
        });

        viewModel.getFinalCounter().observe(getViewLifecycleOwner(), counter -> {
            Navigation.findNavController(getActivity(), R.id.data_binding_next_button)
                    .navigate(DataBindingFragmentDirections.actionDataBindingFragmentToPassArgumentsFragment(counter));
        });

        return binding.getRoot();
    }
}
