package uz.abbos.firebaseimgtxtupload

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.abbos.firebaseimgtxtupload.databinding.RewAddTechBinding


class TechAdapter(private var mList: List<TechData>, val c: Context) :
    RecyclerView.Adapter<TechAdapter.TechViewHolder>() {

    inner class TechViewHolder(private var binding:RewAddTechBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bing(data: TechData) {

            Picasso.get().load(data.imageUrl).into(binding.itemImg)

            binding.itemTxt.text = data.techName


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechViewHolder {
        val binding = RewAddTechBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TechViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TechViewHolder, position: Int) {
        val currentItem = mList[position]
        val country = currentItem.techName
        holder.bing(currentItem)

        holder.itemView.setOnClickListener {
            val i  = Intent(c, MainActivity::class.java)
            i.putExtra("country",country)
            c.startActivity(i)

        }



    }

    override fun getItemCount(): Int {
        return mList.size
    }


}