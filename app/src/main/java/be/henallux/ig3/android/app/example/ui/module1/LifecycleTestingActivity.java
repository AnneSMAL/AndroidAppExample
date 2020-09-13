package be.henallux.ig3.android.app.example.ui.module1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import be.henallux.ig3.android.app.example.R;

/**
 * Activity used to demonstrate Android Activity Lifecycle. Go to the Logcat section in your IDE,
 * search for LifecycleTestingAct logs, and play with your emulator to understand the complete
 * lifecycle of an activity. <br/>
 *
 * Go to the @{@link LifecycleTestingFragment} to do exactly the same exercise for a fragment.
 */
public class LifecycleTestingActivity extends AppCompatActivity {
    private static final String TAG = "LifecycleTesting";

    /**
     * Called first time the activity starts. The activity is created and initialised. <br/>
     * In this method, you have to : <br/>
     * - Inflate the UI; <br/>
     * - Initialize variables (classical ones & UI elements coming from layout); <br/>
     * - Do whatever happens <u>once</u> during the activity lifetime (Listeners, ...);
     *
     * @param savedInstanceState Bundle containing all data of the activity saved in case Android
     *                           silently killed our app. This bundle will help us to recreate the
     *                           previous state of the screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mod1_activity_lifecycle_testing);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(TAG, "Activity - onCreate()");
    }

    /**
     * Triggered when the activity becomes visible. This method can then be called multiple times
     * if user leaves and comes back to the activity. <br/>
     * In this method, you can : <br/>
     * - Start sensors, animations, ... anything needed when activity becomes visible; <br/>
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Activity - onStart()");
    }

    /**
     * Triggered when user can interact with the activity : He has the focus. <br/>
     * In this method, you can : <br/>
     * - Start sensors, animations, ... anything needed when user finds back the focus; <br/>
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activity - onResume()");
    }

    /**
     * Called after the activity is created, whenever it is not the first time it has been created.
     * (For example, user goes to the Home screen and comes back into the app.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Activity - onRestart()");
    }

    /**
     * Triggered when user looses focus on the current activity. <br/>
     * In this method, you can : <br/>
     * - Stop any sensors, animations, ... requiring user focus; <br/>
     * WARNING : Keep this method fast and simple. Next activity is not shown until this method is
     * completed.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Activity - onPause()");
    }

    /**
     * Called when the activity is not visible anymore to the user. <br/>
     * In this method, you can : <br/>
     * - Persist data; <br/>
     * - Stop logic in charge of updating the UI (animations, refresh, ...); <br/>
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Activity - onStop()");
    }

    /**
     * Called just before the activity is fully destroyed; <br/>
     * In this method, you can : <br/>
     * - Tear down any resources related to the activity; <br/>
     * WARNING : Do not forget to stop every background thread, every job, ... linked to the
     * activity, to avoid memory leaks and crashes.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity - onDestroy()");
    }
}
