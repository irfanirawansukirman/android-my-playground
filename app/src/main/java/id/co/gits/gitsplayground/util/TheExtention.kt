package id.co.gits.gitsplayground.util

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
inline fun <FRAGMENT : Fragment> FRAGMENT.putArgs(argsBuilder: Bundle.() -> Unit):
        FRAGMENT = this.apply { arguments = Bundle().apply(argsBuilder) }