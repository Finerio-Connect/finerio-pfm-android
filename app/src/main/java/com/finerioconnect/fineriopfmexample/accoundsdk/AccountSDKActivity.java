package com.finerioconnect.fineriopfmexample.accoundsdk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.finerioconnect.fineriopfmexample.R;
import com.finerioconnect.fineriopfmexample.databinding.ActivityAccountSdkBinding;
import com.finerioconnect.sdk.account.core.FinerioAccountSDK;
import com.finerioconnect.sdk.account.ui.listeners.OnFCAccountBalanceListener;
import com.finerioconnect.sdk.models.FCAccount;
import com.finerioconnect.sdk.models.FCAccountBalance;
import com.finerioconnect.sdk.models.FCBank;
import com.finerioconnect.sdk.models.FCCredential;
import com.finerioconnect.sdk.models.FCImage;
import com.finerioconnect.sdk.shared.enums.FCBankStatus;
import com.finerioconnect.sdk.shared.enums.FCCredentialStatus;

import java.util.ArrayList;
import java.util.List;

public class AccountSDKActivity extends AppCompatActivity implements OnFCAccountBalanceListener {

    private ActivityAccountSdkBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityAccountSdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.accountBalanceView.setListener(this);
        setup();

        mBinding.fabGoBanks.setOnClickListener((view) ->
                startActivity(new Intent(this, BanksSDKActivity.class)));
    }

    private void setup() {
        final FinerioAccountSDK finerioAccountSDK = FinerioAccountSDK.Companion.getShared();
        finerioAccountSDK.configure(this);

        mBinding.accountBalanceView.setVisibility(View.VISIBLE);

        final List<FCCredential> credentials = new ArrayList<>();

        // Citi Account
        final List<FCAccount> accountsCiti = new ArrayList<>();
        accountsCiti.add(new FCAccount("ID001", "Cuenta Perfiles", "Cheques", 1200.00, new FCBank("2", "", "", null, FCBankStatus.ACTIVE)));
        accountsCiti.add(new FCAccount("ID002", "AHORRO FACIL", "Inversión", 55.30, new FCBank("2", "", "", null, FCBankStatus.ACTIVE)));
        final FCImage fcImageCiti = new FCImage("https://cdn.finerio.mx/widget/bank_2_shield.png", null);
        final FCCredential fcCredentialCiti = new FCCredential("CR01", "Citibanamex", 1255.30, "anakin", FCCredentialStatus.ACTIVE, "Actualizada: Hoy, 08:00", "Citibanamex", fcImageCiti, accountsCiti);
        credentials.add(fcCredentialCiti);

        // BBVA Account
        final List<FCAccount> accountsBBVA = new ArrayList<>();
        accountsBBVA.add(new FCAccount("e7d13efb-3913-4dec-9292-043f5800cbe3", "Cuenta en Pesos", "Cheques", 1890.07, new FCBank("1", "", "", null, FCBankStatus.ACTIVE)));
        final FCImage fcImageBBVA = new FCImage("https://cdn.finerio.mx/widget/bank_1_shield.png", null);
        final FCCredential fcCredentialBBVA = new FCCredential("b3b43f6e-8bfe-41a9-bb82-6ced4df6a297", "BBVA Bancomer", null, "Leia", FCCredentialStatus.ACTIVE, "Actualizada: Hoy, 08:00", "BBVA" ,fcImageBBVA, accountsBBVA);
        credentials.add(fcCredentialBBVA);

        // Manual Account
        final List<FCAccount> accountsManual = new ArrayList<>();
        final FCImage fcImageManual = new FCImage("cash_manual_account", ContextCompat.getColor(this, R.color.colorManualAccountIcon));
        final FCCredential fcCredentialManual = new FCCredential("373de1e4-b627-45a2-a0ef-e12871672076", "Cuenta Manual", 0.0, "Leia", FCCredentialStatus.ACTIVE, "Actualizada: 18 agosto", "DINERIO", fcImageManual, accountsManual);
        credentials.add(fcCredentialManual);

        // Scotiabank Account
        final List<FCAccount> accountsScotiabank = new ArrayList<>();
        final FCImage fcImageScotiabank = new FCImage("https://cdn.finerio.mx/widget/bank_11_shield.png", null);
        final FCCredential fcCredentialScotiabank = new FCCredential("8bad1b91-bfd3-4642-8241-a9ca82653d92", "Scotiabank", null, "Leia", FCCredentialStatus.INVALID,"Conexión fallida", "Scotiabank", fcImageScotiabank, accountsScotiabank);
        credentials.add(fcCredentialScotiabank);

        final FCAccountBalance accountBalance = new FCAccountBalance(1890.07, -4500.56, 1890.07, 20000.0, 0, 20000.0, 21890.07, credentials);
        mBinding.accountBalanceView.setAccountBalance(accountBalance);
    }

    @Override
    public void didSelectedAccount(@NonNull FCCredential credential) {
        final Intent intent = new Intent(this, AccountDetailSDKActivity.class);
        intent.putExtra(AccountDetailSDKActivity.CREDENTIAL_KEY, credential);
        startActivity(intent);
    }

    @Override
    public void didRefreshButton(@NonNull FCCredential credential) {
        credential.setStatus(FCCredentialStatus.VALIDATE);
        credential.setLastUpdated("Actualizada: Hoy, 12:30");
        mBinding.accountBalanceView.refreshCell(credential);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            credential.setStatus(FCCredentialStatus.ACTIVE);
            credential.setLastUpdated("Actualizada: Hoy, 12:33");
            credential.setBalance(1200.2);
            mBinding.accountBalanceView.refreshCell(credential);
        }, 3000);
    }

}
