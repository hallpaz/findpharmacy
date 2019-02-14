package io.github.mobileteacher.findpharmacy

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
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
        DoAsync {
            repository.insert(pharmacy)
        }
    }

    fun delete(pharmacy: Pharmacy){
        DoAsync {
            repository.delete(pharmacy)
        }
    }

    class DoAsync(val action: ()->Unit): AsyncTask<Unit, Unit, Unit>() {

        init {
            execute()
        }

        override fun doInBackground(vararg params: Unit?) {
            action()
        }
    }

}