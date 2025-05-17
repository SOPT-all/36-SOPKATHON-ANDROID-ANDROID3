package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.presentation.component.TopBar
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component.IngredientCard
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component.IngredientItem
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component.RecipeOverview
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component.Review
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors

@Composable
fun JiwooRoute(
    navigateToJuwan: () -> Unit,
    modifier: Modifier = Modifier
) {
    val jiwooData = JiwooViewModel().jiwooData
    JiwooScreen(
        jiwooData = jiwooData,
        navigateToJuwan = navigateToJuwan
    )
}

@Composable
private fun JiwooScreen(
    jiwooData: JiwooData = JiwooViewModel().jiwooData,
    navigateToJuwan: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = colors.bg)
            .fillMaxSize()
    ) {
        TopBar(
            topBarText = jiwooData.recipe_title,
            onClickBack = navigateToJuwan
        )

        LazyColumn {
            item {
                AsyncImage(
                    model = jiwooData.thumbnail_image,
                    contentDescription = "음식 이미지",
                    modifier = Modifier
                        .height(226.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                RecipeOverview(
                    ownerImageUrl = jiwooData.owner_image,
                    ownerName = jiwooData.owner_name,
                    ownerResidence = jiwooData.owner_residence,
                    recipeTitle = jiwooData.recipe_title,
                    difficulty = jiwooData.recipe_level,
                    time = jiwooData.recipe_time
                )
            }
            item {
                Column(
                    Modifier
                        .background(color = Color.White)
                        .padding(16.dp)
                ){
                    Text(text = jiwooData.recipe_story_title)
                    Text(text = jiwooData.recipe_story)
                }
            }
            //특산물
            item {
                Column(
                    Modifier
                        .background(color = Color.White)
                        .padding(16.dp)
                ){
                    Text(text = "특산물")
                    Spacer(modifier = Modifier.height(11.dp))
                    Row {
                        IngredientItem(
                            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                            ingredientName = "들기름",
                            ingredientAmount = "10g"
                        )
                        IngredientItem(
                            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                            ingredientName = "들기름",
                            ingredientAmount = "10g"
                        )
                        IngredientItem(
                            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                            ingredientName = "들기름",
                            ingredientAmount = "10g"
                        )
                    }
                }

            }
            item {
                Column(
                    Modifier
                        .background(color = Color.White)
                        .padding(16.dp)
                ){
                    Text(text = "레시피",)



                    jiwooData.recipe.forEachIndexed { index, recipe ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "${index + 1}",
                                modifier = Modifier.padding(end = 12.dp)
                            )

                            Text(recipe)
                        }

                    }

                }
            }
            //리뷰
            item {
                Text(
                    text = "짱드삼 할머니는 들기름 하나로 계절을 무쳤습니다...",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            item {
                Review(
                    imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                    content = "들기름 향이 너무 좋았어요!"
                )
            }
            item {
                Column {
                    Text(text = "함께하면 더 맛있는 추천")
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        IngredientCard (
                            recommendImg = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                            recommendShopName = "바다숨",
                            recommendName = "해녀가 건진 맑은 미역",
                            recommendPrice = "3,900원"
                        )
                        IngredientCard (
                            recommendImg = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                            recommendShopName = "들소방앗간",
                            recommendName = "해녀가 건진 맑은 미역",
                            recommendPrice = "3,900원"
                        )
                        IngredientCard (
                            recommendImg = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20240814/1707/P001760343.jpg/dims/resize/F_webp,400",
                            recommendShopName = "바다숨",
                            recommendName = "해녀가 건진 맑은 미역",
                            recommendPrice = "3,900원"
                        )
                    }
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewJiwooScreen() {
    HaeMuraTheme {
        JiwooScreen(
            navigateToJuwan = {}
        )
    }
}