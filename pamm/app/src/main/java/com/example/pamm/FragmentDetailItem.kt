package com.example.pamm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detile.*

class FragmentDetailItem :Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_detile,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val name =arguments?.getString("name" )
       val age =arguments?.getString("age" )
       val company =arguments?.getString("company" )
       val km= arguments?.getString("km" )
       val image= requireArguments().getInt("img" )

        tv_nameCar.text=name
        tv_age.text=age
        tv_namecompany.text=company
        tv_km.text=km
        image_detaile.setImageResource(image)
    }
}