package org.sopt.a36_sopkathon_android_android3.presentation.dongmin


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.sopt.a36_sopkathon_android_android3.ui.theme._36SOPKATHONANDROIDANDROID3Theme

@Composable
fun DongminRoute(
    navigateToMinseo: () -> Unit,
) {
    DongminScreen(
        navigateToMinseo = navigateToMinseo
    )
}

@Composable
private fun DongminScreen(
    navigateToMinseo: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    var isOpenDialog by remember { mutableStateOf(false) }

    if (isOpenDialog) {
        StoryDialog(
            title = "경상남도 창원시 마산 회원구 양덕2동 김치찜 장인 박동민씨의 레시피",
            story = "김치찜은 김치와 돼지고기를 함께 찌는 요리로, 김치의 깊은 맛과 돼지고기의 풍미가 어우러져 맛있습니다. 특히, 마산의 김치찜은 그 지역 특유의 매운 양념과 신선한 재료로 유명합니다. 박동민씨는 이 전통적인 레시피를 현대적으로 재해석하여, 더욱 부드럽고 깊은 맛을 자랑하는 김치찜을 만들어냅니다." +
                    "이 김치찜은 깊은맛과 풍미가 어우러져, 밥과 함께 먹으면 더욱 맛있습니다. 또한, 김치찜은 건강에도 좋고, 특히 겨울철에 따뜻하게 즐기기 좋은 요리입니다. ",
            onDismissRequest = {
                isOpenDialog = false
            },
            onRetry = {
                scope.launch {
                    isOpenDialog = false
                    delay(1000)
                    isOpenDialog = true
                }

            },
            onRecipe = navigateToMinseo
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
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


        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Black)
                .clickable(
                    onClick = {
                        isOpenDialog = true
                    }
                )
        )

        Text(
            text = "탭해서 특별한 레시피 보러가기",
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
            navigateToMinseo = {}
        )
    }
}