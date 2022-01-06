package com.finerioconnect.fineriopfmexample.transactionsdk;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.fineriopfmexample.databinding.ActivityTransactionSdkBinding;
import com.finerioconnect.sdk.models.FCAccount;
import com.finerioconnect.sdk.models.FCBank;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.models.FCCredential;
import com.finerioconnect.sdk.models.FCImage;
import com.finerioconnect.sdk.models.FCTransaction;
import com.finerioconnect.sdk.shared.enums.FCBankStatus;
import com.finerioconnect.sdk.shared.enums.FCCredentialStatus;
import com.finerioconnect.sdk.transaction.core.FinerioTransactionSDK;
import com.finerioconnect.sdk.transaction.ui.FCTransactionListView;
import com.finerioconnect.sdk.transaction.ui.listeners.OnFCTransactionListListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionSDKActivity extends AppCompatActivity implements OnFCTransactionListListener {

    private ActivityTransactionSdkBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityTransactionSdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        setup();
    }

    private void setup() {
        final FinerioTransactionSDK finerioTransactionSDK = FinerioTransactionSDK.Companion.getShared();
        finerioTransactionSDK.setCredentials(getCredentials());
        finerioTransactionSDK.setCategories(getCategories());
        finerioTransactionSDK.configure(this);

        final FCTransactionListView fcTransactionListView = mBinding.fcTransactionListView;
        fcTransactionListView.setListener(this);
        fcTransactionListView.setFragmentActivity(this);
        fcTransactionListView.setTransactions(getTransactions());

        mBinding.fabCreateTransaction.setOnClickListener(view -> goDetail(null));
    }

    @Override
    public void didSelectedTransaction(@NonNull final FCTransaction transaction) {
        goDetail(transaction);
    }

    private void goDetail(final FCTransaction transaction) {
        final Intent intent = new Intent(this, TransactionDetailSDKActivity.class);
        if (transaction != null) {
            intent.putExtra(TransactionDetailSDKActivity.TRANSACTION_DETAIL_KEY, transaction);
        }
        startActivity(intent);
    }

    private List<FCTransaction> getTransactions() {
        final List<FCTransaction> fcTransactions = new ArrayList<>();
        final Date date1 = new Date(1632200400000L);
        fcTransactions.add(new FCTransaction(
                "912fa2db-870b-484d-a190-e95b7d5a1cb3", date1, "Nuevo Mov 1", "Nuevo Mov 1", 2000, false, "ff41986b-89e3-48a0-aecd-02b19497e2c1", true,
                new FCBank("121", "DINERIO", "", new FCImage("debit_manual_account", -16098023), FCBankStatus.ACTIVE),
                new FCCategory("00000000-0000-0000-0000-00000000000e", "Despensa", "#FECF58", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null), null, null, null)));

        final Date date2 = new Date(1632114000000L);
        fcTransactions.add(new FCTransaction(
                "67ebe3d8-69d5-475a-bad2-e91cdf4ac38b", date2, "nuevo mov 2", "nuevo mov 2", -3500.0, false, "ff41986b-89e3-48a0-aecd-02b19497e2c1", null,
                new FCBank("121", "DINERIO", "", new FCImage("personalcredit_manual_account", -16098023), FCBankStatus.ACTIVE),
                new FCCategory("00000000-0000-0000-0000-000000000035", "Servicios Legales", "#BE5586", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000007", null), null, null, null)));

        final Date date3 = new Date(1631422800000L);
        fcTransactions.add(new FCTransaction(
                "12ed0bc4-4697-46ae-9d2f-e654e83cfa4f", date3, "SPEI ENVIADO STP/ 0074054298  646 1209210PAGO TC", "CARGO TRANSFERENCIA SPEI", -300.0, false, "8e92ae16-5298-430e-9e71-65b56001a26a", null,
                new FCBank("", "BBVA", "", new FCImage("https://cdn.finerio.mx/widget/bank_BBVA_shield.png", null), FCBankStatus.ACTIVE),
                new FCCategory("00000000-0000-0000-0000-000000000049", "Transferencias", "#865DDA", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000047", null), null, null, null)));

        final Date date4 = new Date(1631422800000L);
        fcTransactions.add(new FCTransaction(
                "a88f7d52-60ec-48fb-8e0f-b3768af56d84", date4, "PAYPAL3                    CR", "3        CR", -9.0, true, "8e92ae16-5298-430e-9e71-65b56001a26a", null,
                new FCBank("", "BBVA", "", new FCImage("https://cdn.finerio.mx/widget/bank_BBVA_shield.png", null), FCBankStatus.ACTIVE),
                new FCCategory("00000000-0000-0000-0000-00000000000e", "Despensa", "#FECF58", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null), null, null, null)));
        return fcTransactions;
    }

    private List<FCCredential> getCredentials() {
        final List<FCCredential> fcCredentialList = new ArrayList<>();

        final List<FCAccount> fcAccountList1 = new ArrayList<>();
        //accounts
        final FCAccount fcAccount1 = new FCAccount("550d1b99-599b-42dc-8958-5b1e1599075a", "Apartado", "Ahorros", 35000.0, null);
        final FCAccount fcAccount2 = new FCAccount("8e92ae16-5298-430e-9e71-65b56001a26a", "Cuenta en Pesos", "Cheques", 1436.47, null);
        fcAccountList1.add(fcAccount1);
        fcAccountList1.add(fcAccount2);
        //Credential 1
        final FCCredential credential1 = new FCCredential("dad8f8b2-7332-4327-9674-aa18593eea4e", "BBVA", 0.0, "4152313406096268", FCCredentialStatus.INVALID, "", "BBVA", new FCImage("https://cdn.finerio.mx/widget/bank_BBVA_shield.png", null), fcAccountList1);

        final List<FCAccount> fcAccountList2 = new ArrayList<>();
        //accounts
        final FCAccount fcAccount11 = new FCAccount("373de1e4-b627-45a2-a0ef-e12871672076", "Prueba", "ma_cash", 3600.0, null);
        fcAccountList2.add(fcAccount11);
        //Credential 2
        final FCCredential credential2 = new FCCredential("373de1e4-b627-45a2-a0ef-e12871672076", "Prueba", 3600.0, null, FCCredentialStatus.ACTIVE, "", "DINERIO", new FCImage("cash_manual_account", -16098023), fcAccountList2);

        final List<FCAccount> fcAccountList3 = new ArrayList<>();
        //accounts
        final FCAccount fcAccount111 = new FCAccount("ff41986b-89e3-48a0-aecd-02b19497e2c1", "Prueba 2", "ma_cash", 555.0, null);
        fcAccountList3.add(fcAccount111);
        //Credential 2
        final FCCredential credential3 = new FCCredential("ff41986b-89e3-48a0-aecd-02b19497e2c1", "Prueba 2", 555.0, null, FCCredentialStatus.ACTIVE, "", "DINERIO", new FCImage("cash_manual_account", -16098023), fcAccountList3);

        fcCredentialList.add(credential1);
        fcCredentialList.add(credential2);
        fcCredentialList.add(credential3);

        return fcCredentialList;
    }

    private List<FCCategory> getCategories() {
        final List<FCCategory> categories = new ArrayList<>();
        final List<FCCategory> subCategories = new ArrayList<>();
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000011", "Construción y Remodelación", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000012", "Artículos para el Hogar", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000013", "Mascotas", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000014", "Limpieza y Mantenimiento", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000015", "Muebles y Aparatos Eléctricos", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000016", "Renta y Compra", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000017", "Servicios y Públicos", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000018", "Teléfono y Celular", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        subCategories.add(new FCCategory("00000000-0000-0000-0000-000000000019", "Otros Hogar", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, null, "00000000-0000-0000-0000-000000000001"));
        categories.add(new FCCategory("00000000-0000-0000-0000-000000000001", "Hogar", "#A3CB38", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000001", null), null, subCategories, null));
        // Ingresos
        final List<FCCategory> subCategories1 = new ArrayList<>();
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000051", "Préstamos", "#22C9FD", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, null, "00000000-0000-0000-0000-000000000050"));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000052", "Bonos", "#26CCFD", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, null, "00000000-0000-0000-0000-000000000050"));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000053", "Sueldo", "#40D2FE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, null, "00000000-0000-0000-0000-000000000050"));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000054", "Rentas", "#4DD5FE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, null, "00000000-0000-0000-0000-000000000050"));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000055", "Inversiones", "#59D8FE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, null, "00000000-0000-0000-0000-000000000050"));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-000000000056", "Otros ingresos", "#66DBFE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, null, "00000000-0000-0000-0000-000000000050"));
        subCategories1.add(new FCCategory("00000000-0000-0000-0000-00000000005b", "Reembolsos y Devoluciones", "#33CFFD", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, null, "00000000-0000-0000-0000-000000000050"));
        categories.add(new FCCategory("00000000-0000-0000-0000-000000000050", "Ingresos", "#099FE2", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000050", null), null, subCategories1, null));
        // Alimentos
        final List<FCCategory> subCategories2 = new ArrayList<>();
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-00000000000e", "Despensa", "#FECF58", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null), null, null, "00000000-0000-0000-0000-000000000002"));
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-000000000040", "Restaurante", "#FED261", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null), null, null, "00000000-0000-0000-0000-000000000002"));
        subCategories2.add(new FCCategory("00000000-0000-0000-0000-000000000058", "Otros Alimentos", "#FED56B", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null), null, null, "00000000-0000-0000-0000-000000000002"));
        categories.add(new FCCategory("00000000-0000-0000-0000-000000000002", "Alimentos", "#FECA46", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_000000000002", null), null, subCategories2, null));
        // Finanzas
        final List<FCCategory> subCategories3 = new ArrayList<>();
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-00000000002f", "Servicios Financieros", "#A395EB", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null), null, null, "00000000-0000-0000-0000-00000000000b"));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000030", "Ahorro e Inversiones", "#AFA2EE", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null), null, null, "00000000-0000-0000-0000-00000000000b"));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000031", "Créditos", "#A99BEC", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null), null, null, "00000000-0000-0000-0000-00000000000b"));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000032", "Seguros y Fianzas", "#9888E9", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null), null, null, "00000000-0000-0000-0000-00000000000b"));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-000000000045", "Impuestos", "#9D8EEA", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null), null, null, "00000000-0000-0000-0000-00000000000b"));
        subCategories3.add(new FCCategory("00000000-0000-0000-0000-00000000004a", "Otros Finanzas e Impuestos", "#B4A8EF", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null), null, null, "00000000-0000-0000-0000-00000000000b"));
        categories.add(new FCCategory("00000000-0000-0000-0000-00000000000b", "Finanzas e Impuestos", "#8C7AE6", "#FFFFFF", new FCImage("a_00000000_0000_0000_0000_00000000000b", null), null, subCategories3, null));
        return categories;
    }

}
