package mucahitsidimi.chucknorris.com.domain.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import mucahitsidimi.chucknorris.com.R;
import mucahitsidimi.chucknorris.com.domain.BaseActivity;
import mucahitsidimi.chucknorris.com.domain.adapter.CategoriesAdapter;
import mucahitsidimi.chucknorris.com.domain.detail.DetailActivity;
import mucahitsidimi.chucknorris.com.ext.Constants;

public class MainActivity extends BaseActivity implements MainView {

    @Bind(R.id.categories_list)
    RecyclerView mCategoriesList;

    private CategoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();
        MainPresenter mPresenter = new MainPresenter(MainActivity.this);
        mPresenter.getCategories();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    private void initializeList() {
        mCategoriesList.setHasFixedSize(true);
        mCategoriesList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new CategoriesAdapter();
        mAdapter.setCategoryClickListener(mCategoryClickListener);
        mCategoriesList.setAdapter(mAdapter);
    }

    @Override
    public void onCategoriesLoaded(List<String> categories) {
        mAdapter.addCategories(categories);
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
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private CategoriesAdapter.OnCategoryClickListener mCategoryClickListener = new CategoriesAdapter.OnCategoryClickListener() {
        @Override
        public void onClick(String category) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(Constants.IK_CATEGORY, category);
            startActivity(intent);
        }
    };
}
