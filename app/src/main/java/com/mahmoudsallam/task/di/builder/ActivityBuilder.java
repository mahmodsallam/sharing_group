package com.mahmoudsallam.task.di.builder;

import com.mahmoudsallam.task.ui.main.MainActivity;
import com.mahmoudsallam.task.ui.main.MainFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainFragmentProvider.class})
    abstract MainActivity bindMainActivity();
}
