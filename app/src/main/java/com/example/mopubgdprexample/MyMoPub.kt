package com.example.mopubgdprexample

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.NonNull
import com.mopub.common.MoPub
import com.mopub.common.SdkConfiguration
import com.mopub.common.SdkInitializationListener
import com.mopub.common.logging.MoPubLog
import com.mopub.common.privacy.ConsentDialogListener
import com.mopub.common.privacy.PersonalInfoManager
import com.mopub.mobileads.MoPubErrorCode


class MyMoPub {

    private lateinit var mPersonalInfoManager: PersonalInfoManager

    private lateinit var mContext: Context

    fun init(context: Context, adunit: String) {
        mContext = context
        val sdkConfiguration = SdkConfiguration.Builder(adunit)
            .withLogLevel(MoPubLog.LogLevel.DEBUG)
            .withLegitimateInterestAllowed(false)
            .build()
        MoPub.initializeSdk(mContext, sdkConfiguration, initSdkListener())
    }

    private fun initSdkListener(): SdkInitializationListener {
        return SdkInitializationListener {
            /* MoPub SDK initialized.
            Check if you should show the consent dialog here, and make your ad requests. */
            Log.d("MoPub", "MoPub SDK Initilized")
            GDPRConsent()
        }
    }


    private fun GDPRConsent() {
        mPersonalInfoManager = MoPub.getPersonalInformationManager()!!
        Log.d("MoPub", "This country covered by GDPR? ${mPersonalInfoManager.gdprApplies()}")
        if (mPersonalInfoManager.shouldShowConsentDialog()) {
            val intent = Intent(mContext, CustomConsentDialog::class.java)
            mContext.startActivity(intent)
        }
    }
}