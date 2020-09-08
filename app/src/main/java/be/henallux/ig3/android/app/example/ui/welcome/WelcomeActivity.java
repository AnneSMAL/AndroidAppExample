package be.henallux.ig3.android.app.example.ui.welcome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import be.henallux.ig3.android.app.example.ui.MainActivity;
import be.henallux.ig3.android.app.example.R;

/**
 * Activity displayed when launching the mobile application. <br/>
 * Go to the AndroidManifest.xml file to see how to tell to Android which Activity should be used
 * as the "Launcher" Activity for the app.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button startButton = findViewById(R.id.welcome_start_button);
        startButton.setOnClickListener(this::navigateToNextActivity);
    }

    /**
     * An Intent is used to start another activity that can either be contained in our mobile
     * application (just like in our method) or to start the activity of another app on the phone
     * (such as the camera, the Contacts, ...). <br/>
     * It is possible to provide arguments through Intents, so that the next activity will receive
     * a series of information. <br/>
     * For more information about Intents, go and check https://developer.android.com/guide/components/intents-filters
     *
     * @param view Unused here to start the next activity
     */
    private void navigateToNextActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
