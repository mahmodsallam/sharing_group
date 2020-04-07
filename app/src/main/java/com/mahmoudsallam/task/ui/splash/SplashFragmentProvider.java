package com.mahmoudsallam.task.ui.splash;

import androidx.transition.Visibility;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SplashFragmentProvider {
    @ContributesAndroidInjector
    abstract SplashFragment provideSplashFragment();

}
