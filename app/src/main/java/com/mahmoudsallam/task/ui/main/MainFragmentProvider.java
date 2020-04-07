package com.mahmoudsallam.task.ui.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentProvider {
    @ContributesAndroidInjector
    abstract MainFragment provideMainFragmentFactory();
}
