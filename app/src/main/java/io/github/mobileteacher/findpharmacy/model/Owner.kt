package io.github.mobileteacher.findpharmacy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Owner(var name:String,
            @PrimaryKey(autoGenerate = true) var id:Int=0)