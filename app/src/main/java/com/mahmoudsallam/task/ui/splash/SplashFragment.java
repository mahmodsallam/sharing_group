package com.mahmoudsallam.task.ui.splash;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mahmoudsallam.task.R;
import com.mahmoudsallam.task.ViewModelProviderFactory;
import com.mahmoudsallam.task.ui.base.BaseFragment;
import com.mahmoudsallam.task.ui.base.BaseViewModel;
import com.mahmoudsallam.task.ui.main.MainViewModel;

import javax.inject.Inject;

public class SplashFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build();
        new Handler().postDelayed(() -> Navigation.findNavController(view)
                        .navigate(R.id.action_splashFragment_to_mainFragment, null, navOptions),
                2000);
        return view;
    }


}
