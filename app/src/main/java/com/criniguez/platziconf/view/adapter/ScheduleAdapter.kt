package com.criniguez.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.criniguez.platziconf.R
import com.criniguez.platziconf.model.Conference
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConferences = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conference = listConferences[position]

        holder.tvConferenceName.text = conference.title
        holder.tvConferenceSpeaker.text = conference.speaker
        holder.tvConferenceTag.text = conference.tag

        holder.tvConferenceHour.text = SimpleDateFormat("HH:MM").format(conference.datetime)
        holder.tvConferenceAMPM.text =
            SimpleDateFormat("a").format(conference.datetime).toUpperCase()

        holder.itemView.setOnClickListener {
            scheduleListener.onConferenceClicked(conference, position)
        }
    }

    override fun getItemCount() = listConferences.size

    fun updateData(data: List<Conference>) {
        listConferences.clear()
        listConferences.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeaker =
            itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvConferenceTag =
            itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
    }
}