package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo

import androidx.lifecycle.ViewModel

class JiwooViewModel : ViewModel() {
    val jiwooData = JiwooData(
        thumbnail_image = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
        recipe_title = "마늘 미역국",
        owner_image = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
        owner_name = "김영순 할머니",
        owner_residence = "서울시 강남구",
        recipe_level = 3,
        recipe_time = "15분",
        recipe_story_title = "dummy story title",
        recipe_story = "할머니 스토리",
        ingredients = listOf(
            JiwooIngredient(
                ingredient_id = 1,
                ingredient_image = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                ingredient_name = "들기름",
                ingredient_amount = "10g"
            ),
            JiwooIngredient(
                ingredient_id = 1,
                ingredient_image = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                ingredient_name = "들기름",
                ingredient_amount = "10g"
            ),
            JiwooIngredient(
                ingredient_id = 1,
                ingredient_image = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                ingredient_name = "들기름",
                ingredient_amount = "10g"
            )
        ),
        recipe = listOf(
            "미역 어쩌고",
            "마늘 어쩌고",
            "물 어쩌고"
        )

    )
}