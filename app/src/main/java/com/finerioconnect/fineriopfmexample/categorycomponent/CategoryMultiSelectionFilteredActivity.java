package com.finerioconnect.fineriopfmexample.categorycomponent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.budget.core.FinerioBudgetSDK;
import com.finerioconnect.sdk.budget.core.Palette;
import com.finerioconnect.fineriopfmexample.databinding.ActivityCategoryMultiSelectionFilteredBinding;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.shared.enums.FCCategoryType;
import com.finerioconnect.sdk.ui.listeners.OnFCCategoriesListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryMultiSelectionFilteredActivity extends AppCompatActivity {
    private ActivityCategoryMultiSelectionFilteredBinding mBinding;

    private static final String CATEGORY_KEY = "CATEGORY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCategoryMultiSelectionFilteredBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setUp();
    }

    private void setUp() {
        final FinerioBudgetSDK finerioBudgetSDK = FinerioBudgetSDK.Companion.getShared();
        finerioBudgetSDK.configure(this);

        final Palette palette = new Palette();
        finerioBudgetSDK.setPalette(palette);

        List<FCCategory> categoriesFiltered = new ArrayList<>();
        List<FCCategory> subCategories = new ArrayList<>();
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000011", "Construción y Remodelación","#A3CB38", "#FFFFFF",null, null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000012", "Artículos para el Hogar","#A3CB38", "#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000013", "Mascotas","#A3CB38","#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000014", "Limpieza y Mantenimiento","#A3CB38", "#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000015", "Muebles y Aparatos Eléctricos","#A3CB38", "#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000016", "Renta y Compra","#A3CB38", "#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000017", "Servicios y Públicos","#A3CB38", "#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000018", "Teléfono y Celular","#A3CB38", "#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000019", "Otros Hogar","#A3CB38", "#FFFFFF",null,null, null, "00000000-0000-0000-0000-000000000001"));
        categoriesFiltered.add(new FCCategory("00000000-0000-0000-0000-000000000001", "Hogar","#A3CB38", "#FFFFFF",null,null, subCategories, null));

        List<FCCategory> subCategories2 = new ArrayList<>();
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-00000000000e", "Despensa","#FECF58", "#FFFFFF",null,null, null, null));
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-000000000058", "Otros Alimentos", "#FED56B", "#FFFFFF",null,null, null, null));
        categoriesFiltered.add(new FCCategory("00000000-0000-0000-0000-000000000002", "Alimentos","#FECA46", "#FFFFFF",null,null, subCategories2, null));

        categoriesFiltered.add(new FCCategory("00000000-0000-0000-0000-000000000050", "Ingresos","#099FE2", "#FFFFFF",null,null, null, null));

        List<FCCategory> categories = getIntent().getParcelableArrayListExtra(CATEGORY_KEY);
        mBinding.categoryView.setUpView(categories, FCCategoryType.SHOW_ALL_MULTI_SELECTION, categoriesFiltered);
        mBinding.categoryView.setListener((OnFCCategoriesListener) category -> {
            // Next steps
        });
    }
}