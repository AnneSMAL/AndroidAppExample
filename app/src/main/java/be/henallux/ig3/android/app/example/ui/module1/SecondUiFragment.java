package be.henallux.ig3.android.app.example.ui.module1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.ui.MainActivity;

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
     * Use this factory method to create a bundle containing all needed arguments to create this fragment. <br/>
     * To pass arguments between fragments, the bundle is the usual component. There is another
     * mechanism called "safe-args", which is a bit safer than the bundle, but that is requiring
     * other gradle dependencies and plugins to add into your project.<br/>
     * For more information about safe-args, go to https://developer.android.com/guide/navigation/navigation-pass-data
     *
     * @param name Name of the user.
     * @param age Age of the user
     * @param mail Mail of the user.
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
        View root = inflater.inflate(R.layout.mod1_fragment_second_ui, container, false);

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
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //Navigation.findNavController(view)
        //      .navigate(R.id.action_SecondUiFragment_to_Mod1PresentationFragment);
    }
}
