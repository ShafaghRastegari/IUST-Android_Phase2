package com.example.pamm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class FragmentHome :Fragment() {
    val image= arrayOf(R.drawable.a1,R.drawable.a2,R.drawable.a3,
        R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7
        ,R.drawable.a8,R.drawable.a9,R.drawable.a10)

    val nameCar= arrayOf("تسلا مدل اس","کونا","لیف اس پلاس","۲۰۲۰ نیرو","تسلا مدل ۳","","","","","" )
    val Yearofconstruction= arrayOf("۲۰۱۲","۲۰۱۷ ","2018","2019","2018","2020","2015","2019","2020","" )
    val CompanyName= arrayOf("موتورز تسلا","هیوندای موتور","نیسان","موتورز تسلا","کیا","","","","","" )
    val km= arrayOf(" 200 کیلومتر","100 کیلومتر","","","","","","","","" )

    val listModel= ArrayList<ModelCar>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }
    private fun setUpRecyclerView(){

        btn_about.setOnClickListener {
            requireActivity(). findNavController(R.id.btn_about).navigate(R.id.fragmentAbout)

        }

        for (i in 0  .. 9){
            val  model=ModelCar(nameCar[i],Yearofconstruction[i],image[i],CompanyName[i],km[i])
            listModel.add(model)
        }
        recyclerView.adapter=AdapterRecyclerView(listModel,object :AdapterRecyclerView.OnClickItemRecyclerview{
            override fun click(modelCar: ModelCar,id:Int) {

                val bundel=Bundle()
                bundel.putString("name",modelCar.name)
                bundel.putString("age",modelCar.Yearofconstruction)
                bundel.putString("company",modelCar.CompanyName)
                bundel.putString("km",modelCar.km)
                bundel.putInt("img",modelCar.image)

               requireActivity(). findNavController(R.id.recyclerView).navigate(R.id.fragmentDetailItem,bundel)

            }
        })
    }
}