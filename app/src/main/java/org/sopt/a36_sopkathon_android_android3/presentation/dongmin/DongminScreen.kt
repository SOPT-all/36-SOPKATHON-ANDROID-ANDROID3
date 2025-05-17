package org.sopt.a36_sopkathon_android_android3.presentation.dongmin


import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.ui.theme._36SOPKATHONANDROIDANDROID3Theme
import java.lang.Math.PI
import kotlin.math.sin

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

    if (isOpenDialog) {
        StoryDialog(
            imageUrl = dialogState.imageUrl,
            name = dialogState.name,
            title = dialogState.title,
            story = dialogState.story,
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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = {
                    // TODO: navitgateUp
                    navigateToMinseo()
                },
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }


        val shakeDegrees = remember { Animatable(0f) }
        var isShaking by remember { mutableStateOf(false) }

        Image(
            painter = painterResource(R.drawable.hangari) ,
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer {
                    rotationZ = shakeDegrees.value
                }
                .clickable(
                    onClick = {
                        if (!isShaking) {
                            getDialogState()
                            isShaking = true
                            scope.launch {
                                val duration = 2000
                                val startTime = withFrameNanos { it }
                                var time: Long
                                do {
                                    time = withFrameNanos { it }
                                    val elapsed = (time - startTime) / 1_000_000 // to millis
                                    val progress = elapsed / duration.toFloat()
                                    val angle = sin(progress * 20 * PI).toFloat() * 10f // 흔들림: 주기 * 진폭
                                    shakeDegrees.snapTo(angle)
                                } while (elapsed < duration)
                                shakeDegrees.snapTo(0f)
                                isShaking = false
                                isOpenDialog = true
                            }
                        }
                    }
                ),
            contentDescription = null
        )

        Text(
            text = if (!isOpenDialog && !isShaking) "탭해서 특별한 레시피 보러가기" else "",
            modifier = Modifier
                .clickable(
                    onClick = navigateToMinseo
                )
                .padding(bottom = 20.dp)
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StoryDialog(
    imageUrl: String,
    name: String,
    title: String,
    story: String,
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
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp),
                    )

                    Text(
                        text = name,
                    )
                }

                Text(
                    text = title,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = story,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = onRetry,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "다시"
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(20.dp)
                    )

                    Button(
                        onClick = onRecipe,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "레시피"
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
    _36SOPKATHONANDROIDANDROID3Theme {
        DongminScreen(
            navigateToMinseo = {},
            dialogState = DialogState()
        )
    }
}