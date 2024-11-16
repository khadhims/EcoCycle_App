package features

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun DropDownList(
  itemList: List<String>,
  selectedIndex: Int,
  onItemClick: (Int) -> Unit
) {
  var showDropDown by rememberSaveable { mutableStateOf(true) }
  val scrollState = rememberScrollState()

  Column(
    modifier = Modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    // Making the Button
    Box(
      modifier = Modifier
        .background(Color.Green)
        .clickable { showDropDown = true }
        .clickable { showDropDown = !showDropDown },
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = itemList[selectedIndex],
        modifier = Modifier.padding(3.dp)
      )
    }
    // Drop Down List
    Box {
      if (showDropDown) {
        Popup(
          alignment = Alignment.TopCenter,
          properties = PopupProperties(excludeFromSystemGesture = true),
          onDismissRequest = { showDropDown = false }
        ) {
          Column(
            modifier = Modifier
              .heightIn(max = 90.dp)
              .verticalScroll(state = scrollState)
              .border(width = 1.dp, color = Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            itemList.onEachIndexed { index, item ->
              if (index != 0) {
                HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
              }
              Box(
                modifier = Modifier
                  .background(Color.White)
                  .width(300.dp)
                  .clickable {
                    onItemClick(index)
                    showDropDown = !showDropDown
                  },
                contentAlignment = Alignment.Center
              ) {
                Text(text = item)
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun DropDownListSample() {
  val itemList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
  var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

  val buttonModifier = Modifier.width(100.dp)

  Column(
    modifier = Modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    // Drop Down List
    DropDownList(
      itemList = itemList,
      selectedIndex = selectedIndex,
      onItemClick = { selectedIndex = it }
    )

    Text(
      text = "Anda telah memilih ${itemList[selectedIndex]}",
      textAlign = TextAlign.Center,
      modifier = Modifier
        .padding(3.dp)
        .fillMaxWidth()
        .background(Color.LightGray)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun DropDownListSamplePreview() {
  DropDownListSample()
}