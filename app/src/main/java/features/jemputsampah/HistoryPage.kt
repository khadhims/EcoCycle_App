package features.jemputsampah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JemputSampah_Page3(modifier: Modifier = Modifier) {
  Scaffold { contentPadding ->
    Box(
      modifier = modifier
        .padding(contentPadding)
        .background(Color(0xFF007843))
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
      Row(
        modifier = modifier.padding(start = 8.dp, top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
      ) {
        Icon(
          imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
          contentDescription = null,
          tint = Color.White,
          modifier = Modifier.size(40.dp)
        )
        Text(
          text = "Kembali",
          color = Color.White,
          fontSize = 20.sp,
          fontWeight = FontWeight.SemiBold
        )
      }
      Box(
        modifier = modifier
          .padding(top = 60.dp)
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

}



@Preview(showBackground = true)
@Composable
fun JemputSampah_Page3Preview() {
  JemputSampah_Page3()
}