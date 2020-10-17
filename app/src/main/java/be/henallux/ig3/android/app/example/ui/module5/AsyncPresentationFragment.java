package be.henallux.ig3.android.app.example.ui.module5;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.ui.ModulePresentationFragment;

public class AsyncPresentationFragment extends ModulePresentationFragment {
    @Override
    protected Integer getTitleResources() {
        return R.string.module_5_title;
    }

    @Override
    protected Integer getDescriptionResources() {
        return R.string.module_5_description;
    }

    @Override
    protected Integer getNextScreenNavigationAction() {
        return R.id.action_PresentationFragment_to_whatIsAsyncFragment;
    }
}
