package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo


data class JiwooData(
    val thumbnail_image : String,
    val recipe_title : String,
    val owner_image : String,
    val owner_name : String,
    val owner_residence : String,
    val recipe_level : Int,
    val recipe_time : String,

    val recipe_story_title : String,
    val recipe_story : String,
    val ingredients:List<JiwooIngredient>,

    val recipe: List<String>
)

data class JiwooIngredient(
    val ingredient_id : Int,
    val ingredient_image : String,
    val ingredient_name : String,
    val ingredient_amount : String,
)