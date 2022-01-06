package com.finerioconnect.fineriopfmexample.analysissdk;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.finerioconnect.sdk.analysis.ui.FCAnalysisDetailView;
import com.finerioconnect.fineriopfmexample.databinding.ActivityAnalysisDetailSdkBinding;
import com.finerioconnect.sdk.models.FCAnalysisCategory;

public class AnalysisDetailSDKActivity extends AppCompatActivity {

    public static final String ANALYSIS_DETAIL_KEY = "analysisCategory";

    private ActivityAnalysisDetailSdkBinding mBinding;

    private FCAnalysisCategory mAnalysisCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityAnalysisDetailSdkBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mAnalysisCategory = getIntent().getParcelableExtra(ANALYSIS_DETAIL_KEY);

        if(mAnalysisCategory == null){
            return;
        }
        setup();
    }

    private void setup() {
        final FCAnalysisDetailView fcAnalysisDetailView = mBinding.fcAnalysisDetailView;
        fcAnalysisDetailView.setAnalysis(mAnalysisCategory);
    }

}
