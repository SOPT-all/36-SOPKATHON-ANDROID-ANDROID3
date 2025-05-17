package org.sopt.a36_sopkathon_android_android3.presentation.jiwoo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.a36_sopkathon_android_android3.data.service.ServicePool
import org.sopt.a36_sopkathon_android_android3.data.util.handleApiResponse

class JiwooViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: Boolean
        get() = _isLoading.value

    private var _jiwooData = MutableStateFlow(RecipeData())
    val state: RecipeData
        get() = _jiwooData.value

    init {
        getJiwooData()
    }


    fun getJiwooData() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = ServicePool.jiwooService.getRecipeData(1).handleApiResponse()

            if (result.isSuccess) {
                val recipeDto = result.getOrNull()
                val recipe = recipeDto?.toDomain()

                if (recipe != null) {
                    _jiwooData.value = _jiwooData.value.copy(
                        ingredients = recipe.ingredients,
                        ownerId = recipe.ownerId,
                        ownerImage = recipe.ownerImage,
                        ownerName = recipe.ownerName,
                        ownerResidence = recipe.ownerResidence,
                        recipeId = recipe.recipeId,
                        recipeLevel = recipe.recipeLevel,
                        recipeScrap = recipe.recipeScrap,
                        recipeStory = recipe.recipeStory,
                        recipeTime = recipe.recipeTime,
                        recipeTitle = recipe.recipeTitle,
                        recommends = recipe.recommends,
                        recipe = recipe.recipe,
                        reviews = recipe.reviews,
                        storyId = recipe.storyId,
                        thumbnailImage = recipe.thumbnailImage,
                        thumbnailUrl = recipe.thumbnailUrl
                    )

                    // delay(2000)
                    _isLoading.value = false
                }
            }
        }
    }
}

