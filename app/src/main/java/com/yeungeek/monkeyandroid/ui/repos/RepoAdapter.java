package com.yeungeek.monkeyandroid.ui.repos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yeungeek.monkeyandroid.R;
import com.yeungeek.monkeyandroid.data.model.Repo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yeungeek on 2016/1/10.
 */
public class RepoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Repo> repos = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Repo repo = repos.get(position);
        RepoViewHolder repoViewHolder = (RepoViewHolder) holder;
        repoViewHolder.repoName.setText(repo.getName());
        repoViewHolder.repoDesc.setText(repo.getDescription());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void setDatas(final List<Repo> data){
        this.repos = data;
        notifyDataSetChanged();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.repo_name)
        TextView repoName;
        @Bind(R.id.repo_desc)
        TextView repoDesc;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
