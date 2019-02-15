package io.github.mobileteacher.findpharmacy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.mobileteacher.findpharmacy.model.Address
import io.github.mobileteacher.findpharmacy.model.Pharmacy
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ADD_REQUEST_CODE = 71
    }

    private lateinit var pharmacyViewModel: PharmacyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpRecyclerView()

        add_fab.setOnClickListener {
            val addIntent = Intent(this, AddPharmacyActivity::class.java)
            startActivityForResult(addIntent, ADD_REQUEST_CODE)
        }

        pharmacyViewModel = ViewModelProviders.of(this).get(PharmacyViewModel::class.java)

        pharmacyViewModel.pharmaciesList.observe(this, Observer {list->
            val adapter = recyclerView.adapter
            if (adapter is PharmacyAdapter){
                adapter.setNewList(list)
            }
        })

    }


    private fun setUpRecyclerView(){
        recyclerView.adapter = PharmacyAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                ADD_REQUEST_CODE -> {
                    data?.let {data->
                        val name = data.getStringExtra(AddPharmacyActivity.PHARMACY_NAME)
                        val phone = data.getStringExtra(AddPharmacyActivity.PHARMACY_PHONE)
                        val pharmacy = Pharmacy(name,
                                                phone,
                                                Address("Rua tal", "700", "20000-111"),
                                                Calendar.getInstance().time)

                        pharmacyViewModel.insert(pharmacy)
                    }




                }
            }
        }
    }
}
