package com.example.weatherandroidassignment.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.example.weatherandroidassignment.R


open class BaseActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null
    var title: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setToolBar(isShowArrow: Boolean, titleText: String) {
        toolbar = findViewById(R.id.toolbar)
        title = findViewById(R.id.title)
        title?.maxLines = 1
        title?.ellipsize = TextUtils.TruncateAt.END

        title?.text = titleText
        toolbar?.contentInsetStartWithNavigation = 0
        setSupportActionBar(toolbar)

        if (isShowArrow) {
            toolbar?.setNavigationIcon(R.drawable.ic_chevron_left)
        }

        toolbar?.navigationIcon?.colorFilter =
            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                ContextCompat.getColor(
                    this,
                    R.color.colorAccent
                ), BlendModeCompat.SRC_ATOP
            )
    }

}