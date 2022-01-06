package com.finerioconnect.fineriopfmexample.budgetssdk;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK;
import com.finerioconnect.sdk.budget.core.Palette;
import com.finerioconnect.sdk.budget.ui.listeners.OnFCBudgetViewListener;
import com.finerioconnect.fineriopfmexample.databinding.ActivityBudgetsSdkBinding;
import com.finerioconnect.sdk.models.FCBudget;
import com.finerioconnect.sdk.models.FCImage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BudgetsSDKActivity extends AppCompatActivity implements OnFCBudgetViewListener {
    private static final String BUDGET_KEY = "budgetKey";
    private ActivityBudgetsSdkBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBudgetsSdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.addBudgetButton.setOnClickListener((view) -> {
            final Intent intent = new Intent(this, BudgetsCategorySDKActivity.class);
            startActivity(intent);
        });

        setup();
    }

    private void setup() {
        final FinerioBudgetSDK finerioBudgetSDK = FinerioBudgetSDK.Companion.getShared();
        finerioBudgetSDK.configure(this);

        final Palette palette = new Palette();
        finerioBudgetSDK.setPalette(palette);

        final List<FCBudget> budgets = new ArrayList<>();
        final List<FCBudget> subBudgets1 = new ArrayList<>();
        subBudgets1.add(new FCBudget("1", "Renta y Compra", "00000000-0000-0000-0000-000000000016", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
        subBudgets1.add(new FCBudget("2", "Mascotas", "00000000-0000-0000-0000-000000000013", "#A3CB38", new BigDecimal(200), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), null, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));
        budgets.add(new FCBudget("1", "Hogar", "00000000-0000-0000-0000-000000000001", "#A3CB38", new BigDecimal(400), new BigDecimal(400), new BigDecimal(0), new BigDecimal(0), new BigDecimal(100), subBudgets1, new FCImage("a_00000000_0000_0000_0000_000000000001", null)));

        budgets.add(new FCBudget("2", "Entretenimiento", "00000000-0000-0000-0000-000000000003", "#FF9F43", new BigDecimal(100), new BigDecimal(80), new BigDecimal(20), new BigDecimal(0), new BigDecimal(80),null, new FCImage("a_00000000_0000_0000_0000_000000000003", null)));

        final List<FCBudget> subBudgets2 = new ArrayList<>();
        subBudgets2.add(new FCBudget("1", "Automovil y Motocicleta", "00000000-0000-0000-0000-000000000006", "#33D9B2", new BigDecimal(100), new BigDecimal(30), new BigDecimal(70), new BigDecimal(0), new BigDecimal(10), null, new FCImage("a_00000000_0000_0000_0000_000000000006", null)));
        subBudgets2.add(new FCBudget("2", "Transporte", "00000000-0000-0000-0000-000000000006", "#33D9B2",new BigDecimal(200), new BigDecimal(0), new BigDecimal(200), new BigDecimal(0), new BigDecimal(0),null, new FCImage("a_00000000_0000_0000_0000_000000000006", null)));
        budgets.add(new FCBudget("3", "Auto y transporte", "00000000-0000-0000-0000-000000000006", "#33D9B2",new BigDecimal(300), new BigDecimal(30), new BigDecimal(270), new BigDecimal(0), new BigDecimal(10), subBudgets2, new FCImage("a_00000000_0000_0000_0000_000000000006", null)));

        final List<FCBudget> subBudgets3 = new ArrayList<>();
        subBudgets3.add(new FCBudget("1", "Vuelos", "00000000-0000-0000-0000-000000000009", "#8E44AD", new BigDecimal(5000), new BigDecimal(0), new BigDecimal(5000), new BigDecimal(0), new BigDecimal(0), null, new FCImage("a_00000000_0000_0000_0000_000000000009", null)));
        budgets.add(new FCBudget("4", "Viajes", "00000000-0000-0000-0000-000000000009", "#8E44AD", new BigDecimal(5000), new BigDecimal(0), new BigDecimal(5000), new BigDecimal(0), new BigDecimal(0), subBudgets3, new FCImage("a_00000000_0000_0000_0000_000000000009", null)));

        budgets.add(new FCBudget("5", "Ropa y Calzado", "00000000-0000-0000-0000-000000000046", "#01A3A4", new BigDecimal(1000), new BigDecimal(2000), new BigDecimal(-1000), new BigDecimal(1000), new BigDecimal(200), null, new FCImage("a_00000000_0000_0000_0000_000000000046", null)));
        mBinding.budgetView.setListener(this);
        mBinding.budgetView.setBudgets(null, budgets);
    }

    @Override
    public void didSelectedBudget(@NonNull FCBudget budget) {
        final Intent intent = new Intent(this, BudgetsDetailSDKActivity.class);
        intent.putExtra(BUDGET_KEY, budget);
        startActivity(intent);
    }
}