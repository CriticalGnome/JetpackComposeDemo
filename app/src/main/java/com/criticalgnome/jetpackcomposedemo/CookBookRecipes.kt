package com.criticalgnome.jetpackcomposedemo

import androidx.annotation.DrawableRes
import com.criticalgnome.jetpackcomposedemo.Ingredients.*
import com.criticalgnome.jetpackcomposedemo.Recipe.CROISSANT
import com.criticalgnome.jetpackcomposedemo.Recipe.RAMEN

object CookBookRecipes {
    val defaultRecipes = listOf(
        RAMEN,
        CROISSANT
    )
}

enum class Recipe(
    @DrawableRes val resId: Int,
    val title: String,
    val ingredients: List<Ingredients>
) {
    RAMEN(
        R.drawable.ramen,
        "Ramen",
        listOf(NOODLES, EGGS, MUSHROOMS, CARROT, SOY_SAUCE)
    ),
    CROISSANT(
        R.drawable.croissant,
        "Croissant",
        listOf(BUTTER, MORE_BUTTER, TOUCH_OF_BUTTER, FLOUR)
    )
}

enum class Ingredients(val title: String) {
    NOODLES("Noodles"),
    EGGS("Eggs"),
    MUSHROOMS("Mushrooms"),
    CARROT("Carrot"),
    SOY_SAUCE("Soy Sauce"),
    BUTTER("Butter"),
    MORE_BUTTER("More Butter"),
    TOUCH_OF_BUTTER("A touch of Butter"),
    FLOUR("Flour")
}
