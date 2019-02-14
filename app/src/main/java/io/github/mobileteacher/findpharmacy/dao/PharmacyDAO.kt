package io.github.mobileteacher.findpharmacy.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.github.mobileteacher.findpharmacy.model.Pharmacy

@Dao //Database Access Object
interface PharmacyDAO {

    @Query("SELECT * FROM Pharmacy")
    fun listAll():LiveData<List<Pharmacy>>

    @Insert
    fun insert(pharmacy: Pharmacy)

    @Insert
    fun insert(pharmacies: List<Pharmacy>)

    @Update
    fun update(pharmacy: Pharmacy)

    @Query("DELETE FROM Pharmacy")
    fun deleteAll()

    @Delete
    fun delete(pharmacy: Pharmacy)

}