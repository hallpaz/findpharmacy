package io.github.mobileteacher.findpharmacy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.mobileteacher.findpharmacy.dao.PharmacyDAO
import io.github.mobileteacher.findpharmacy.model.Pharmacy



@Database(entities = [Pharmacy::class], version = 1)
abstract class PharmacyDatabase: RoomDatabase() {
    abstract fun pharmacyDao(): PharmacyDAO


    companion object {
        private var INSTANCE: PharmacyDatabase? = null
        const val DBNAME = "PharmacyDataBase"

        fun getInstance(context: Context):PharmacyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PharmacyDatabase::class.java,
                    DBNAME)
                    .build()
                INSTANCE = instance
                instance
            }

        }
    }

}


