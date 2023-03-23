package com.example.androidbottomnavigationsample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidbottomnavigationsample.MainActivity
import com.example.androidbottomnavigationsample.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class ProfileFragment : Fragment() {

    lateinit var button : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as MainActivity
        button = activity.findViewById<Button>(R.id.buttonHide)

        button.setOnClickListener{
            activity.hideNavigation()
        }
    }

}