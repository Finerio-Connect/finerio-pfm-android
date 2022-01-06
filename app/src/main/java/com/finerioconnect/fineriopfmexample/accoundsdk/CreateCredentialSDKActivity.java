package com.finerioconnect.fineriopfmexample.accoundsdk;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.account.ui.FCBankFieldsView;
import com.finerioconnect.sdk.account.ui.listeners.OnBankFieldsViewListener;
import com.finerioconnect.fineriopfmexample.databinding.ActivityCreateCredentialBinding;
import com.finerioconnect.sdk.models.FCBank;
import com.finerioconnect.sdk.models.FCBankField;
import com.finerioconnect.sdk.models.FCCredentialBankField;
import com.finerioconnect.sdk.shared.enums.FCFieldType;

import java.util.ArrayList;
import java.util.List;

public class CreateCredentialSDKActivity extends AppCompatActivity implements OnBankFieldsViewListener {

    public static final String BANK_INSTANCE_KEY = "bankInstanceKey";

    private ActivityCreateCredentialBinding mBinding;

    private FCBank mBank;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCreateCredentialBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBank = getIntent().getParcelableExtra(BANK_INSTANCE_KEY);
        if(mBank == null){
            return;
        }
        setup();
    }

    private void setup(){
        final FCBankFieldsView fcBankFieldsView = mBinding.fcBankFieldsView;
        fcBankFieldsView.setListener(this);
        fcBankFieldsView.setFragmentActivity(this);

        final List<FCBankField> bankFields = new ArrayList<>();

        if(mBank.getId().equals("2")){
            bankFields.add(new FCBankField("username", "Número de cliente", 1, FCFieldType.USERNAME,  false, mBank.getId(), null));
            bankFields.add(new FCBankField("password", "Clave de BancaNet", 1, FCFieldType.PASSWORD, false, mBank.getId(), null));
        } else if(mBank.getId().equals("9")){
            bankFields.add(new FCBankField("username", "Usuario", 1, FCFieldType.USERNAME,  false, mBank.getId(), null));
            bankFields.add(new FCBankField("password", "Contraseña Amex", 1, FCFieldType.PASSWORD, false, mBank.getId(), null));
        } else {
            bankFields.add(new FCBankField("username", "Usuario", 1, FCFieldType.USERNAME,  false, mBank.getId(), null));
            bankFields.add(new FCBankField("password", "Contraseña", 1, FCFieldType.PASSWORD, false, mBank.getId(), null));
            bankFields.add(new FCBankField("securityCode", "Código de seguridad", 1, FCFieldType.SECURITY_CODE_FINERIO, false, mBank.getId(), null));
        }

        fcBankFieldsView.setBankFields(bankFields, true);
    }

    @Override
    public void didActionButton(@NonNull final FCCredentialBankField credentialFields) {
        Toast.makeText(this, "Create credential", Toast.LENGTH_SHORT).show();
    }

}
