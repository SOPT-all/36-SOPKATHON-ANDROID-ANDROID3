package org.sopt.a36_sopkathon_android_android3.presentation.dongmin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DongminViewModel : ViewModel() {
    val _dialogState = mutableStateOf(DialogState())
    val dialogState: DialogState
        get() = _dialogState.value

    fun getDialogState() {
        viewModelScope.launch {
            // 서버 연결 전 하드코딩
            _dialogState.value = _dialogState.value.copy(
                storyId = 0,
                imageUrl = "https://placehold.co/600x400.png",
                name = "장독이 할무니",
                title = "경상북도 경산시 정평동\n" +
                        "짱드삼 할머니의 들기름 막국수",
                story = "마당 한켠 돌장독 옆, 짱드삼 할머니는 들기름 한 방울로 계절을 버무렸습니다.\u2028메밀 면발에 정평동 햇빛과 바람, 그리고 그리움을 얹었죠. 입 안 가득 고소함이 퍼지면, 그건 할머니의 여름입니다.",
            )

            /* // 현재 서버통신하면 크래시 발생해서 주석처리
            val result = ServicePool.dongminService.getStoryData().handleApiResponse()


            if (result.isSuccess) {
                _dialogState.value = _dialogState.value.copy(
                    storyId = result.getOrNull()?.storyId ?: 0,
                    imageUrl = result.getOrNull()?.imageUrl ?: "",
                    name = result.getOrNull()?.name ?: "",
                    title = result.getOrNull()?.title ?: "",
                    story = result.getOrNull()?.story ?: "",
                )
            } else {
                _dialogState.value = _dialogState.value.copy(
                    storyId = 0,
                    imageUrl = "https://placehold.co/600x400.png",
                    name = "에러!!!!!!!!",
                    title = "비~~~~~~상~~~~~~",
                    story = "에러났어요 큰일났어요 살려주세요 에러났어요 큰일났어요 살려주세요 에러났어요 큰일났어요 살려주세요 에러났어요 큰일났어요 살려주세요 에러났어요 큰일났어요 살려주세요 에러났어요 큰일났어요 살려주세요 에러났어요 큰일났어요 살려주세요 에러났어요 큰일났어요 살려주세요 ",
                )
            }

             */
        }
    }
}

data class DialogState(
    val storyId: Int = 0,
    val imageUrl: String = "",
    val name: String = "",
    val title: String = "",
    val story: String = "",
)
