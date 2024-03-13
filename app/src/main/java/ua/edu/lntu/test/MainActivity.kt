package ua.edu.lntu.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text


import ua.edu.lntu.test.ui.theme.TestTheme

data class ListItem(val title: String, val description: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HorizontalList()
                    //VerticalScrollableList()
                    //VerticalGridList()
                }
            }
        }
    }
}

@Composable
fun HorizontalList()
{
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    )
    {
        items(20){
            index -> RowItems();
        }
    }
}

@Composable
fun RowItems()
{
    Column (
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Gray)
    ){
        val bg_image = painterResource(R.drawable.ic_launcher_background)
        Image(painter = bg_image, contentDescription = null)
        Text("Label")
        Text("Description")
    }
}
///////////////////////////////////////////////////////////////////////
@Composable
fun VerticalScrollableList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(20) {
            ListItem()
        }
    }
}

@Composable
fun ListItem() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Item Header")
            Text("Item Description")
            Text("Additional Info")
        }
    }
}

////////////////////////////////////////////////////////////////////
@Composable
fun VerticalGridList() {
    val itemCount = 100 // Заданное количество элементов списка
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(itemCount) { index ->
            GridItem()
        }
    }
}

@Composable
fun GridItem() {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Title")
            Text(text = "Description")
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////