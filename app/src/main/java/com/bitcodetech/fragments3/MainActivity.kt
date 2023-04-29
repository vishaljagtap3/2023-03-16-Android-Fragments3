package com.bitcodetech.fragments3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private lateinit var mainContainer : LinearLayout
    private lateinit var btnAddFragment : Button
    private lateinit var btnRemoveFragment : Button

    private val counterFragments = ArrayList<CounterFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupListeners()
    }

    private fun setupListeners() {
        btnAddFragment.setOnClickListener {
            val counterFragment = CounterFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.mainContainer, counterFragment, null)
                .addToBackStack(null)
                .commit()

            counterFragments.add(counterFragment)
        }

        btnRemoveFragment.setOnClickListener {

            if(counterFragments.size == 0) {
                return@setOnClickListener
            }

            supportFragmentManager.beginTransaction()
                .remove( counterFragments[0] )
                .addToBackStack(null)
                .commit()

            counterFragments.removeAt(0)
        }
    }

    private fun initViews() {
        mainContainer = findViewById(R.id.mainContainer)
        btnAddFragment = findViewById(R.id.btnAddFragment)
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment)
    }
}