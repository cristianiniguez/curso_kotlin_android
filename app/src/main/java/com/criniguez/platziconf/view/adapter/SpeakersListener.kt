package com.criniguez.platziconf.view.adapter

import com.criniguez.platziconf.model.Speaker

interface SpeakersListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}