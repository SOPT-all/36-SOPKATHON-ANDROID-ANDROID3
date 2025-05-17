package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.presentation.component.LoadingIcons
import org.sopt.a36_sopkathon_android_android3.presentation.component.StarCount
import org.sopt.a36_sopkathon_android_android3.presentation.component.TopBar
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component.IngredientCard
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component.IngredientItem
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.component.RecipeOverview
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.colors
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme.typography

@Composable
fun JiwooRoute(
    navigateToJuwan: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: JiwooViewModel = viewModel(),
) {
    val jiwooData = viewModel.state
    val isLoading = viewModel.isLoading

    if (isLoading) {
        LoadingIcons(
            modifier = Modifier
                .fillMaxSize()
                .background(HaeMuraTheme.colors.bg)
        )
    } else {
        JiwooScreen(
            jiwooData = jiwooData,
            navigateToJuwan = navigateToJuwan
        )
    }
}

@Composable
private fun JiwooScreen(
    jiwooData: RecipeData,
    navigateToJuwan: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(color = colors.bg)
            .fillMaxSize()
    ) {
        TopBar(
            topBarText = jiwooData.recipeTitle,
            onClickBack = navigateToJuwan,
            trailingIconVisible = true
        )

        LazyColumn {
            item {
                AsyncImage(
                    model = jiwooData.thumbnailImage,
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
                    ownerImageUrl = jiwooData.ownerImage,
                    ownerName = jiwooData.ownerName,
                    ownerResidence = jiwooData.ownerResidence,
                    recipeTitle = jiwooData.recipeTitle,
                    difficulty = jiwooData.recipeLevel,
                    time = jiwooData.recipeTime,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                Column(
                    Modifier
                        .padding(16.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = jiwooData.recipeSmallTitle,
                        style = typography.body_14R,
                        color = colors.dark
                    )
                    Text(
                        text = jiwooData.recipeStory,
                        style = typography.body_14R,
                        color = Color(0xFF6B331D)
                    )
                }
            }
            // 특산물
            item {
                Column(
                    Modifier
                        .padding(16.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "특산물",
                        style = typography.head_spc_16,
                        color = colors.dark
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        jiwooData.localIngredients.forEach {
                            IngredientItem(
                                imageUrl = it.localIngredientsImage,
                                ingredientName = it.ingredientName,
                                ingredientAmount = it.ingredientAmount
                            )
                        }
                    }
                }
            }
            // 레시피
            item {
                Column(
                    Modifier
                        .padding(16.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "레시피",
                        style = typography.head_spc_16,
                        color = colors.dark
                    )
                    Spacer(modifier = Modifier.padding(top = 20.dp))

                    jiwooData.recipe.forEachIndexed { index, recipe ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "${index + 1}",
                                style = typography.body_spc_14,
                                color = colors.dark,
                                modifier = Modifier.padding(end = 16.dp)
                            )
                            Text(
                                text = recipe,
                                style = typography.body_14R,
                                color = colors.dark
                            )
                        }
                    }
                }
            }
            // 리뷰
            item {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "레시피 따라, 내 이야기",
                            style = typography.head_spc_16,
                            color = colors.dark
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "전체보기",
                            style = typography.caption_12R,
                            color = colors.dark
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_detail),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = colors.light,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_home_11),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .size(24.dp)
                            )
                            Text(
                                text = "무라무라",
                                style = typography.head_spc_16,
                                color = colors.dark
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            StarCount(5)
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(R.drawable.img_home_15),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(width = 66.dp, height = 80.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "해무라 보고 처음 미역국 끓여봤는데 진짜 맛있었어요. 간단한 재료로도 국물이 깊고 고소해서 깜짝 놀랐어요!",
                                style = typography.body_14R,
                                color = colors.dark
                            )
                        }
                    }
                }
            }

            // 추천 아이템
            item {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "함께하면 더 맛있는 추천",
                        style = typography.head_spc_16,
                        color = colors.dark
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    LazyRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(jiwooData.recommends) { item ->
                            IngredientCard(
                                recommendImg = item.recommendImg,
                                recommendShopName = item.recommendStore,
                                recommendName = "",
                                recommendPrice = "${item.recommendItemPrice}원"
                            )
                        }
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
            jiwooData = RecipeData(),
            navigateToJuwan = {}
        )
    }
}