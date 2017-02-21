package mucahitsidimi.chucknorris.com.domain.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mucahitsidimi.chucknorris.com.R;

/**
 * Created by mucahit on 19/02/2017.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<String> mCategories = new ArrayList<>();
    private OnCategoryClickListener mCategoryClickListener;

    public CategoriesAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public void addCategories(List<String> categories) {
        mCategories.addAll(categories);
        notifyDataSetChanged();
    }

    public void setCategoryClickListener(OnCategoryClickListener listener) {
        mCategoryClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.tv_category_name)
        TextView tvCategoryName;
        private String mCategoryName;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String categoryName) {
            mCategoryName = categoryName;
            tvCategoryName.setText(categoryName);
        }

        @Override
        public void onClick(View view) {
            if (mCategoryClickListener != null) {
                mCategoryClickListener.onClick(mCategoryName);
            }
        }
    }

    public interface OnCategoryClickListener {
        void onClick(String category);
    }
}
