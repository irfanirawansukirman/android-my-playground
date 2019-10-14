package id.co.gits.gitsplayground.view.deeplinkbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLinkHandler

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
@DeepLinkHandler(DeeplinkModule::class)
class DeeplinkActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val deepLinkDelegate = DeepLinkDelegate(DeeplinkModuleLoader())

//        deepLinkDelegate.dispatchFrom(this)

        finish()
    }
}