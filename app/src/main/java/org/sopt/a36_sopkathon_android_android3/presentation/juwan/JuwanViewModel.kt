package org.sopt.a36_sopkathon_android_android3.presentation.juwan

import androidx.lifecycle.ViewModel
import org.sopt.a36_sopkathon_android_android3.R
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.ScrapInfo

class JuwanViewModel : ViewModel() {

    val homeList = listOf(
        homeItem(
            homeId = "1",
            text = "영주",
            image = R.drawable.img_home_1
        ),
        homeItem(
            homeId = "2",
            text = "봉화",
            image = R.drawable.img_home_2
        ),
        homeItem(
            homeId = "3",
            text = "울진",
            image = R.drawable.img_home_3
        ),
        homeItem(
            homeId = "4",
            text = "상주",
            image = R.drawable.img_home_4
        ),
        homeItem(
            homeId = "5",
            text = "영양",
            image = R.drawable.img_home_5
        ),
        homeItem(
            homeId = "6",
            text = "영덕",
            image = R.drawable.img_home_6
        ),
        homeItem(
            homeId = "7",
            text = "구미",
            image = R.drawable.img_home_7
        ),
        homeItem(
            homeId = "8",
            text = "의성",
            image = R.drawable.img_home_8
        ),
        homeItem(
            homeId = "9",
            text = "경주",
            image = R.drawable.img_home_9
        ),
        homeItem(
            homeId = "10",
            text = "안동",
            image = R.drawable.img_home_10
        ),
        homeItem(
            homeId = "11",
            text = "김천",
            image = R.drawable.img_home_11
        ),
        homeItem(
            homeId = "12",
            text = "고령",
            image = R.drawable.img_home_12
        ),
        homeItem(
            homeId = "13",
            text = "영천",
            image = R.drawable.img_home_13
        ),
        homeItem(
            homeId = "14",
            text = "예천",
            image = R.drawable.img_home_14
        ),
        homeItem(
            homeId = "15",
            text = "포항",
            image = R.drawable.img_home_15
        ),


        )
}

data class homeItem(
    val homeId: String,
    val text: String,
    val image: Int,
)