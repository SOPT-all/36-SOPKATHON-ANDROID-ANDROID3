package org.sopt.a36_sopkathon_android_android3.presentation.dongmin


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.core.ext.noRippleClickable
import org.sopt.a36_sopkathon_android_android3.presentation.component.StarCount
import org.sopt.a36_sopkathon_android_android3.ui.theme.HaeMuraTheme

@Composable
fun DongminRoute(
    navigateToMinseo: () -> Unit,
    viewModel: DongminViewModel = viewModel(),
) {
    DongminScreen(
        navigateToMinseo = navigateToMinseo,
        dialogState = viewModel.dialogState,
        getDialogState = viewModel::getDialogState
    )
}

@Composable
private fun DongminScreen(
    navigateToMinseo: () -> Unit,
    dialogState: DialogState,
    getDialogState: () -> Unit = {},
) {
    val scope = rememberCoroutineScope()
    var isOpenDialog by remember { mutableStateOf(false) }

    val shakeDegrees = remember { Animatable(0f) }
    val scale = remember { Animatable(1f) }
    var isShaking by remember { mutableStateOf(false) }


    LaunchedEffect(isOpenDialog) {
        if (!isOpenDialog) {
            // 복원
            launch {
                shakeDegrees.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                )
            }

            launch {
                scale.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                )
            }

            delay(300)
            isShaking = false
        }
    }

    if (isOpenDialog) {
        StoryDialog(
            state = dialogState,
            onDismissRequest = {
                isOpenDialog = false
            },
            onRetry = {
                isOpenDialog = false
            },
            onRecipe = navigateToMinseo
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HaeMuraTheme.colors.bg),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier)

        Image(
            painter = painterResource(R.drawable.jangdokdae),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .scale(1.2f)
                .graphicsLayer {
                    rotationZ = shakeDegrees.value
                    scaleX = scale.value
                    scaleY = scale.value
                }
                .noRippleClickable {
                    if (!isShaking) {
                        getDialogState()
                        isShaking = true
                        scope.launch {
                            val duration = 1800

                            // animateTo with ease-in effect
                            launch {
                                shakeDegrees.animateTo(
                                    targetValue = 10f,
                                    animationSpec = tween(
                                        durationMillis = duration,
                                        easing = FastOutSlowInEasing
                                    )
                                )
                            }

                            launch {
                                scale.animateTo(
                                    targetValue = 1.4f,
                                    animationSpec = tween(
                                        durationMillis = duration,
                                        easing = FastOutSlowInEasing
                                    )
                                )
                            }

                            delay(duration.toLong())
                            isOpenDialog = true

                            delay(500)
                        }
                    }
                }
        )


        Text(
            text = if (!isOpenDialog && !isShaking) "탭해서 특별한 레시피 보러가기" else "",
            modifier = Modifier
                .clickable(
                    onClick = navigateToMinseo
                )
                .padding(bottom = 20.dp),
            style = HaeMuraTheme.typography.body_spc_14,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StoryDialog(
    state: DialogState,
    onDismissRequest: () -> Unit,
    onRetry: () -> Unit,
    onRecipe: () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(HaeMuraTheme.colors.card),
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(HaeMuraTheme.colors.card)
                    .padding(16.dp),
            ) {
                AsyncImage(
                    model = state.data.recipe_image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)),
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = state.data.recipe_owner.recipe_owner_address,
                    style = HaeMuraTheme.typography.head_spc_16
                )

                Text(
                    text = state.data.recipe_name,
                    style = HaeMuraTheme.typography.head_spc_24
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "난이도",
                        style = HaeMuraTheme.typography.body_spc_12,
                        color = HaeMuraTheme.colors.light
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    StarCount(state.data.recipe_level)

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "시간",
                        style = HaeMuraTheme.typography.body_spc_12,
                        color = HaeMuraTheme.colors.light
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = state.data.cooking_time,
                        style = HaeMuraTheme.typography.caption_12R,
                        color = HaeMuraTheme.colors.dark
                    )
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = state.data.recipe_small_title,
                    style = HaeMuraTheme.typography.body_spc_14,
                    color = HaeMuraTheme.colors.dark
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = state.data.recipe_story,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4,
                    style = HaeMuraTheme.typography.body_14R,
                    overflow = Ellipsis
                )

                Spacer(
                    modifier = Modifier.height(27.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(HaeMuraTheme.colors.bg)
                            .clickable {
                                onRetry()
                            }
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "다시 뽑기",
                            style = HaeMuraTheme.typography.body_spc_14,
                            color = HaeMuraTheme.colors.dark,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(9.dp)
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(14.dp)
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(HaeMuraTheme.colors.primary)
                            .clickable {
                                onRecipe()
                            }
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "레시피 보러가기",
                            style = HaeMuraTheme.typography.body_spc_14,
                            color = HaeMuraTheme.colors.white,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(9.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMinseoScreen() {
    HaeMuraTheme {
        DongminScreen(
            navigateToMinseo = {},
            dialogState = DialogState()
        )
    }
}