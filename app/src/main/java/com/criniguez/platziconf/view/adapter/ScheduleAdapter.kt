package com.criniguez.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.criniguez.platziconf.R
import com.criniguez.platziconf.model.Conference

class ScheduleAdapter() : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConference = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
    )

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount() = listConference.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvScheduleHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvScheduleAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvScheduleConferenceSpeaker =
            itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvScheduleConferenceTag =
            itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceTag)
    }
}