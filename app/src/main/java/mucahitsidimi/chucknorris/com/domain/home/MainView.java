package mucahitsidimi.chucknorris.com.domain.home;

import java.util.List;

/**
 * Created by mucahit on 19/02/2017.
 */

public interface MainView{

    void onCategoriesLoaded(List<String> categories);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);

}
