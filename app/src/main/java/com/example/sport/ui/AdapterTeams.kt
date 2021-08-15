package com.example.sport.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.R
import com.example.sport.databinding.ItemTeamsBinding
import com.example.sport.model.Teams
import com.example.sport.ui.AdapterTeams.ViewHolderTeams

class AdapterTeams : RecyclerView.Adapter<ViewHolderTeams>() {

    var teams = ArrayList<Teams>()
    var clic :(team:Teams) -> Unit={team ->  }


    class ViewHolderTeams(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = ItemTeamsBinding.bind(itemView)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTeams {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teams, parent, false)
        return ViewHolderTeams(view)

    }

    override fun onBindViewHolder(holder: ViewHolderTeams, position: Int) {


        holder.binding.team = teams.get(position)
        holder.binding.parent.setOnClickListener{  clic(teams.get(position)) }

    }

    override fun getItemCount() = teams.size


    fun setDataList(data :ArrayList<Teams>){
        teams=data
        notifyDataSetChanged()
    }

}