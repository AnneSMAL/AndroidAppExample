package be.henallux.ig3.android.app.example.ui.module4;

import android.os.Bundle;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.ui.ModulePresentationFragment;

public class PersistencePresentationFragment extends ModulePresentationFragment {

    @Override
    protected Integer getTitleResources() {
        return R.string.module_4_title;
    }

    @Override
    protected Integer getDescriptionResources() {
        return R.string.module_4_description;
    }

    @Override
    protected Integer getNextScreenNavigationAction() {
        return R.id.action_mod4PresentationFragment_to_mod4TwoMainSolutionsFragment;
    }
}

