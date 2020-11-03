package be.henallux.ig3.android.app.example.ui.module6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import be.henallux.ig3.android.app.example.R


class WhatIsKotlinFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.mod6_fragment_what_is_kotlin, container, false)

        val nextButton = root.findViewById<Button>(R.id.what_is_kotlin_next_button)
        nextButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_whatIsKotlinFragment_to_kotlinExampleFragment)
        }

        return root
    }

}
