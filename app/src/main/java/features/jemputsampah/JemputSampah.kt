package features.jemputsampah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import common.textfield.AnotherTextField
import common.textfield.BackMain

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
      BackMain(navHostController = navHostController)
      }
      Box(
        modifier = modifier
          .padding(top = 110.dp)
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
              modifier = Modifier
                .fillMaxWidth()
                .height(420.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Box(
                modifier = Modifier
                  .background(Color(0xFF007843), shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                  .fillMaxWidth()
              ) {
                Text(
                  "Informasi Sampah !",
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
                text = "1. Organik",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "Sampah organik adalah sampah yang berasal dari sisa-sisa makhluk hidup, baik hewan , tanaman maupun manusia",
                fontSize = 12.sp,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "2. Logam",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "Limbah yang dimana keberadaannya dalam jumlah tertentu sangat dibutuhkan oleh organisme hidup, namun dalam jumlah yang berlebihan dapat menimbulkan efek racun",
                fontSize = 12.sp,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "3. Elektrikus",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "Limbah dari bekas peralatan elektronik yang mengandung bahan berbahaya dan beracun",
                fontSize = 12.sp,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "4. Plastik",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "Semua barang bekas atau tidak terpakai yang materialnya diproduksi dari bahan kimia tak terbarukan",
                fontSize = 12.sp,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "5. Kertas",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )
              Spacer(modifier = Modifier.height(5.dp))
              Text(
                text = "Jenis sampah anorganik yang terdiri dari kertas yang sudah tidak terpakai",
                fontSize = 12.sp,
                modifier = Modifier
                  .padding(horizontal = 16.dp)
                  .fillMaxWidth()
              )


            }
          }
          Spacer(modifier = Modifier.weight(1f))
        }
      }
    }
  }

@Preview
@Composable
fun JemputSampahPreview() {
  JemputSampah(navHostController = NavHostController(LocalContext.current))
}