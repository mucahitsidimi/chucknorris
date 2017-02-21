package mucahitsidimi.chucknorris.com.domain.home;

import java.util.List;

import mucahitsidimi.chucknorris.com.ForeksApplication;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mucahit on 19/02/2017.
 */

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void getCategories() {
        view.onShowDialog("Loading..");
        ForeksApplication.getInstance().component().getChucknorrisNetwork().getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onCompleted() {
                        view.onHideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onHideDialog();
                        view.onShowToast("Error: " + e.toString());
                    }

                    @Override
                    public void onNext(List<String> categories) {
                        view.onShowToast("loaded");
                        view.onCategoriesLoaded(categories);
                    }
                });
    }

}
