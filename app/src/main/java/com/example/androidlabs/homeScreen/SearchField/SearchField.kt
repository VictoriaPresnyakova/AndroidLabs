package com.example.androidlabs.homeScreen.SearchField

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .background(Color.White)
        ,
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            content = {
                BasicTextField(
                    value = searchText,
                    singleLine = true,
                    onValueChange = {
                        searchText = it
                        onSearch(it)
                    },
                    textStyle = TextStyle(color = Color.Black),
                    modifier = Modifier
                        .weight(1f)
                )
                Image(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    modifier = Modifier.size(50.dp)
                        .padding(3.dp)

                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FieldPreview() {
    SearchField(
    ) { searchText ->
        // Обработка введенного текста поиска
    }
}