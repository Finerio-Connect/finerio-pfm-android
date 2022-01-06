package com.finerioconnect.fineriopfmexample.accoundsdk;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.fineriopfmexample.databinding.ActivityBanksBinding;
import com.finerioconnect.sdk.account.ui.listeners.OnFCBanksViewListener;
import com.finerioconnect.sdk.models.FCBank;
import com.finerioconnect.sdk.models.FCImage;
import com.finerioconnect.sdk.shared.enums.FCBankStatus;

import java.util.ArrayList;
import java.util.List;

public class BanksSDKActivity extends AppCompatActivity implements OnFCBanksViewListener {

    private ActivityBanksBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBanksBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.fcBanksView.setListener(this);
        setup();
    }

    private void setup() {
        final List<FCBank> fcBanks = new ArrayList<>();

        fcBanks.add(new FCBank("1","BBVA","BBVA Bancomer", new FCImage("https://cdn.finerio.mx/widget/bank_1_on.png", null), FCBankStatus.ACTIVE));
        fcBanks.add(new FCBank("2","BNMX","Citibanamex", new FCImage("https://cdn.finerio.mx/widget/bank_2_on.png", null), FCBankStatus.ACTIVE));
        fcBanks.add(new FCBank("7","SANTANDER","Santander", new FCImage("https://cdn.finerio.mx/widget/bank_7_on.png", null), FCBankStatus.ACTIVE));
        fcBanks.add(new FCBank("9","AMEX","American Express", new FCImage("https://cdn.finerio.mx/widget/bank_9_on.png", null), FCBankStatus.ACTIVE));
        fcBanks.add(new FCBank("11","SCOTIA","Scotiabank", new FCImage("https://cdn.finerio.mx/widget/bank_11_on.png", null), FCBankStatus.ACTIVE));
        fcBanks.add(new FCBank("14","BAZ","Banco Azteca", new FCImage("https://cdn.finerio.mx/widget/bank_14_on.png", null), FCBankStatus.ACTIVE));
        fcBanks.add(new FCBank("15","LIVERPOOL","Liverpool", new FCImage("https://cdn.finerio.mx/widget/bank_15_on.png", null), FCBankStatus.ACTIVE));

        mBinding.fcBanksView.setBanks(fcBanks);
    }

    @Override
    public void didSelectedBank(@NonNull final FCBank bank) {
        final Intent intent = new Intent(this, CreateCredentialSDKActivity.class);
        intent.putExtra(CreateCredentialSDKActivity.BANK_INSTANCE_KEY, bank);
        startActivity(intent);
    }

}
