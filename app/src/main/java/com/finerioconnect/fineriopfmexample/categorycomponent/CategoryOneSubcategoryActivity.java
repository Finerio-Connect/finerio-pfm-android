package com.finerioconnect.fineriopfmexample.categorycomponent;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK;
import com.finerioconnect.sdk.budget.core.Palette;
import com.finerioconnect.fineriopfmexample.databinding.ActivityCategoryOneSubcategoryBinding;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.shared.enums.FCCategoryType;
import com.finerioconnect.sdk.ui.listeners.OnFCSubcategoryListener;

import java.util.List;

public class CategoryOneSubcategoryActivity extends AppCompatActivity {
    private ActivityCategoryOneSubcategoryBinding mBinding;

    private static final String CATEGORY_KEY = "CATEGORY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCategoryOneSubcategoryBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setUp();
    }

    private void setUp() {
        final FinerioBudgetSDK finerioBudgetSDK = FinerioBudgetSDK.Companion.getShared();
        finerioBudgetSDK.configure(this);

        final Palette palette = new Palette();
        finerioBudgetSDK.setPalette(palette);

        mBinding.categoryView.setListener((OnFCSubcategoryListener) subcategory -> {
            if (subcategory != null) {
                Toast.makeText(this, "Sub-category: " + subcategory.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        List<FCCategory> categories = getIntent().getParcelableArrayListExtra(CATEGORY_KEY);
        mBinding.categoryView.setUpView(categories, FCCategoryType.SHOW_ALL_ONLY_ONE_SUBCATEGORY, null);
    }
}