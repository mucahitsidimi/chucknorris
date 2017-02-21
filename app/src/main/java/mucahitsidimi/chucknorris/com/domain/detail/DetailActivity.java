package mucahitsidimi.chucknorris.com.domain.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import mucahitsidimi.chucknorris.com.ForeksApplication;
import mucahitsidimi.chucknorris.com.R;
import mucahitsidimi.chucknorris.com.domain.BaseActivity;
import mucahitsidimi.chucknorris.com.ext.Constants;

/**
 * Created by mucahit on 19/02/2017.
 */

public class DetailActivity extends BaseActivity implements DetailView {

    @Bind(R.id.iv_icon)
    ImageView ivIcon;

    @Bind(R.id.tv_value)
    TextView tvValue;

    @Bind(R.id.tv_words_count)
    TextView tvWordsCount;

    @Bind(R.id.tv_letters_count)
    TextView tvLattersCount;

    private DetailPresenter mPrasenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBackArrow();
        mPrasenter = new DetailPresenter(this);
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().containsKey(Constants.IK_CATEGORY)) {
            String category = getIntent().getExtras().getString(Constants.IK_CATEGORY);
            mPrasenter.getJoke(category);
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    public void onShowDialog(String message) {
        showProgressDialog(message);
    }

    @Override
    public void onHideDialog() {
        dismissProgressDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(DetailActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setIcon(String imageUrl) {
        ForeksApplication.getInstance().component().picasso().with(this).load(imageUrl).into(ivIcon);
    }

    @Override
    public void setValueText(String text) {
        tvValue.setText(text);
    }

    @Override
    public void setWordsCountText(String text) {
        tvWordsCount.setText(text);
    }

    @Override
    public void setLettersCountText(String text) {
        tvLattersCount.setText(text);
    }
}
