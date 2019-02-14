package io.github.mobileteacher.findpharmacy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.mobileteacher.findpharmacy.model.Pharmacy
import kotlinx.android.synthetic.main.activity_add_pharmacy.*

class AddPharmacyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pharmacy)


        save_button.setOnClickListener {
            val replyIntent = Intent()
            replyIntent.putExtra(PHARMACY_PHONE, phone_edittext.text.toString())
            replyIntent.putExtra(PHARMACY_NAME, name_edittext.text.toString())
            setResult(Activity.RESULT_OK, replyIntent)

            finish()

        }
    }


    companion object {
        const val PHARMACY_NAME = "pharmacy_name"
        const val PHARMACY_PHONE = "pharmacy_phone"
    }

}
