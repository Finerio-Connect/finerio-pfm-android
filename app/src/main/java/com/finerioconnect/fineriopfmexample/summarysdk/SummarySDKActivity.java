package com.finerioconnect.fineriopfmexample.summarysdk;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.fineriopfmexample.databinding.ActivitySummarySdkBinding;
import com.finerioconnect.sdk.models.FCCategory;
import com.finerioconnect.sdk.models.FCResume;
import com.finerioconnect.sdk.models.FCResumeTransaction;
import com.finerioconnect.sdk.shared.enums.TransactionType;
import com.finerioconnect.sdk.summary.core.FinerioSummarySDK;
import com.finerioconnect.sdk.summary.ui.SummaryView;
import com.finerioconnect.sdk.summary.ui.listeners.OnSummaryViewListener;

import java.util.ArrayList;
import java.util.List;

public class SummarySDKActivity extends AppCompatActivity implements OnSummaryViewListener {

    private ActivitySummarySdkBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySummarySdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setup();
    }

    private void setup() {
        final FinerioSummarySDK sdk = FinerioSummarySDK.Companion.getShared();
        sdk.setDateFormat("yyyy-MM");
        sdk.configure(this);

        final SummaryView sv = mBinding.summaryView;
        sv.configure(this, null);

        final List<FCResumeTransaction> list = bigList();
        sv.setListener(this);
        sv.setTransactions(list);
    }

    @Override
    public void didTapBarChart(@NonNull final String month) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(month);
        }
    }

    @Override
    public void didSelectedResume(final FCResume resume, @NonNull final TransactionType transactionType) {
        Toast.makeText(this, resume.getCategory(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emptyState(final TransactionType transactionType) {
        Toast.makeText(this, transactionType.toString(), Toast.LENGTH_SHORT).show();
    }

    private List<FCResumeTransaction> smallList(){
        final List<FCResumeTransaction> list = new ArrayList<>();
        // Incomes
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-06", "Transacciones Bancarias", 3500.0, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-07", "Transacciones Bancarias", 1600.0, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        //Expenses
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000005", "2021-08", "Salud y Belleza", -800.0, new FCCategory("00000000_0000_0000_0000_000000000005", "Salud y Belleza", "#FC427B", "", null, null, null, null)));
        return list;
    }

    private List<FCResumeTransaction> bigList(){
        final List<FCResumeTransaction> list = new ArrayList<>();
        // Incomes
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000050", "2021-06", "Ingresos", 12509.52, new FCCategory("00000000_0000_0000_0000_000000000050", "Ingresos", "#099FE2", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-06", "Transacciones Bancarias", 11162.69, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-07", "Transacciones Bancarias", 19564.73, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-08", "Transacciones Bancarias", 3630.0, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000050", "2021-08", "Ingresos", 2000.0, new FCCategory("00000000_0000_0000_0000_000000000050", "Ingresos", "#099FE2", "", null, null, null, null)));
        //Expenses
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-06", "Transacciones Bancarias", -8641.81, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000007", "2021-06", "Educación y Trabajo", -5368.68, new FCCategory("00000000_0000_0000_0000_000000000007", "Educación y Trabajo", "#B33771", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000001", "2021-06", "Hogar", -1790.09, new FCCategory("00000000_0000_0000_0000_000000000001", "Hogar", "#A3CB38", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000006", "2021-06", "Auto y Transporte", -1016.82, new FCCategory("00000000_0000_0000_0000_000000000006", "Auto y Transporte", "#33D9B2", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000003", "2021-06", "Entretenimiento", -659.84, new FCCategory("00000000_0000_0000_0000_000000000003", "Entretenimiento", "#FF9F43", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_00000000000b", "2021-06", "Finanzas e Impuestos", -457.36, new FCCategory("00000000_0000_0000_0000_00000000000b", "Finanzas e Impuestos", "#8C7AE6", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000002", "2021-06", "Alimentos", -15.0, new FCCategory("00000000_0000_0000_0000_000000000002", "Alimentos", "#FECA46", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000008", "2021-07", "Regalos y Ayuda", -14741.5, new FCCategory("00000000_0000_0000_0000_000000000008", "Regalos y Ayuda", "#F368E0", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000001", "2021-07", "Hogar", -3983.19, new FCCategory("00000000_0000_0000_0000_000000000001", "Hogar", "#A3CB38", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-07", "Transacciones Bancarias", -3516.65, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000002", "2021-07", "Alimentos", -2006.01, new FCCategory("00000000_0000_0000_0000_000000000002", "Alimentos", "#FECA46", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000005", "2021-07", "Salud y Belleza", -1000.0, new FCCategory("00000000_0000_0000_0000_000000000005", "Salud y Belleza", "#FC427B", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000003", "2021-07", "Entretenimiento", -867.5, new FCCategory("00000000_0000_0000_0000_000000000003", "Entretenimiento", "#FF9F43", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000006", "2021-07", "Auto y Transporte", -819.53, new FCCategory("00000000_0000_0000_0000_000000000006", "Auto y Transporte", "#33D9B2", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000007", "2021-07", "Educación y Trabajo", -805.86, new FCCategory("00000000_0000_0000_0000_000000000007", "Educación y Trabajo", "#B33771", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_00000000000b", "2021-07", "Finanzas e Impuestos", -457.36, new FCCategory("00000000_0000_0000_0000_00000000000b", "Finanzas e Impuestos", "#8C7AE6", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000008", "2021-08", "Regalos y Ayuda", -20000.0, new FCCategory("00000000_0000_0000_0000_000000000008", "Regalos y Ayuda", "#F368E0", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000007", "2021-08", "Educación y Trabajo", -8265.68, new FCCategory("00000000_0000_0000_0000_000000000007", "Educación y Trabajo", "#B33771", "", null, null, null, null)));
        list.add(new FCResumeTransaction("user_category", "2021-08", "Sin categoría", -5376.99, new FCCategory("user_category", "Sin categoría", "#ffaaaaaa", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000006", "2021-08", "Auto y Transporte", -484.9, new FCCategory("00000000_0000_0000_0000_000000000006", "Auto y Transporte", "#33D9B2", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000047", "2021-08", "Transacciones Bancarias", -200.0, new FCCategory("00000000_0000_0000_0000_000000000047", "Transacciones Bancarias", "#5F27CD", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000003", "2021-08", "Entretenimiento", -198.0, new FCCategory("00000000_0000_0000_0000_000000000003", "Entretenimiento", "#FF9F43", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000002", "2021-08", "Alimentos", -106.01, new FCCategory("00000000_0000_0000_0000_000000000002", "Alimentos", "#FECA46", "", null, null, null, null)));
        list.add(new FCResumeTransaction("a_00000000_0000_0000_0000_000000000001", "2021-08", "Hogar", -100.0, new FCCategory("00000000_0000_0000_0000_000000000001", "Hogar", "#A3CB38", "", null, null, null, null)));
        return list;
    }

}
