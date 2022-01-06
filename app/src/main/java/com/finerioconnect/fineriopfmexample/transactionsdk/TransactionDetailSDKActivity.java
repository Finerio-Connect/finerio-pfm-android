package com.finerioconnect.fineriopfmexample.transactionsdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.finerioconnect.fineriopfmexample.R;
import com.finerioconnect.fineriopfmexample.databinding.ActivityTransactionDetailSdkBinding;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.models.FCImage;
import com.finerioconnect.sdk.models.FCTransaction;
import com.finerioconnect.sdk.transaction.ui.FCTransactionDetailView;
import com.finerioconnect.sdk.transaction.ui.listeners.OnFCTransactionDetailListener;

import java.util.Date;

public class TransactionDetailSDKActivity extends AppCompatActivity implements OnFCTransactionDetailListener {

    public static final String TRANSACTION_DETAIL_KEY = "transactionDetailKey";

    private ActivityTransactionDetailSdkBinding mBinding;

    private FCTransaction fcTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityTransactionDetailSdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        fcTransaction = getIntent().getParcelableExtra(TRANSACTION_DETAIL_KEY);

        setup();
    }

    private void setup(){
        final FCTransactionDetailView fcTransactionDetailView = mBinding.fcTransactionDetailView;
        fcTransactionDetailView.setListener(this);
        fcTransactionDetailView.setFragmentActivity(this);
        if(fcTransaction != null){
            fcTransactionDetailView.setTransaction(fcTransaction);
        }
    }

    @Override
    public void didDescriptionChanged(@NonNull final String description, final boolean isIncome) {
        mBinding.fcTransactionDetailView.showCategoryProgress("Cargando...");
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            mBinding.fcTransactionDetailView.setCategory(getCategory());
        }, 2000);
    }

    @Override
    public void didCreateTransaction(@NonNull final FCTransaction transaction) {

    }

    @Override
    public void didAccountChanged(@NonNull final String accountId) {

    }

    @Override
    public void didCategoryChanged(@NonNull final String categoryId) {

    }

    @Override
    public void didDateChanged(@NonNull final Date date) {

    }

    @Override
    public void didTransactionTypeChanged(final boolean isIncome) {

    }

    private FCCategory getCategory() {
        return new FCCategory("", "TEST", "#ff0084DD", "#FFFFFF",
                new FCImage("user_category", ContextCompat.getColor(this, R.color.colorWhite)), null, null, null);
    }

}
