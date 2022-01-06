package com.finerioconnect.fineriopfmexample.budgetssdk;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK;
import com.finerioconnect.sdk.budget.core.Palette;
import com.finerioconnect.fineriopfmexample.databinding.ActivityBudgetsDetailSdkBinding;
import com.finerioconnect.sdk.models.FCBudget;

public class BudgetsDetailSDKActivity extends AppCompatActivity {
    private static final String BUDGET_KEY = "budgetKey";
    private static final String CATEGORY_ID_KEY = "categoryId";

    private ActivityBudgetsDetailSdkBinding binding;
    private FCBudget budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBudgetsDetailSdkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.editBudgetButton.setOnClickListener((view) -> {
            final Intent intent = new Intent(this, BudgetsCreateSDKActivity.class);
            intent.putExtra(BUDGET_KEY, budget);
            intent.putExtra(CATEGORY_ID_KEY, budget.getCategoryId());
            startActivity(intent);
        });

        setUp();
    }

    private void setUp() {
        final FinerioBudgetSDK finerioBudgetSDK = FinerioBudgetSDK.Companion.getShared();

        final Palette palette = new Palette();
        finerioBudgetSDK.setPalette(palette);

        this.budget = getIntent().getParcelableExtra(BUDGET_KEY);
        binding.budgetView.setBudgets(budget, budget.getSubBudgets());
    }
}