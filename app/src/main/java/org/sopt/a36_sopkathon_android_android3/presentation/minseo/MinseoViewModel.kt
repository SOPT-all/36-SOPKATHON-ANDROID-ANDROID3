package org.sopt.a36_sopkathon_android_android3.presentation.minseo

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.a36_sopkathon_android_android3.data.service.ServicePool

class MinseoViewModel : ViewModel() {
    private val minseoService by lazy { ServicePool.minseoService }

    private val _scrapList = mutableStateListOf<ScrapInfo>()
    val scrapList: List<ScrapInfo> = _scrapList

    fun getScrapList() {
        viewModelScope.launch {
            runCatching {
                minseoService.getScrapList()
            }.onSuccess {
                it.data?.recipe_list?.map { dto ->
                    ScrapInfo(
                        imageUrl = dto.thumbnail_image,
                        foodTitle = dto.recipe_name,
                        location = dto.recipe_owner_address,
                        level = dto.recipe_level,
                        time = dto.recipe_time
                    )
                }?.let { mappedList ->
                    _scrapList.clear()
                    _scrapList.addAll(mappedList)
                }
            }.onFailure {
                    Log.d("ㅋㅋ", "getScrapList: $it")
            }
        }
    }
}

    data class ScrapInfo(
        val imageUrl: String,
        val foodTitle: String,
        val location: String,
        val level: Int,
        val time: String
    )