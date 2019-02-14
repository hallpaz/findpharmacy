package io.github.mobileteacher.findpharmacy

import androidx.lifecycle.LiveData
import io.github.mobileteacher.findpharmacy.dao.PharmacyDAO
import io.github.mobileteacher.findpharmacy.model.Pharmacy

class PharmacyRepository(private val pharmacyDAO: PharmacyDAO) {

    fun shouldFetchData(): Boolean{
        return false
    }


    fun listPharmacies(): LiveData<List<Pharmacy>>{
//        if (shouldFetchData()){
//            return
//        } else{
        return pharmacyDAO.listAll()
//        }
    }


    fun insert(pharmacy: Pharmacy){
        pharmacyDAO.insert(pharmacy)
    }

    fun delete(pharmacy: Pharmacy){
        pharmacyDAO.delete(pharmacy)
    }

}