package io.github.mobileteacher.findpharmacy

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.mobileteacher.findpharmacy.dao.PharmacyDAO
import io.github.mobileteacher.findpharmacy.model.Pharmacy

class PharmacyViewModel(application: Application):AndroidViewModel(application) {

    // não é privado, porque será observado
    val pharmaciesList: LiveData<List<Pharmacy>>
    private val repository: PharmacyRepository


    init {
        val database = PharmacyDatabase.getInstance(application.applicationContext)
        val dao = database.pharmacyDao()
        repository = PharmacyRepository(dao)
        pharmaciesList = repository.listPharmacies()
    }


    fun insert(pharmacy: Pharmacy){
        repository.insert(pharmacy)
//        Log.d("VIEWMODEL", "insert $pharmacy.name")
    }

}