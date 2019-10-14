package id.co.gits.gitsplayground.view.bottomnavigationwithnavigationui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import id.co.gits.gitsplayground.R
import kotlinx.android.synthetic.main.bottom_navigation_activity.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_navigation_activity)
        val navController = Navigation.findNavController(this, R.id.fragment_auth_navHost)
        bottom_nav.setupWithNavController(navController)
    }
}
