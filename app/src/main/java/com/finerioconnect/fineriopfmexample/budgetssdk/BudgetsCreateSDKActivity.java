package com.finerioconnect.fineriopfmexample.budgetssdk;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK;
import com.finerioconnect.sdk.budget.core.Palette;
import com.finerioconnect.fineriopfmexample.databinding.ActivityBudgetsCreateSdkBinding;
import com.finerioconnect.sdk.models.FCBudget;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.models.FCImage;

import java.util.ArrayList;
import java.util.List;

public class BudgetsCreateSDKActivity extends AppCompatActivity {
    private static final String BUDGET_KEY = "budgetKey";
    private static final String CATEGORY_KEY = "categoryKey";

    private ActivityBudgetsCreateSdkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBudgetsCreateSdkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUp();
    }

    private void setUp() {
        final FinerioBudgetSDK finerioBudgetSDK = FinerioBudgetSDK.Companion.getShared();

        final Palette palette = new Palette();
        finerioBudgetSDK.setPalette(palette);

        FCCategory category = getIntent().getParcelableExtra(CATEGORY_KEY);
        FCBudget budget = getIntent().getParcelableExtra(BUDGET_KEY);
        if (category == null) {
            category = getCategorySelected(budget.getCategoryId());
        }
        binding.budgetInputView.setBudgets(category, budget);
    }

    private FCCategory getCategorySelected(String categoryID) {
        List<FCCategory> categories = new ArrayList<>();
        List<FCCategory> subCategories = new ArrayList<>();
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000011", "Construción y Remodelación","#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000012", "Artículos para el Hogar","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000013", "Mascotas","#A3CB38","#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000014", "Limpieza y Mantenimiento","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000015", "Muebles y Aparatos Eléctricos","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000016", "Renta y Compra","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000017", "Servicios y Públicos","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000018", "Teléfono y Celular","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000019", "Otros Hogar","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, null, "00000000-0000-0000-0000-000000000001"));
        categories.add(new FCCategory("00000000-0000-0000-0000-000000000001", "Hogar","#A3CB38", "#FFFFFF",new FCImage("a_00000000_0000_0000_0000_000000000001", null),null, subCategories, null));
        // Ingresos
        List<FCCategory> subCategories1 = new ArrayList<>();
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000051", "Préstamos","#22C9FD", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, null, null));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000052", "Bonos","#26CCFD", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, null, null));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000053", "Sueldo","#40D2FE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, null, null));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000054", "Rentas","#4DD5FE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, null, null));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000055", "Inversiones","#59D8FE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, null, null));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000056", "Otros ingresos","#66DBFE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, null, null));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-00000000005b", "Reembolsos y Devoluciones","#33CFFD", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, null, null));
        categories.add(new FCCategory("00000000-0000-0000-0000-000000000050", "Ingresos","#099FE2", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null),null, subCategories1, null));
        // Alimentos
        List<FCCategory> subCategories2 = new ArrayList<>();
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-00000000000e", "Despensa","#FECF58", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null),null, null, null));
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-000000000040", "Restaurante","#FED261", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null),null, null, null));
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-000000000058", "Otros Alimentos", "#FED56B", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null),null, null, null));
        categories.add(new FCCategory("00000000-0000-0000-0000-000000000002", "Alimentos","#FECA46", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null),null, subCategories2, null));
        // Finanzas
        List<FCCategory> subCategories3 = new ArrayList<>();
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-00000000002f", "Servicios Financieros","#A395EB", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null),null, null, null));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000030", "Ahorro e Inversiones","#AFA2EE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null),null, null, null));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000031", "Créditos","#A99BEC", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null),null, null, null));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000032", "Seguros y Fianzas","#9888E9", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null),null, null, null));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000045", "Impuestos","#9D8EEA", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null),null, null, null));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-00000000004a", "Otros Finanzas e Impuestos","#B4A8EF", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null),null, null, null));
        categories.add(new FCCategory("00000000-0000-0000-0000-00000000000b", "Finanzas e Impuestos","#8C7AE6", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null),null, subCategories3, null));

        FCCategory categorySelected = new FCCategory();
        for (int index = 0; index < categories.size(); index++) {
            if (categories.get(index).getId().equals(categoryID)) {
                categorySelected = categories.get(index);
                break;
            }
        }

        return categorySelected;
    }
}