package be.henallux.ig3.android.app.example.ui.module1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import be.henallux.ig3.android.app.example.R;

/**
 * Mastering the activity and fragment lifecycle will considerably help you to avoid a lot of bugs.
 * So take your time to analyze the logs, the code, play with the emulator, … and ask you the
 * following questions : What would happen if <br/>
 * <br/>
 * - I'm initializing my counter in onStart() instead of onCreate() ? <br/>
 * - I'm leaving the application ? <br/>
 * - I'm rotating the phone ? <br/>
 * - Android is killing my app to free some resources for other apps ? (Yes, … it does) <br/>
 */
public class LifecycleTestingFragment extends Fragment {
    // Constants
    private static final String TAG = "LifecycleTesting";
    private static final String SAVED_COUNTER = "SAVED_COUNTER";

    // Ui Elements
    private TextView myCounterTextView;

    // Variables
    private Integer myCounter;

    /**
     * Called when the fragment has been associated with the activity. <br/>
     * Operation here are very rare, as the fragment is still not created.
     *
     * @param context Context of the activity to which Android will link the fragment
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "Fragment - onAttach()");
    }

    /**
     * The system calls this when creating the fragment. <br/>
     * In this method, you should : <br/>
     * - Initialize essential components of the fragment that you want to retain when the fragment
     * is paused or stopped, then resumed.; <br/>
     * - Do whatever happens <u>once</u> during the activity lifetime;
     *
     * @param savedInstanceState Bundle containing all data of the activity saved in case Android
     *                           silently killed our app. This bundle will help us to recreate the
     *                           previous state of the screen.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Fragment - onCreate()");

        myCounter = (savedInstanceState == null) ? 0
                : savedInstanceState.getInt(SAVED_COUNTER);
    }

    /**
     * Called when it's time for the fragment to draw its user interface for the first time. This
     * method is creating the view hierarchy of the fragment. <br/>
     * In this method, you should : <br/>
     * - Initialize UI elements coming from the layout; <br/>
     * - Do whatever happens <u>once</u> during the fragment lifetime (Listeners, ...);
     *
     * @param inflater Component that will help us to inflate the UI
     * @param container UI Element that will contain the UI of our fragment
     * @param savedInstanceState Bundle containing all data of the activity saved in case Android
     *                           silently killed our app. This bundle will help us to recreate the
     *                           previous state of the screen.
     *
     * @return Inflated view, which is the root of your fragment's layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Fragment - onCreateView()");

        View root = inflater.inflate(R.layout.mod1_fragment_lifecycle_testing, container, false);

        myCounterTextView = root.findViewById(R.id.lifecycle_testing_my_counter_text);
        final Button addButton = root.findViewById(R.id.lifecycle_testing_add_to_counter_button);
        final Button doneButton = root.findViewById(R.id.lifecycle_testing_done_button);

        addButton.setOnClickListener(view -> {
            myCounter += 1;
            updateCounter(myCounter);
        });
        doneButton.setOnClickListener(view -> closeActivity());
        updateCounter(myCounter);

        return root;
    }

    private void updateCounter(Integer counter) {
        myCounterTextView.setText(getString(R.string.module_1_lifecycle_testing_my_counter, counter));
    }

    /**
     * Closes the activity of the current fragment, by removing it from the back stack of the phone.
     * By doing this, the current @{@link LifecycleTestingFragment} and @{@link LifecycleTestingActivity}
     * will both be destroyed.
     */
    private void closeActivity() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Fragment - onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Fragment - onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "Fragment - onPause()");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "Fragment - onStop()");
    }

    /**
     * Callback you can use to save data you might need in case Android is silently destroying
     * your app to free up some resources for other applications. <br/>
     * Do not save everything in this bundle ! Keep the amount of data very small, as the
     * fragment / activity is not destroyed until this method is finished (and restoring would take
     * a lot of time, too). <br/>
     * Android is automatically saving a lot of UI information, such as input texts, ... So do not
     * forget to call the super method
     *
     * @param outState Bundle in which you can save your data
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_COUNTER, myCounter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "Fragment - onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Fragment - onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "Fragment - onDetach()");
    }
}
