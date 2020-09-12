package be.henallux.ig3.android.app.example.ui.module1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import be.henallux.ig3.android.app.example.R;

public class LifecycleTestingFragment extends Fragment {
    private static final String TAG = "LifecycleTesting";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "Fragment - onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Fragment - onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "Fragment - onCreateView()");

        View root = inflater.inflate(R.layout.mod1_fragment_lifecycle_testing, container, false);

        final Button doneButton = root.findViewById(R.id.lifecycle_testing_done_button);
        doneButton.setOnClickListener(view -> {
            if (getActivity() != null) {
                getActivity().finish();
            }
        });

        return root;
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
