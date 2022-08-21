package com.zavosh.telegram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.zavosh.telegram.ui.theme.TelegramTheme
import com.zavosh.telegram.ui.theme.sdp
import kotlinx.coroutines.launch

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
//            val pagerState = rememberPagerState()
//            val coroutineScope = rememberCoroutineScope()
//            TabRow(
//                selectedTabIndex = pagerState.currentPage,
//                tabs = {
//                    for (tab in 1..3)
//                        Tab(
//                            selected = pagerState.currentPage == tab,
//                            onClick = {
//                                coroutineScope.launch {
//                                    pagerState.animateScrollToPage(0)
//                                }
//                            }
//                        ) {
//                            Text(text = tab.toString())
//                        }
//                }
//            )
//
//            HorizontalPager(
//                count = 3,
//                state = pagerState
//            ) { page ->
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center,
//                    content = {
//                        Text(text = "$page")
//                    }
//                )
//            }
        }
    }
}