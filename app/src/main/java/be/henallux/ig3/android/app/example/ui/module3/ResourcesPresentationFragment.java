package be.henallux.ig3.android.app.example.ui.module3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import be.henallux.ig3.android.app.example.R;
import be.henallux.ig3.android.app.example.ui.ModulePresentationFragment;

public class ResourcesPresentationFragment extends ModulePresentationFragment {


    @Override
    protected Integer getTitleResources() {
        return R.string.module_3_title;
    }

    @Override
    protected Integer getDescriptionResources() {
        return R.string.module_3_description;
    }

    @Override
    protected Integer getNextScreenNavigationAction() {
        return R.id.action_PresentationFragment_to_ResourcesTypesFragment;
    }
}
