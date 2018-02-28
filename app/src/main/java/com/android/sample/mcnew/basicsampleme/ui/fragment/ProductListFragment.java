package com.android.sample.mcnew.basicsampleme.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.sample.mcnew.basicsampleme.R;
import com.android.sample.mcnew.basicsampleme.databinding.ListFragmentBinding;
import com.android.sample.mcnew.basicsampleme.model.Product;
import com.android.sample.mcnew.basicsampleme.ui.ProductClickCallback;
import com.android.sample.mcnew.basicsampleme.ui.adapter.ProductAdapter;
import com.android.sample.mcnew.basicsampleme.viewmodel.ProductListViewModel;

/**
 * Created by MCNEWZ on 27-Feb-18.
 */

public class ProductListFragment extends Fragment {

    public static final String TAG = "ProductListViewModel";

    private ProductAdapter mProductAdapter;
    private ListFragmentBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false);

        mProductAdapter = new ProductAdapter(mProductClickCallback);
        mBinding.productsList.setAdapter(mProductAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ProductListViewModel viewModel =
                ViewModelProviders.of(this).get(ProductListViewModel.class);


    }

    private final ProductClickCallback mProductClickCallback = new ProductClickCallback() {
        @Override
        public void onClick(Product product) {

            Toast.makeText(getContext(), "Hello"+product, Toast.LENGTH_SHORT).show();
        }
    };
}
