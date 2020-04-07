package com.mahmoudsallam.task.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mahmoudsallam.task.BR;
import com.mahmoudsallam.task.R;
import com.mahmoudsallam.task.ViewModelProviderFactory;
import com.mahmoudsallam.task.data.model.api.UsersResponse;
import com.mahmoudsallam.task.databinding.FragmentMainBinding;
import com.mahmoudsallam.task.ui.base.BaseFragment;
import com.mahmoudsallam.task.ui.details.DetailsFragment;

import java.util.List;

import javax.inject.Inject;

public class MainFragment extends BaseFragment<FragmentMainBinding, MainViewModel> implements MainNavigator {

    @Inject
    ViewModelProviderFactory factory;
    MainViewModel mMainViewModel;
    UsersAdapter usersAdapter;
    private ImageView no_internet_img;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return mMainViewModel;
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainViewModel.setNavigator(this);
        if (isNetworkConnected() == true) {
            mMainViewModel.getUsersFromLocal();
            mMainViewModel.getUsers();
        } else {
            mMainViewModel.getUsersFromLocal();
        }


    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        mMainViewModel.usersList.observe(getViewLifecycleOwner(), usersResponseList -> {
            usersAdapter = new UsersAdapter(getContext(), usersResponseList, this);
            getViewDataBinding().usersRv.setLayoutManager(new LinearLayoutManager(getContext()));
            getViewDataBinding().usersRv.setAdapter(usersAdapter);
        });
        mMainViewModel.showNoInternet.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean == true) {
                if (!isNetworkConnected())
                    getViewDataBinding().noInternetView.setVisibility(View.VISIBLE);
            } else {
                getViewDataBinding().noInternetView.setVisibility(View.GONE);

            }
        });
        mMainViewModel.showLoading.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean == true) {
                getViewDataBinding().progress.setVisibility(View.VISIBLE);
            } else {
                getViewDataBinding().progress.setVisibility(View.GONE);

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void showUserDetails(UsersResponse user) {
        Bundle arg = new Bundle();
        arg.putParcelable("USER_DETAILS", user);
        Navigation.findNavController(getView()).
                navigate(R.id.action_mainFragment_to_detailsFragment, arg);
    }
}
