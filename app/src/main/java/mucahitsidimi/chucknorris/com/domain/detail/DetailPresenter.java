package mucahitsidimi.chucknorris.com.domain.detail;

import mucahitsidimi.chucknorris.com.ForeksApplication;
import mucahitsidimi.chucknorris.com.ext.TextUtils;
import mucahitsidimi.chucknorris.com.pojo.Joke;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mucahit on 19/02/2017.
 */

public class DetailPresenter {

    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    public void getJoke(String category) {
        view.onShowDialog("Loading..");
        ForeksApplication.getInstance().component().getChucknorrisNetwork().getJoke(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Joke>() {
                    @Override
                    public void onCompleted() {
                        view.onHideDialog();
                        view.onShowToast("completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onHideDialog();
                        view.onShowToast(e.toString());
                    }

                    @Override
                    public void onNext(Joke joke) {
                        view.setIcon(joke.getIconUrl());
                        view.setValueText(joke.getValue());
                        view.setWordsCountText(TextUtils.getWordsCount(joke.getValue()));
                        view.setLettersCountText(TextUtils.getLettersCount(joke.getValue()));
                    }
                });
    }
}
