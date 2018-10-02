package id.co.gits.gitsplayground.deeplinkbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
@DeepLinkHandler(DeeplinkModule::class)
class DeeplinkActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deepLinkDelegate = DeepLinkDelegate(DeeplinkModuleLoader())

        deepLinkDelegate.dispatchFrom(this)

        finish()
    }
}