package com.mahmoudsallam.task.ui.splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
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
import com.mahmoudsallam.task.databinding.FragmentMainBinding;
import com.mahmoudsallam.task.databinding.FragmentSplashBinding;
import com.mahmoudsallam.task.ui.base.BaseFragment;
import com.mahmoudsallam.task.ui.base.BaseViewModel;
import com.mahmoudsallam.task.ui.main.MainViewModel;

import javax.inject.Inject;

public class SplashFragment extends BaseFragment<FragmentSplashBinding, MainViewModel> {

    @Inject
    ViewModelProviderFactory factory;
    MainViewModel mMainViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return mMainViewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> Navigation.findNavController(getView())
                        .navigate(R.id.action_splashFragment_to_mainFragment, null),
                2000);

    }


}
