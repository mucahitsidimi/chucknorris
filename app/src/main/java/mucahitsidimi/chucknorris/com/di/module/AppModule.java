package mucahitsidimi.chucknorris.com.di.module;


import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import mucahitsidimi.chucknorris.com.di.scope.AppScope;

/**
 * Created by mucahit on 19/02/2017.
 */

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @AppScope
    @Provides
    public Context context() {
        return context;
    }
}
