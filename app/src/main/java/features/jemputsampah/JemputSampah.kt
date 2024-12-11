package features.jemputsampah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecocycleapp.R
import common.button.ElevatedButtonExample
import common.button.FilledButtonExample
import common.textfield.AnotherTextField

@Composable
fun JemputSampah(navHostController: NavHostController, modifier: Modifier = Modifier) {
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
          .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
          .fillMaxWidth()
          .fillMaxHeight()
      ) {
        Column(
          modifier = Modifier.padding(bottom = 40.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ){
          ElevatedCard(
            elevation = CardDefaults.cardElevation(
              defaultElevation = 50.dp
            ),
            modifier = Modifier
              .padding(top = 80.dp, start = 40.dp, end = 40.dp)
              .fillMaxWidth()
              .shadow(20.dp, shape = RoundedCornerShape(30.dp)),
            colors = CardDefaults.elevatedCardColors(
              containerColor = Color.White,
              contentColor = Color.Black
            )
          ) {
            Column(
              modifier = Modifier.fillMaxWidth(),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Box(
                modifier = Modifier
                  .background(Color(0xFF007843), shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                  .fillMaxWidth()
              ) {
                Text(
                  "Silahkan Diisi !",
                  fontSize = 16.sp,
                  fontWeight = FontWeight.SemiBold,
                  fontFamily = FontFamily.Monospace,
                  color = Color.White,
                  modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .fillMaxWidth()
                )
              }
              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Berat Sampah (Kg)",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              AnotherTextField(
                modifier = Modifier
                  .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                  .fillMaxWidth(),
                R.string.berat
              )
              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Tanggal Penjemputan",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              AnotherTextField(
                modifier = Modifier
                  .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                  .fillMaxWidth(),
                R.string.date
              )
              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Alamat penjemputan",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              AnotherTextField(
                modifier = Modifier
                  .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                  .fillMaxWidth(),
                R.string.address
              )
              Spacer(modifier = Modifier.height(12.dp))
              Text(
                text = "Catatan Tambahan (Opsional)",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              AnotherTextField(
                modifier = Modifier
                  .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                  ,
                R.string.addnote
              )
              Spacer(modifier = Modifier.height(24.dp))
            }
          }
          Spacer(modifier = Modifier.weight(1f))
          ElevatedButtonExample(
            modifier = Modifier
              .padding(start = 40.dp, end = 40.dp)
              .fillMaxWidth()
              .shadow(20.dp, shape = RoundedCornerShape(30.dp)),
            text = R.string.submit,
            onClick = {navHostController.navigate("jemputsampah_3")}
          )
        }
      }
    }
  }
}

@Preview
@Composable
fun JemputSampahPreview() {
  JemputSampah(navHostController = NavHostController(LocalContext.current))
}