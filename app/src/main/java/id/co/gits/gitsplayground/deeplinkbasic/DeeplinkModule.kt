package id.co.gits.gitsplayground.deeplinkbasic

import android.content.Context
import android.content.Intent
import com.airbnb.deeplinkdispatch.DeepLink
import com.airbnb.deeplinkdispatch.DeepLinkModule

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
@DeepLinkModule
class DeeplinkModule

@DeepLink("https://testdeeplink.com/lorem/{id}")
fun startActivity(context: Context): Intent {
    return Intent(context, DeeplinkBasicActivity::class.java)
}
