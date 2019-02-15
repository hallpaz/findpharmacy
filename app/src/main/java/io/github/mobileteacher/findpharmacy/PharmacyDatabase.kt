package io.github.mobileteacher.findpharmacy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import io.github.mobileteacher.findpharmacy.dao.PharmacyDAO
import io.github.mobileteacher.findpharmacy.model.DateConverter
import io.github.mobileteacher.findpharmacy.model.Pharmacy



@Database(entities = [Pharmacy::class], version = 3)
@TypeConverters(DateConverter::class)
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
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }

        }
    }
}

//val Migration_2_3 = object : Migration(2, 3) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE Pharmacy DROP COLUMN address")
//    }
//
//}


