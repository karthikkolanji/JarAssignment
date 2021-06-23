package com.example.base.extensions

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.base.extensions.longToast
import com.example.base.extensions.shortToast

fun Fragment.shortToast(message: CharSequence) = requireContext().shortToast(message)

fun Fragment.shortToast(@StringRes resId: Int) = requireContext().shortToast(resId)

fun Fragment.longToast(message: CharSequence) = requireContext().longToast(message)

fun Fragment.longToast(@StringRes resId: Int) = requireContext().longToast(resId)