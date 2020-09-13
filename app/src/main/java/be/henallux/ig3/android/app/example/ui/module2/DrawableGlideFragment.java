package be.henallux.ig3.android.app.example.ui.module2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

import be.henallux.ig3.android.app.example.R;


public class DrawableGlideFragment extends Fragment {

    private ImageView logoImageView;

    public DrawableGlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mod2_fragment_drawable_glide, container, false);

        logoImageView = root.findViewById(R.id.res_drawable_glide_image);
        final Button doneButton = root.findViewById(R.id.res_drawable_glide_done_button);

        initHenalluxLogoUsingGlide();
        doneButton.setOnClickListener(view ->
                Navigation.findNavController(view).navigate(R.id.action_drawableGlideFragment_to_resourcesTypesFragment));

        return root;
    }

    /**
     * Sets the Image inside our ImageView, using Glide framework. <br/>
     * For the complete documentation of the tool, go and check https://bumptech.github.io/glide <br/>
     * Do not forget that, to access images through URLs, you need to go through internet...
     */
    private void initHenalluxLogoUsingGlide() {
        Log.i("GlideFragment", "Trying to init image with Glide at address " + getString(R.string.glide_logo_url));
        Glide.with(this)
                .load(getString(R.string.glide_logo_url))
                .placeholder(R.drawable.ic_waiting)
                .into(logoImageView);
    }
}
