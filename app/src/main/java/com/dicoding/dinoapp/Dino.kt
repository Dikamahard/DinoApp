package com.dicoding.dinoapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dino(
    val name: String,
    val descPrev: String,
    val descDetail: String,
    val era: String,
    val year: String,
    val type: String,
    val diet: String,
    val region: String,
    val weight: String,
    val height: String,
    val lenght: String,
    val img: Int
) : Parcelable
