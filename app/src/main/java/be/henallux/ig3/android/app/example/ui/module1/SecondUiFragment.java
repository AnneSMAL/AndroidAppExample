package be.henallux.ig3.android.app.example.ui.module1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import be.henallux.ig3.android.app.example.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondUiFragment#newArguments} factory method to
 * create a new arguments bundle for this fragment.
 */
public class SecondUiFragment extends Fragment {
    private static final String ARG_NAME = "name";
    private static final String ARG_AGE = "age";
    private static final String ARG_MAIL = "mail";

    private String argName;
    private Integer argAge;
    private String argMail;

    public SecondUiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param mail Parameter 2.
     * @return A new bundle containing arguments for fragment SecondUiFragment.
     */
    static Bundle newArguments(String name, Integer age, String mail) {
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_AGE, age);
        args.putString(ARG_MAIL, mail);
        return args;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            argName = getArguments().getString(ARG_NAME);
            argAge = getArguments().getInt(ARG_AGE);
            argMail = getArguments().getString(ARG_MAIL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_second_ui, container, false);

        final TextView nameTextView = root.findViewById(R.id.second_ui_name_value_text);
        final TextView ageTextView = root.findViewById(R.id.second_ui_age_value_text);
        final TextView mailTextView = root.findViewById(R.id.second_ui_mail_value_text);
        final Button doneButton = root.findViewById(R.id.second_ui_done_button);

        nameTextView.setText(argName);
        ageTextView.setText(String.valueOf(argAge));
        mailTextView.setText(argMail);

        doneButton.setOnClickListener(this::goToNextFragment);

        return root;
    }

    private void goToNextFragment(View view) {
        Navigation.findNavController(view)
                .navigate(R.id.action_SecondUiFragment_to_Mod1PresentationFragment);
    }
}
