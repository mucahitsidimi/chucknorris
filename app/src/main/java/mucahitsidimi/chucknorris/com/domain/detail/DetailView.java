package mucahitsidimi.chucknorris.com.domain.detail;

/**
 * Created by mucahit on 19/02/2017.
 */

public interface DetailView {

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);

    void setIcon(String imageUrl);

    void setValueText(String text);

    void setWordsCountText(String text);

    void setLettersCountText(String text);
}
