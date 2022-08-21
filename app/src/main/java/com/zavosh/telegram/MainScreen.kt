package com.zavosh.telegram

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.zavosh.telegram.ui.theme.H1Text
import com.zavosh.telegram.ui.theme.h1FontSize
import com.zavosh.telegram.ui.theme.sdp
import kotlinx.coroutines.launch


/**
 * Create by Mohammadreza Allahgholi
 *  Site: https://seniorandroid.ir
 */


@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()

    val pagerState = rememberPagerState(3)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButtonPosition = FabPosition.Center,
        scaffoldState = scaffoldState,
        content = {
            MainHorizontalPager(pagerState, modifier = Modifier.padding(it).fillMaxSize())
        },
        topBar = {
            Tabs(pagerState)
        },
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                backgroundColor = Color.Blue,
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                content = {
                    BottomNavigation {
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = null
                                )
                            },
                            onClick = {

                            },
                            selected = false
                        )

                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = null
                                )
                            },
                            onClick = {

                            },
                            selected = true
                        )
                    }
                }
            )
        },
        drawerContent = {

        }
    )
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "Home" to Icons.Default.Home,
        "Shopping" to Icons.Default.ShoppingCart,
        "Settings" to Icons.Default.Settings
    )
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        },
        tabs = {
            list.forEachIndexed { index, _ ->
                Tab(
                    icon = {
                        Icon(imageVector = list[index].second, contentDescription = null)
                    },
                    text = {
                        Text(
                            list[index].first,
                            color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainHorizontalPager(pagerState: PagerState,modifier: Modifier) {
    HorizontalPager(
        modifier = modifier, count = 3, state = pagerState
    ) { page ->
        when (page) {
            0 -> {
                BodyView()
            }
            1 -> {
                BodyView()
            }
            2 -> {
                BodyView()
            }
        }
    }
}


@Composable
fun BodyView() {

    val list = ArrayList<String>().apply {
        add("Jamshid")
        add("Leila")
        add("Ali")
        add("Melika")
        add("Mohammadreza")
        add("Jamshid")
        add("Leila")
        add("Ali")
        add("Melika")
        add("Mohammadreza")
        add("Jamshid")
        add("Leila")
        add("Ali")
        add("Melika")
        add("Mohammadreza")
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { name ->
                ColumnContent(name)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnContent(name: String) {

    val mContext = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(74.dp)
            .clickable(
                indication = rememberRipple(color = Color.Red),
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    Toast
                        .makeText(mContext, "Click", Toast.LENGTH_SHORT)
                        .show()
                }
            ),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        content = { CardItem(name) }
    )
}

@Composable
fun CardItem(name: String) {

    val mContext = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(Modifier.width(10.dp), color = Color.Transparent)
            Box(modifier = Modifier.size(45.dp)) {
                Card(
                    modifier = Modifier.size(45.dp),
                    shape = CircleShape,
                    border = BorderStroke(
                        1.dp,
                        Color.Black
                    ),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_avatar),
                        contentDescription = ""
                    )
                }
            }
            Divider(Modifier.width(10.dp), color = Color.Transparent)
            Column {
                Row {
                    Text(modifier = Modifier.clickable(
                        onClick = { Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show() }
                    ), text = name, fontSize = h1FontSize, color = Color.Blue)
                    Divider(modifier = Modifier.width(5.dp), color = Color.Transparent)
                    Text(text = "Family", fontSize = h1FontSize)
                }
                Text(text = "+989106768929", fontSize = 10.sp)
                H1Text("Custom text")
            }
        }
    }

}
