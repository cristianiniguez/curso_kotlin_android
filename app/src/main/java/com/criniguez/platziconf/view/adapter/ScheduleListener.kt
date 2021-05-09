package com.criniguez.platziconf.view.adapter

import com.criniguez.platziconf.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}