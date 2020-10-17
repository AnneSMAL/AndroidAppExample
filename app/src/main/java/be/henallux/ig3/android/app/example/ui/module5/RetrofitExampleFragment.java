package be.henallux.ig3.android.app.example.ui.module5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.databinding.Mod5FragmentRetrofitExampleBinding;

public class RetrofitExampleFragment extends Fragment {

    private Mod5FragmentRetrofitExampleBinding binding;
    private RetrofitExampleViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RetrofitExampleViewModel.class);

        binding = Mod5FragmentRetrofitExampleBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        // Observing LiveData
        viewModel.getPizza().observe(getViewLifecycleOwner(), pizza -> {
            binding.pizzaProgressBar.setVisibility(View.GONE);
            binding.pizzaInfoLayout.setVisibility(View.VISIBLE);
        });
        viewModel.getError().observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Toast.makeText(getContext(), getString(error.getErrorMessage()), Toast.LENGTH_LONG).show();
            }
        });

        // Navigate to next screen
        binding.retrofitImplementationNextButton.setOnClickListener(view -> Navigation.findNavController(view)
                .navigate(R.id.action_retrofitExampleFragment_to_mod5PresentationFragment));

        // Initializing Screen (Launch HTTP Request)
        viewModel.getPizzaFromWeb();
        binding.pizzaInfoLayout.setVisibility(View.GONE);

        return binding.getRoot();
    }


}
