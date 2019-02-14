package io.github.mobileteacher.findpharmacy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity
class Pharmacy(var name: String,
               @ColumnInfo(name="phone_number") var phoneNumber: String,
               @PrimaryKey(autoGenerate = true) var gid: Int = 0)
//               @Ignore val propriedadeIgnorada: Int)