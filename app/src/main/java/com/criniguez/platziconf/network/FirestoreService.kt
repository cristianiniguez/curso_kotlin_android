package com.criniguez.platziconf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.criniguez.platziconf.model.Speaker
import com.criniguez.platziconf.model.Conference

const val SPEAKERS_COLLECTION_NAME = "speakers"
const val CONFERENCES_COLLECTION_NAME = "conferences"

class FirestoreService {
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callback: Callback<List<Speaker>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME).orderBy("category").get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>) {
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME).get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}