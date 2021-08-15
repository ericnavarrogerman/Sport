package com.example.sport.ui



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.R
import com.example.sport.databinding.ItemEventBinding
import com.example.sport.databinding.ItemTeamsBinding
import com.example.sport.model.Events
import com.example.sport.model.Teams
import com.example.sport.ui.AdapterTeams.ViewHolderTeams

class AdapterEvents : RecyclerView.Adapter<AdapterEvents.ViewHolderEvents>() {

    var events = ArrayList<Events>()



    class ViewHolderEvents(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val bindig =ItemEventBinding.bind(itemView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEvents {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return ViewHolderEvents(view)

    }

    override fun onBindViewHolder(holder: ViewHolderEvents, position: Int) {


            holder.bindig.event = events.get(position)


    }

    override fun getItemCount() = events.size


    fun setDataList(data :ArrayList<Events>){
        events=data
        notifyDataSetChanged()
    }

}