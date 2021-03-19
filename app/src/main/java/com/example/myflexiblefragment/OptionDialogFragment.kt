package com.example.myflexiblefragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class OptionDialogFragment : DialogFragment() {
    private lateinit var btnTutup: Button
    private lateinit var btnPilih :Button
    private lateinit var rgOpt: RadioGroup
    private lateinit var rbSaf: RadioButton
    private lateinit var rbMou: RadioButton
    private lateinit var rbLvg: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPilih = view.findViewById(R.id.btn_pilih)
        btnTutup = view.findViewById(R.id.btn_close)
        rgOpt = view.findViewById(R.id.rg_options)
        rbSaf = view.findViewById(R.id.rb_saf)
        rbMou = view.findViewById(R.id.rb_mou)
        rbLvg = view.findViewById(R.id.rb_lvg)

        btnPilih.setOnClickListener {
            val checkRBid = rgOpt.checkedRadioButtonId
            if (checkRBid != -1) {
                var coach: String? = null
                when (checkRBid) {
                    R.id.rb_saf -> coach = rbSaf.text.toString().trim()
                    R.id.rb_mou -> coach = rbMou.text.toString().trim()
                    R.id.rb_lvg -> coach = rbLvg.text.toString().trim()
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        btnTutup.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }
    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

}


