package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.databinding.Mod2FragmentValuesResourcesBinding;


public class ValuesResourcesFragment extends Fragment {

    private Mod2FragmentValuesResourcesBinding binding;

    public ValuesResourcesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Mod2FragmentValuesResourcesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.resValuesWhatIsItText.setText(getString(R.string.module_2_values_what_is_it));
        binding.resValuesWhatIsItText.setBackgroundColor(getResources().getColor(R.color.colorAccent, getActivity().getTheme()));

        binding.resValuesDoneButton.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(ValuesResourcesFragmentDirections.actionValuesResourcesFragmentToResourcesTypesFragment()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
