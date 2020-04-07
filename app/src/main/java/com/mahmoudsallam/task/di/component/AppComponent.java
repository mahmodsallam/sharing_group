package com.mahmoudsallam.task.di.component;

import android.app.Application;

import com.mahmoudsallam.task.MvvmApp;
import com.mahmoudsallam.task.data.remote.AppApiHelper;
import com.mahmoudsallam.task.di.builder.ActivityBuilder;
import com.mahmoudsallam.task.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
