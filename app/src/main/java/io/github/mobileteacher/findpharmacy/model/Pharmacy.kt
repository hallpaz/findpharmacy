package io.github.mobileteacher.findpharmacy.model

import androidx.room.*
import java.util.*


//@Entity(foreignKeys = arrayOf(ForeignKey(
//    entity = Owner::class,
//    parentColumns = arrayOf("id"),
//    childColumns = arrayOf("owner_id"))))
@Entity
class Pharmacy(var name: String,
               @ColumnInfo(name="phone_number") var phoneNumber: String,
               @Embedded var address: Address,
               var openAt: Date? = null,
               @PrimaryKey(autoGenerate = true) var gid: Int = 0)
//               @Ignore val propriedadeIgnorada: Int)
