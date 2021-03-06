package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.databinding.Mod2FragmentLayoutViewBindingBinding;

/**
 * To enable ViewBinding, you need to activate it through the build.gradle (app), by adding the
 * following code : <br/>
 * viewBinding { <br/>
 * enabled = true <br/>
 * } <br/>
 */
public class LayoutViewBindingFragment extends Fragment {

    // Class generated by Android to enable view binding for the current fragment.
    // No need to store every UI element in a variable now : Android is taking care of everything
    // for us
    private Mod2FragmentLayoutViewBindingBinding binding;

    public LayoutViewBindingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Mod2FragmentLayoutViewBindingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.resLayoutsViewBindingExampleEditText.setText(R.string.module_2_layouts_view_binding_in_action);
        binding.resLayoutsViewBindingNextButton.setOnClickListener(view ->
                Navigation.findNavController(view).navigate(R.id.action_layoutViewBindingFragment_to_resourcesTypesFragment));

        return root;
    }

    /**
     * When the fragment view is destroyed, do not forget to delete the binding variable, to avoid
     * any problem.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
