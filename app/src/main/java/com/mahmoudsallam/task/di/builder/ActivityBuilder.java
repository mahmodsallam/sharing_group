package com.mahmoudsallam.task.di.builder;

import com.mahmoudsallam.task.ui.main.MainActivity;
import com.mahmoudsallam.task.ui.main.MainFragmentProvider;
import com.mahmoudsallam.task.ui.splash.SplashFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainFragmentProvider.class, SplashFragmentProvider.class})
    abstract MainActivity bindMainActivity();

}
