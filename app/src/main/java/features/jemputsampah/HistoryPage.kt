package features.jemputsampah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import common.textfield.BackMain

@Composable
fun HistoryPage(navHostController: NavHostController, modifier: Modifier = Modifier) {
  Scaffold { contentPadding ->
    Box(
      modifier = modifier
        .padding(contentPadding)
        .background(Color(0xFF007843))
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
      BackMain(navHostController = navHostController)
      }
      Box(
        modifier = modifier
          .padding(top = 80.dp)
          .background(
            Color(0xFFF0F0F0),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
          )
          .fillMaxWidth()
          .fillMaxHeight()
      ) {
        Column(modifier = Modifier.fillMaxSize()) {
          Row(
            modifier = Modifier.fillMaxWidth()
          ) {
            Box(
              modifier = Modifier
                .padding(25.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
            ) {
              Text(
                "Rp 20.000", fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier
                  .padding(vertical = 10.dp, horizontal = 20.dp)
              )

            }
          }
          TransactionScreen()
        }
      }
  }
}


@Preview
@Composable
fun HistoryPage_Preview() {
  HistoryPage(navHostController = NavHostController(LocalContext.current))
}
