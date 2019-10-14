package id.co.gits.gitsplayground.view.deeplinkbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.airbnb.deeplinkdispatch.DeepLink
import id.co.gits.gitsplayground.R

class DeeplinkBasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deeplink_basic_activity)
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            val parameters = intent.extras
            val idString = parameters?.getString("id")
            Toast.makeText(this, idString
                    ?: "Data anda kosong", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Haha", Toast.LENGTH_SHORT).show()
        }
    }
}
