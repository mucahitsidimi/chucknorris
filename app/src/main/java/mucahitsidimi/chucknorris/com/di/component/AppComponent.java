package mucahitsidimi.chucknorris.com.di.component;


import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Component;
import mucahitsidimi.chucknorris.com.api.ChucknorrisNetwork;
import mucahitsidimi.chucknorris.com.di.module.AppModule;
import mucahitsidimi.chucknorris.com.di.module.NetworkModule;
import mucahitsidimi.chucknorris.com.di.scope.AppScope;
import okhttp3.OkHttpClient;

/**
 * Created by mucahit on 19/02/2017.
 */

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    Context context();

    OkHttpClient okhttpClient();

    ChucknorrisNetwork getChucknorrisNetwork();

    Picasso picasso();
}
