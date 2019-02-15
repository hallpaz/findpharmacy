package io.github.mobileteacher.findpharmacy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.mobileteacher.findpharmacy.model.Pharmacy
import java.text.SimpleDateFormat

class PharmacyAdapter(var items: List<Pharmacy> = listOf())
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    enum class ItemType{
        DEFAULT, EMPTY
    }

    fun setNewList(list: List<Pharmacy>){
        items = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = if(items.isNotEmpty())
        ItemType.DEFAULT.ordinal
    else ItemType.EMPTY.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ItemType.DEFAULT.ordinal){
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_pharmacy, parent, false)
            return PharmacyViewHolder(itemView)
        }

        return EmptyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.empty_list, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PharmacyViewHolder){
            val pharmacy = items[position]
            holder.nameTextView.text = pharmacy.name
            holder.phoneTextView.text = pharmacy.phoneNumber

            val sdf = SimpleDateFormat("dd/MM/yyyy")

            holder.dateTextView.text = sdf.format(pharmacy.openAt)
        }
    }

    override fun getItemCount() = if(items.isNotEmpty()) items.size else 1


    class PharmacyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.pharmacy_name_textview)
        val phoneTextView: TextView = itemView.findViewById(R.id.phone_textview)
        val dateTextView: TextView = itemView.findViewById(R.id.date_textview)
    }

    class EmptyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


}