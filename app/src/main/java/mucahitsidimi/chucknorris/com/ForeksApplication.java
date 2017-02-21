package mucahitsidimi.chucknorris.com;


import android.app.Application;

import mucahitsidimi.chucknorris.com.di.component.AppComponent;
import mucahitsidimi.chucknorris.com.di.component.DaggerAppComponent;
import mucahitsidimi.chucknorris.com.di.module.AppModule;

/**
 * Created by mucahit on 19/02/2017.
 */

public class ForeksApplication extends Application {

    private static ForeksApplication mInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }

    public AppComponent component() {
        return appComponent;
    }

    public static synchronized ForeksApplication getInstance() {
        return mInstance;
    }
}
