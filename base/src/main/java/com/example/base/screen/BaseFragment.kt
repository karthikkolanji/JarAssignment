package com.example.base.screen

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseFragment(@LayoutRes contentLayoutId: Int = 0) :
    Fragment(contentLayoutId) {
}