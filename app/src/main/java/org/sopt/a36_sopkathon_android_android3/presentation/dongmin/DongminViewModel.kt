package org.sopt.a36_sopkathon_android_android3.presentation.dongmin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.a36_sopkathon_android_android3.data.dto.response.StoryResponseDto
import org.sopt.a36_sopkathon_android_android3.data.service.ServicePool
import org.sopt.a36_sopkathon_android_android3.data.util.handleApiResponse
import org.sopt.a36_sopkathon_android_android3.presentation.dongmin.StoryResponseModel.RecipeOwner

class DongminViewModel : ViewModel() {
    val _dialogState = mutableStateOf(DialogState())
    val dialogState: DialogState
        get() = _dialogState.value

    fun getDialogState() {
        viewModelScope.launch {
            val result = ServicePool.dongminService.getStoryData().handleApiResponse()

            if (result.isSuccess) {
                _dialogState.value = _dialogState.value.copy(
                    data = result.getOrNull()?.toStoryResponseModel() ?: StoryResponseModel(
                        recipe_id = 0,
                        recipe_image = "",
                        recipe_owner = RecipeOwner(
                            recipe_owner_image = "",
                            recipe_owner_name = "",
                            recipe_owner_address = ""
                        ),
                        recipe_name = "비상~~~",
                        recipe_small_title = "오류발생~~~~~",
                        recipe_story = "큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?큰일이 났구요, 왜이런지 몰겠구요, 어떡하죠?",
                        recipe_level = 0,
                        cooking_time = ""
                    )
                )
            }
        }
    }
}

data class StoryResponseModel(
    val recipe_id: Int,
    val recipe_image: String,
    val recipe_owner: RecipeOwner,
    val recipe_name: String,
    val recipe_small_title: String,
    val recipe_story: String,
    val recipe_level: Int,
    val cooking_time: String,
) {
    data class RecipeOwner(
        val recipe_owner_image: String,
        val recipe_owner_name: String,
        val recipe_owner_address: String,
    )
}

fun StoryResponseDto.toStoryResponseModel(): StoryResponseModel {
    return StoryResponseModel(
        recipe_id = this.recipeId,
        recipe_image = this.recipeImage,
        recipe_story = this.recipeStory,
        recipe_small_title = this.recipeSmallTitle,
        recipe_level = this.recipeLevel,
        cooking_time = this.cookingTime,
        recipe_owner = RecipeOwner(
            recipe_owner_image = this.recipeOwner.recipeOwnerImage,
            recipe_owner_name = this.recipeOwner.recipeOwnerName,
            recipe_owner_address = this.recipeOwner.recipeOwnerAddress
        ),
        recipe_name = this.recipeName
    )
}

data class DialogState(
    val data: StoryResponseModel = StoryResponseModel(
        recipe_id = 0,
        recipe_image = "",
        recipe_owner = RecipeOwner(
            recipe_owner_image = "",
            recipe_owner_name = "",
            recipe_owner_address = ""
        ),
        recipe_name = "",
        recipe_small_title = "",
        recipe_story = "",
        recipe_level = 0,
        cooking_time = ""
    ),
)
