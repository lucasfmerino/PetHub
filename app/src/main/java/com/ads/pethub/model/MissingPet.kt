package com.ads.pethub.model

data class MissingPet(
    val petName: String,
    val image: Int,
    val date: String,
    val time: String,
    val address: String,
    val number: String,
    val neighborhood: String,
    val city: String,
    val state: String
)
