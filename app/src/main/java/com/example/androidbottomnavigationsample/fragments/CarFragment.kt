package com.example.androidbottomnavigationsample.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.androidbottomnavigationsample.MainActivity
import com.example.androidbottomnavigationsample.R


class CarFragment : Fragment() {

    var cars = listOf(
        "Tesla", "Model S",
        "Tesla", "Model Paid",
        "Tesla", "Model X",
        "Tesla", "Cyber Truck",
        "BMW", "I3",
        "Volvo", "XC40",
        "Volvo", "C40",
        "Jeep", "Compass E",
        "Nissan", "Leaf",
        "JAC", "E-JS1",
        "Kwid", "e-Tech"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = requireActivity().findViewById<ListView>(R.id.list)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(requireActivity(), android.R.layout.simple_list_item_1, cars)

        listView.adapter = adapter

        val activity = requireActivity() as MainActivity


        listView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        }

        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            private var mLastFirstVisibleItem = 0
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                Log.i("onScrollStateChanged", "scrollState: $scrollState")
                if(scrollState == SCROLL_STATE_IDLE) {
                    activity.hideNavigation(true)
                }
                if(scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                    activity.hideNavigation(false)
                }
            }
            override fun onScroll(
                view: AbsListView?, firstVisibleItem: Int,
                visibleItemCount: Int, totalItemCount: Int
            ) {
                if (mLastFirstVisibleItem < firstVisibleItem) {
                    Log.i("SCROLLING DOWN", "TRUE")
                }
                if (mLastFirstVisibleItem > firstVisibleItem) {
                    Log.i("SCROLLING UP", "TRUE")
                }
                mLastFirstVisibleItem = firstVisibleItem
            }
        })

    }

}