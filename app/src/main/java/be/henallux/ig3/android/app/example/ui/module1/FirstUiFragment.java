package be.henallux.ig3.android.app.example.ui.module1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputLayout;

import be.henallux.ig3.android.app.example.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstUiFragment extends Fragment {

    private TextInputLayout nameLayout;
    private TextInputLayout ageLayout;
    private TextInputLayout mailLayout;

    public FirstUiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflating our view manually
        View root = inflater.inflate(R.layout.mod1_fragment_first_ui, container, false);

        nameLayout = root.findViewById(R.id.first_ui_name_text_input_layout);
        ageLayout = root.findViewById(R.id.first_ui_age_text_input_layout);
        mailLayout = root.findViewById(R.id.first_ui_mail_text_input_layout);

        final Button toastButton = root.findViewById(R.id.first_ui_toast_button);
        final Button nextButton = root.findViewById(R.id.first_ui_next_button);

        toastButton.setOnClickListener(view -> displayHelloMessage());
        nextButton.setOnClickListener(view -> {
            checkFormErrors();
            if (!formContainsErrors()) {
                goToNextFragment(view);
            }
        });

        return root;
    }

    private void checkAndDisplayMandatoryFieldErrorFor(TextInputLayout textInputLayout) {
        if (isEditTextEmpty(textInputLayout)) {
            textInputLayout.setError(getResources().getText(R.string.module_1_mandatory_field));
        } else {
            textInputLayout.setError(null);
        }
    }

    private void checkAndDisplayNotValidAgeErrorFor(TextInputLayout textInputLayout) {
        if (isEditTextEmpty(textInputLayout)) {
            return;
        }

        Integer userAge = Integer.valueOf(readValueOf(textInputLayout));
        if (userAge <= 0 || userAge >= 120) {
            textInputLayout.setError(getResources().getText(R.string.module_1_first_ui_not_valid_age));
        } else {
            textInputLayout.setError(null);
        }
    }

    private void checkAndDisplayNotValidEmailFor(TextInputLayout textInputLayout) {
        if (isEditTextEmpty(textInputLayout)) {
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(readValueOf(textInputLayout)).matches()) {
            textInputLayout.setError(getResources().getText(R.string.module_1_first_ui_invalid_format));
        } else {
            textInputLayout.setError(null);
        }
    }

    private void displayHelloMessage() {
        if (isEditTextEmpty(nameLayout)) {
            nameLayout.setError(getResources().getText(R.string.module_1_mandatory_field));
        } else {
            nameLayout.setError(null);
            Toast.makeText(getActivity(),
                    getString(R.string.module_1_toast_hello_message, readValueOf(nameLayout)),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Checking if the EditText of the provided TextInputLayout contains any text
     *
     * @param textInputLayout UI Element in which we want to check whether or not there is a text
     * @return true, if the textInputLayout contains any text; otherwise false.
     */
    private boolean isEditTextEmpty(TextInputLayout textInputLayout) {
        return textInputLayout.getEditText() == null ||
                textInputLayout.getEditText().getText() == null ||
                textInputLayout.getEditText().getText().length() == 0;
    }

    /**
     * If textInputLayout editText value is null, throws a NullPointerException; <br/>
     * else, returns this value
     *
     * @param textInputLayout Field from which we need to read the value
     * @return Current value of the provided TextInputLayout
     */
    private String readValueOf(TextInputLayout textInputLayout) {
        return textInputLayout.getEditText().getText().toString();
    }

    /**
     * Checks all UI elements formats, to make sure all elements of the screen are valid
     * before making any action. <br/>
     * If an UI element has an error, this method will display it to the user
     */
    private void checkFormErrors() {
        checkAndDisplayMandatoryFieldErrorFor(nameLayout);

        checkAndDisplayMandatoryFieldErrorFor(ageLayout);
        checkAndDisplayNotValidAgeErrorFor(ageLayout);

        checkAndDisplayMandatoryFieldErrorFor(mailLayout);
        checkAndDisplayNotValidEmailFor(mailLayout);
    }

    /**
     * @return True if any of the UI elements contains an error; otherwise false
     */
    private boolean formContainsErrors() {
        return nameLayout.getError() != null
                || ageLayout.getError() != null
                || mailLayout.getError() != null;
    }

    /**
     * Creates a bundle to pass values of UI elements to the next fragment @{@link SecondUiFragment}. <br/>
     * Mechanism is pretty similar for activities : We will create a bundle that we will provide
     * to the @{@link android.content.Intent} starting the next activity. <br/>
     * You can find how to pass an argument to an activity at the following link https://stackoverflow.com/questions/3913592/start-an-activity-with-a-parameter
     */
    private void goToNextFragment(View view) {
        Bundle secondUiArgs = SecondUiFragment.newArguments(
                readValueOf(nameLayout),
                Integer.valueOf(readValueOf(ageLayout)),
                readValueOf(mailLayout)
        );

        Navigation.findNavController(view)
                .navigate(R.id.action_FirstUiFragment_to_SecondUiFragment, secondUiArgs);
    }
}
