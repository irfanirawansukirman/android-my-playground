package id.co.gits.gitsplayground.base

import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
open class BaseFragment : Fragment() {

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}