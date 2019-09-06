package com.example.mopubgdprexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyMoPub().init(this, Constant.MoPub.BANNER_AD_UNIT)

        gdpr_results.text = "Show ad"
    }

}
