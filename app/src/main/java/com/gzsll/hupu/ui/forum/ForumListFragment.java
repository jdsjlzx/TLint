package com.gzsll.hupu.ui.forum;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gzsll.hupu.R;
import com.gzsll.hupu.db.Forum;
import com.gzsll.hupu.ui.BaseFragment;
import com.gzsll.hupu.ui.main.MainComponent;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sll on 2016/3/11.
 */
public class ForumListFragment extends BaseFragment implements ForumListContract.View {

    public static ForumListFragment newInstance(String forumId) {
        ForumListFragment mFragment = new ForumListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forumId", forumId);
        mFragment.setArguments(bundle);
        return mFragment;
    }


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;


    private String forumId;

    @Inject
    ForumListPresenter mPresenter;
    @Inject
    ForumListAdapter mAdapter;
    @Inject
    Activity mActivity;

    @Override
    public void initInjector() {
        getComponent(MainComponent.class).inject(this);
    }

    @Override
    public int initContentView() {
        return R.layout.base_list_layout;
    }

    @Override
    public void getBundle(Bundle bundle) {
        forumId = bundle.getString("forumId");
    }

    @Override
    public void initUI(View view) {
        ButterKnife.bind(this, view);
        mPresenter.attachView(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity.getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(mAdapter);
        recyclerView.addItemDecoration(headersDecor);
        refreshLayout.setEnabled(false);
    }

    @Override
    public void initData() {
        mPresenter.onForumListReceive(forumId);
    }

    @Override
    public void showLoading() {
        showProgress(true);
    }

    @Override
    public void hideLoading() {
        showContent(true);
    }

    @Override
    public void onError() {
        showError(true);
    }

    @Override
    public void renderForumList(List<Forum> forumList) {
        mAdapter.bind(forumList, forumId);
    }


}
