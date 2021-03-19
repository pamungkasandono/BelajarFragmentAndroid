package com.example.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class DetailCategoryFragment : Fragment() {
    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var btnProfile: Button
    lateinit var btnShowDialog: Button

    var description: String? = null

    companion object {
        var EXTRA_NAME = "name"
        var EXTRA_DESC = "desc"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESC)
            description = descFromBundle
        }

        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = categoryName
            tvCategoryDescription.text = description
        }
    }
}
