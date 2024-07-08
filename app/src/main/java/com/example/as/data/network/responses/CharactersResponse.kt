package com.example.`as`.data.network.responses

import com.example.`as`.data.models.Character
import com.google.gson.annotations.SerializedName

data class CharactersResponse (
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String
)

fun CharactersResponse.toModel() = Character(name = this.name, image = this.image, species = this.species, status = this.status)