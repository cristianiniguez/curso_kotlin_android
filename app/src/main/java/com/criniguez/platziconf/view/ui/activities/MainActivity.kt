package com.criniguez.platziconf.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.criniguez.platziconf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.toolbar_main))
        configNav()
    }

    fun configNav() {
        NavigationUI.setupWithNavController(
            bnvMenu,
            Navigation.findNavController(this, R.id.fragContent)
        )
    }
}