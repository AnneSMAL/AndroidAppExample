package be.henallux.ig3.android.app.example.ui.module1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WhatIsAnActivityFragment extends Fragment {
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    public WhatIsAnActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_what_is_an_activity, container, false);

        // Link UI elements of your layout xml into variables
        final Button goToCameraButton = root.findViewById(R.id.what_is_an_activity_camera_button);
        final Button nextButton = root.findViewById(R.id.what_is_an_activity_next_button);

        // Work with your variables
        goToCameraButton.setOnClickListener(view -> goToCameraApp());
        nextButton.setOnClickListener(this::goToNextFragment);

        return root;
    }


    /**
     * To communicate with another activity (from our app or not), we need to use an @{@link Intent},
     * and providing the information of the activity we want to join. <br/>
     * In our example, to start the Camera App, we need to provide the ACTION_IMAGE_CAPTURE argument
     * to the Intent, and to launch it afterwards. <br/>
     * But that's not all. We also need to : <br/>
     * - Warn the user we will be using the camera (through AndroidManifest.xml); <br/>
     * - Manage the return of the user in the app (Check onActivityResult method below); <br/>
     * <br/>
     * To see an example of communication between two activities of the same app, go to
     * the @{@link be.henallux.ig3.android.app.example.ui.welcome.WelcomeActivity}
     */
    private void goToCameraApp() {
        Context context = getActivity();
        PackageManager packageManager = context == null ? null : context.getPackageManager();
        if (packageManager == null || !packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            Toast.makeText(getActivity(), "This device does not have any camera !", Toast.LENGTH_SHORT).show();
        } else {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    /**
     * Overriding this method of Android Fragment permits us to manage the return of the user, after
     * he left our app. This can allow us to stock the image, sending it to a backend app, ...
     *
     * @param requestCode Code sent to identify the Request Intent
     * @param resultCode  Code providing a result about the asked operation of the corresponding intent
     * @param data        Intent that was at the origin of the user departure from the app
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this.getActivity(), "Welcome back ! Nice picture !", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Navigates to the next screen. Do you know which one it will be ? Go to the
     * mobile_navigation.xml file to find it
     *
     * @param view View element calling the method
     */
    private void goToNextFragment(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_WhatIsActivityFragment_to_WhatIsAFragmentFragment);
    }
}
