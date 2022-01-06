package com.finerioconnect.fineriopfmexample.analysissdk;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.analysis.core.FinerioAnalysisSDK;
import com.finerioconnect.sdk.analysis.models.FCAnalysis;
import com.finerioconnect.sdk.analysis.ui.FCAnalysisView;
import com.finerioconnect.sdk.analysis.ui.listeners.OnFCAnalysisClickListener;
import com.finerioconnect.fineriopfmexample.databinding.ActivityAnalysisSdkBinding;
import com.finerioconnect.sdk.models.FCAnalysisCategory;
import com.finerioconnect.sdk.models.FCAnalysisSubCategory;
import com.finerioconnect.sdk.models.FCAnalysisTransaction;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.models.FCImage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnalysisSDKActivity extends AppCompatActivity implements OnFCAnalysisClickListener {

    private ActivityAnalysisSdkBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityAnalysisSdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setup();
    }

    private void setup() {
        FinerioAnalysisSDK.Companion.getShared().configure(this);

        final FCAnalysisView fcAnalysisView = mBinding.fcAnalysisView;
        fcAnalysisView.setListener(this);
        fcAnalysisView.setAnalysis(getAnalysis());
    }

    private List<FCAnalysis> getAnalysis() {
        final List<FCAnalysis> analysisList = new ArrayList<>();

        final Date date1 = new Date(1630472400000L);
        final List<FCAnalysisCategory> fcAnalysisCategoryList1 = new ArrayList<>();
        //First Section
        //First Item
        final List<FCAnalysisSubCategory> fcAnalysisSubCategoryList1 = new ArrayList<>();
        final List<FCAnalysisTransaction> fcAnalysisTransactionList1 = new ArrayList<>();
        //Transactions
        fcAnalysisTransactionList1.add(new FCAnalysisTransaction("CARGO TRANSFERENCIA SPEI", new BigDecimal("1644.08"), 3, new BigDecimal("4932.23")));
        fcAnalysisTransactionList1.add(new FCAnalysisTransaction("PAGO CUENTA TERCERO 1560661386 BNET  1575320863 REGALO", new BigDecimal("4000.0"), 1, new BigDecimal("4000.0")));
        //Sub categories
        fcAnalysisSubCategoryList1.add(new FCAnalysisSubCategory(new FCCategory("00000000-0000-0000-0000-000000000049","Transferencias","#865DDA","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000049", -7971366), null, new ArrayList<>(), null), new BigDecimal("2233.06"), 4, new BigDecimal("8932.23"), fcAnalysisTransactionList1));
        //Category
        final FCCategory fcCategory1 = new FCCategory("00000000-0000-0000-0000-000000000047","Transacciones Bancarias","#5F27CD","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000047", -10541107), null, new ArrayList<>(), null);

        //Second item
        final List<FCAnalysisSubCategory> fcAnalysisSubCategoryList2 = new ArrayList<>();
        final List<FCAnalysisTransaction> fcAnalysisTransactionList2 = new ArrayList<>();
        final List<FCAnalysisTransaction> fcAnalysisTransactionList3 = new ArrayList<>();
        //Transactions
        fcAnalysisTransactionList2.add(new FCAnalysisTransaction("NUEVO MOV", new BigDecimal("3500.0"), 1, new BigDecimal("3500.0")));
        fcAnalysisTransactionList3.add(new FCAnalysisTransaction("AMAZON", new BigDecimal("711.06"), 1, new BigDecimal("711.06")));
        //Sub categories
        fcAnalysisSubCategoryList2.add(new FCAnalysisSubCategory(new FCCategory("00000000-0000-0000-0000-000000000035","Servicios Legales","#BE5586","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000035", -4303482), null, new ArrayList<>(), null), new BigDecimal("3500.0"), 1, new BigDecimal("3500.0"), fcAnalysisTransactionList2));
        fcAnalysisSubCategoryList2.add(new FCAnalysisSubCategory(new FCCategory("00000000-0000-0000-0000-00000000001d","Libros","#D187AA","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000001d", -3045462), null, new ArrayList<>(), null), new BigDecimal("711.06"), 1, new BigDecimal("711.06"), fcAnalysisTransactionList3));
        //Category
        final FCCategory fcCategory2 = new FCCategory("00000000-0000-0000-0000-000000000007","Educación y Trabajo","#B33771","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000007", -5032079), null, new ArrayList<>(), null);

        fcAnalysisCategoryList1.add(new FCAnalysisCategory(fcCategory1, new BigDecimal("8932.23"), fcAnalysisSubCategoryList1));
        fcAnalysisCategoryList1.add(new FCAnalysisCategory(fcCategory2, new BigDecimal("4211.06"), fcAnalysisSubCategoryList2));
        analysisList.add(new FCAnalysis(date1, fcAnalysisCategoryList1));


        final Date date2 = new Date(1627794000000L);
        final List<FCAnalysisCategory> fcAnalysisCategoryList2 = new ArrayList<>();
        //Second Section
        //First item
        final List<FCAnalysisSubCategory> fcAnalysisSubCategoryList11 = new ArrayList<>();
        final List<FCAnalysisTransaction> fcAnalysisTransactionList11 = new ArrayList<>();
        //Transactions
        fcAnalysisTransactionList11.add(new FCAnalysisTransaction("MOVIMIENTO DE PRUEBA 21", new BigDecimal("20000.0"), 1, new BigDecimal("20000.0")));
        //Sub categories
        fcAnalysisSubCategoryList11.add(new FCAnalysisSubCategory(new FCCategory("00000000-0000-0000-0000-00000000003c","Donaciones","#F477E3","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000003c", -755741), null, new ArrayList<>(), null), new BigDecimal("20000.0"), 1, new BigDecimal("20000.0"), fcAnalysisTransactionList11));
        //Category
        final FCCategory fcCategory11 = new FCCategory("00000000-0000-0000-0000-000000000008","Regalos y Ayuda","#F368E0","#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000008", -825120), null, new ArrayList<>(), null);

        fcAnalysisCategoryList2.add(new FCAnalysisCategory(fcCategory11, new BigDecimal("20000.0"), fcAnalysisSubCategoryList11));
        analysisList.add(new FCAnalysis(date2, fcAnalysisCategoryList2));
        return analysisList;
    }

    @Override
    public void didSelectedAnalysis(@NonNull final FCAnalysisCategory fcAnalysisCategory) {
        final Intent intent = new Intent(this, AnalysisDetailSDKActivity.class);
        intent.putExtra(AnalysisDetailSDKActivity.ANALYSIS_DETAIL_KEY, fcAnalysisCategory);
        startActivity(intent);
    }

}
