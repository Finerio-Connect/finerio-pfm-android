package com.finerioconnect.fineriopfmexample.accoundsdk;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.fineriopfmexample.databinding.ActivityAccountDetailSdkBinding;
import com.finerioconnect.sdk.account.ui.listeners.OnFCAccountsDetailViewListener;
import com.finerioconnect.sdk.extensions.StringExtensionsKt;
import com.finerioconnect.sdk.models.FCAccount;
import com.finerioconnect.sdk.models.FCAccountDetail;
import com.finerioconnect.sdk.models.FCBankField;
import com.finerioconnect.sdk.models.FCCredential;
import com.finerioconnect.sdk.shared.enums.FCFieldType;

import java.util.ArrayList;
import java.util.List;

public class AccountDetailSDKActivity extends AppCompatActivity implements OnFCAccountsDetailViewListener {

    public static String CREDENTIAL_KEY = "credentialKey";

    private ActivityAccountDetailSdkBinding mBinding;

    private FCCredential mCredential;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityAccountDetailSdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mCredential = getIntent().getParcelableExtra(CREDENTIAL_KEY);
        if(mCredential != null) {
            setup();
        }
    }

    private void setup() {
        mBinding.accountsDetailView.setListener(this);
        mBinding.accountsDetailView.setFragmentActivity(this);

        final List<FCBankField> fcBankFields = new ArrayList<>();
        String friendlyName = "";
        if(mCredential.getAccounts() != null && !mCredential.getAccounts().isEmpty()) {
            final String bankId = mCredential.getAccounts().get(0).getBank().getId();
            final FCBankField fcBankFieldPassword = new FCBankField("Contraseña", bankId.equals("2") ? "Clave de BancaNet" : "Contraseña Amex", 1, FCFieldType.PASSWORD, false, bankId.equals("2") ? "2" : "9", null);
            fcBankFields.add(fcBankFieldPassword);
            friendlyName = fcBankFields.get(0).getFriendlyName();
        }
        final FCAccountDetail accountDetail = new FCAccountDetail(friendlyName, StringExtensionsKt.safe(mCredential.getUser()), mCredential, fcBankFields);
        mBinding.accountsDetailView.setAccountsDetail(accountDetail);
    }

    @Override
    public void didSelectedDeleteAccount(@NonNull FCAccount account) {
        mBinding.accountsDetailView.deleteAccount(account);
        Toast.makeText(this, "Borrar cuenta: " + account.getName(), Toast.LENGTH_SHORT).show();
    }

}
