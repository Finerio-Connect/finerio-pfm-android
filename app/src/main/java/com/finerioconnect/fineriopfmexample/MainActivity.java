package com.finerioconnect.fineriopfmexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.finerioconnect.fineriopfmexample.accoundsdk.AccountSDKActivity;
import com.finerioconnect.fineriopfmexample.analysissdk.AnalysisSDKActivity;
import com.finerioconnect.fineriopfmexample.budgetssdk.BudgetsSDKActivity;
import com.finerioconnect.fineriopfmexample.databinding.ActivityMainBinding;
import com.finerioconnect.fineriopfmexample.summarysdk.SummarySDKActivity;
import com.finerioconnect.fineriopfmexample.transactionsdk.TransactionSDKActivity;
import com.finerioconnect.sdk.core.FinerioConnectSDK;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        initViews();
    }

    private void initViews() {
        final FinerioConnectSDK finerioConnectSDK = FinerioConnectSDK.Companion.getShared();
        finerioConnectSDK.setApiKey("api_key");
        finerioConnectSDK.configure();

        mBinding.btGoSummarySDK.setOnClickListener(view -> goNextClass(SummarySDKActivity.class));
        mBinding.btGoTransactionSDK.setOnClickListener(view -> goNextClass(TransactionSDKActivity.class));
        mBinding.btGoAnalysisSDK.setOnClickListener(view -> goNextClass(AnalysisSDKActivity.class));
        mBinding.btGoAccountSDK.setOnClickListener(view -> goNextClass(AccountSDKActivity.class));
        mBinding.btGoBudgetsSDK.setOnClickListener(view -> goNextClass(BudgetsSDKActivity.class));
    }

    @SuppressWarnings("rawtypes")
    private void goNextClass(final Class _class) {
        final Intent intent = new Intent(this, _class);
        startActivity(intent);
    }

}