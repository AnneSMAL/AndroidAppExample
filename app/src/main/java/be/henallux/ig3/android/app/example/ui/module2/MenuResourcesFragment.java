package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.databinding.Mod2FragmentMenuResourcesBinding;


public class MenuResourcesFragment extends Fragment {

    private Mod2FragmentMenuResourcesBinding binding;

    public MenuResourcesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Notify the fragment (or the activity) that it should participate in options menu handling
        // Otherwise, fragment won't display the menu
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Mod2FragmentMenuResourcesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.resNavigationDoneButton.setOnClickListener(view ->
                Navigation.findNavController(view)
                        .navigate(MenuResourcesFragmentDirections.actionMenuResourcesFragmentToResourcesTypesFragment()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Inflates the different menu that you would like to link to your fragment / activity.
     */
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.mod2_options_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * Listens to the clicks of the user on the different items menus. Do not forget to call the super
     * method for menu you don't know : Android is taking care of some behaviours by itself (Drawer button,
     * back button, ...) <br/>
     * Here, we decided to display a Toast for our menu, but you could for example decide to start
     * another activity, search into the screen, ...
     *
     * @param item Menu Item on which the user clicked
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.options_try_this_menu) {
            Toast.makeText(getActivity(), getString(R.string.mod2_menus_testing_menu), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
