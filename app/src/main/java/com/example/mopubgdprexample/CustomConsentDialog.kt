package com.example.mopubgdprexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mopub.common.MoPub
import com.mopub.common.privacy.PersonalInfoManager
import kotlinx.android.synthetic.main.activity_custom_consent_dialog.*


class CustomConsentDialog : AppCompatActivity() {

    private lateinit var mPersonalInfoManager: PersonalInfoManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_consent_dialog)
        title = "Personalize Your Experience"

        mPersonalInfoManager = MoPub.getPersonalInformationManager()!!

        gdpr_main_text.text = Constant.MoPub.MAIN_TEXT

        gdpr_note_text.text = Constant.MoPub.NOTE_TEXT

        gdpr_footer_text.text = Constant.MoPub.FOOTER_TEXT

        gdpr_agree_btn.setOnClickListener {
            // Call this to let MoPub know the user has granted consent
            mPersonalInfoManager.grantConsent()
            finish()
        }

        gdpr_disagree_btn.setOnClickListener {
            // Call this to let MoPub know the user has revoked consent.
            mPersonalInfoManager.revokeConsent()
            finish()
        }
    }
}
