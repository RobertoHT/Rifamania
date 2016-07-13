package edu.galileo.android.rifamania.libs.di;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.rifamania.libs.GreenRobotEventBus;
import edu.galileo.android.rifamania.libs.base.EventBus;

/**
 * Created by praxis on 13/07/16.
 */
@Module
public class LibsModule {
    private Activity activity;

    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    Activity provideActivity(){
        return this.activity;
    }
}
