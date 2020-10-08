package be.henallux.ig3.android.app.example.ui.module3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.databinding.Mod3FragmentAndroidArchitectureBinding;

public class AndroidArchitectureFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Mod3FragmentAndroidArchitectureBinding binding = Mod3FragmentAndroidArchitectureBinding
                .inflate(inflater, container, false);

        binding.androidArchitectureDoneButton.setOnClickListener(view -> Navigation.findNavController(view)
                .navigate(AndroidArchitectureFragmentDirections.actionAndroidArchitectureFragmentToMod3PresentationFragment()));

        return binding.getRoot();
    }
}
