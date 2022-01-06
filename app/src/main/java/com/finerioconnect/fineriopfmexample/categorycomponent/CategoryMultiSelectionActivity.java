package com.finerioconnect.fineriopfmexample.categorycomponent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK;
import com.finerioconnect.sdk.budget.core.Palette;
import com.finerioconnect.fineriopfmexample.databinding.ActivityCategoryMultiSelectionBinding;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.shared.enums.FCCategoryType;
import com.finerioconnect.sdk.ui.listeners.OnFCCategoriesListener;

import java.util.List;

public class CategoryMultiSelectionActivity extends AppCompatActivity {
    private ActivityCategoryMultiSelectionBinding mBinding;

    private static final String CATEGORY_KEY = "CATEGORY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCategoryMultiSelectionBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setUp();
    }

    private void setUp() {
        final FinerioBudgetSDK finerioBudgetSDK = FinerioBudgetSDK.Companion.getShared();
        finerioBudgetSDK.configure(this);

        final Palette palette = new Palette();
        finerioBudgetSDK.setPalette(palette);

        List<FCCategory> categories = getIntent().getParcelableArrayListExtra(CATEGORY_KEY);
        mBinding.categoryView.setUpView(categories, FCCategoryType.SHOW_ALL_MULTI_SELECTION, null);
        mBinding.categoryView.setListener((OnFCCategoriesListener) category -> {
            // Next steps
        });
    }
}