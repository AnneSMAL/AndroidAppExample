package be.henallux.ig3.android.app.example.ui.module5;

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
import be.henallux.ig3.android.app.example.databinding.Mod5FragmentRetrofitExampleBinding;
import be.henallux.ig3.android.app.example.models.NetworkError;

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
            binding.pizzaErrorLayout.setVisibility(View.GONE);
            binding.pizzaInfoLayout.setVisibility(View.VISIBLE);
            binding.retrofitImplementationRefreshButton.setVisibility(View.VISIBLE);
        });

        viewModel.getError().observe(getViewLifecycleOwner(), this::displayErrorScreen);

        // On Click Listeners
        binding.retrofitImplementationRefreshButton.setOnClickListener(view -> this.sendRequest());
        binding.retrofitImplementationNextButton.setOnClickListener(view -> Navigation.findNavController(view)
                .navigate(R.id.action_retrofitExampleFragment_to_mod5PresentationFragment));

        // Initializing Screen (Launch HTTP Request)
        sendRequest();

        return binding.getRoot();
    }

    private void sendRequest() {
        viewModel.getPizzaFromWeb();
        binding.pizzaInfoLayout.setVisibility(View.GONE);
        binding.pizzaErrorLayout.setVisibility(View.GONE);
        binding.retrofitImplementationRefreshButton.setVisibility(View.GONE);
        binding.pizzaProgressBar.setVisibility(View.VISIBLE);
    }

    private void displayErrorScreen(NetworkError error) {
        binding.pizzaProgressBar.setVisibility(View.GONE);
        binding.retrofitImplementationRefreshButton.setVisibility(View.VISIBLE);

        if (error == null) {
            binding.pizzaInfoLayout.setVisibility(View.VISIBLE);
            binding.pizzaErrorLayout.setVisibility(View.GONE);
            return;
        }

        binding.pizzaErrorLayout.setVisibility(View.VISIBLE);
        binding.pizzaInfoLayout.setVisibility(View.GONE);
        binding.pizzaErrorImage.setImageDrawable(getResources().getDrawable(error.getErrorDrawable(),
                getActivity().getTheme()));
        binding.pizzaErrorText.setText(error.getErrorMessage());
    }
}
