package com.example.tests.data

import com.example.tests.R.drawable.x1
import com.example.tests.R.drawable.x2
import com.example.tests.R.drawable.x3
import com.example.tests.R.drawable.x4
import com.example.tests.R.drawable.x5
import com.example.tests.R.drawable.x6
import com.example.tests.R.drawable.x7
import com.example.tests.R.drawable.x8
import com.example.tests.R.drawable.x9
import com.example.tests.R.drawable.x10
import com.example.tests.R.drawable.x11
import com.example.tests.R.drawable.x12
import com.example.tests.R.drawable.x13
import com.example.tests.R.drawable.x14
import com.example.tests.R.drawable.x15

import com.example.tests.R.drawable.o1
import com.example.tests.R.drawable.o2
import com.example.tests.R.drawable.o3
import com.example.tests.R.drawable.o4
import com.example.tests.R.drawable.o5
import com.example.tests.R.drawable.o6
import com.example.tests.R.drawable.o7
import com.example.tests.R.drawable.o8
import com.example.tests.R.drawable.o9
import com.example.tests.R.drawable.o10
import com.example.tests.R.drawable.o11
import com.example.tests.R.drawable.o12
import com.example.tests.R.drawable.o13
import com.example.tests.R.drawable.o14
import com.example.tests.R.drawable.o15

import com.example.tests.R.drawable.xo1
import com.example.tests.R.drawable.xo2
import com.example.tests.R.drawable.xo3
import com.example.tests.R.drawable.xo4
import com.example.tests.R.drawable.xo5
import com.example.tests.R.drawable.xo6
import com.example.tests.R.drawable.xo7
import com.example.tests.R.drawable.xo8
import com.example.tests.R.drawable.xo9
import com.example.tests.R.drawable.xo10
import com.example.tests.R.drawable.xo11
import com.example.tests.R.drawable.xo12
import com.example.tests.R.drawable.xo13
import com.example.tests.R.drawable.xo14
import com.example.tests.R.drawable.xo15

data class Image(
    val x: Int,
    val o: Int,
    val image: Int,
    val name: String
)

val images = listOf(
    Image(x1, o1, xo1, "Classic"),
    Image(x2, o2, xo2, "Candy"),
    Image(x3, o3, xo3, "Sport"),
    Image(x4, o4, xo4, "Food"),
    Image(x5, o5, xo5, "Nature"),
    Image(x6, o6, xo6, "Rainbow"),
    Image(x7, o7, xo7, "Knight"),
    Image(x8, o8, xo8, "Emoji"),
    Image(x9, o9, xo9, "Neon"),
    Image(x10, o10, xo10, "Hacking"),
    Image(x11, o11, xo11, "Pirate"),
    Image(x12, o12, xo12, "Music"),
    Image(x13, o13, xo13, "symbols"),
    Image(x14, o14, xo14, "Animals"),
    Image(x15, o15, xo15, "Space")
)