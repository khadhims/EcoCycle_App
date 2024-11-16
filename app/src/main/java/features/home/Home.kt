package features.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecocycleapp.R
import common.card.CardPrompt
import common.cardScreen.CardScreenUi


@Composable
fun Home(modifier: Modifier = Modifier) {
  Scaffold { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding).background(color = Color(0xFFF0F0F0))) {
      Box {
        Column() {
          Box(
            modifier = Modifier
              .height(260.dp)
              .fillMaxWidth()
              .background(
                color = Color(0xFF007843),
                shape = RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp)
              )
          ) {
            Column(
              modifier = Modifier.padding(horizontal = 20.dp)
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()  // Menambahkan fillMaxWidth agar Row memenuhi Box
                  .padding(PaddingValues(top = 20.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column {
                  Text(
                    "Selamat Datang",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                    "Joko",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                  )
                }
                Box(
                  modifier = Modifier
                    .size(60.dp)  // Menggunakan size() untuk kotak putih agar ukurannya seragam
                    .background(
                      color = Color.White,
                      shape = RoundedCornerShape(30.dp)
                    )
                ) {}
              }
              Spacer(modifier = Modifier.height(20.dp))
              Box (
                Modifier
                  .height(50.dp)
                  .fillMaxWidth()
                  .background(color = Color.White, shape = RoundedCornerShape(30.dp))
                  .padding(vertical = 10.dp, horizontal = 20.dp)
                , contentAlignment = Alignment.CenterStart
              ) {
                Row(verticalAlignment = Alignment.CenterVertically){
                  Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "", tint = Color.Black)
                  Spacer(Modifier.width(10.dp))
                  Text("Bonto Makkio", fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                }
              }
            }
          }
        }
      }
    }
    Box (
      Modifier
        .padding(PaddingValues(top = 190.dp, start = 60.dp, end = 60.dp ))
        .background(color = Color.White, shape = RoundedCornerShape(30.dp))
        .height(150.dp).width(450.dp)
        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
    ) {
      CardPrompt(
        modifier = Modifier.padding(8.dp),
        text = R.string.CardPrompt,
        drawable = R.drawable.trash_bin
      )
    }
    Box(
      Modifier
        .padding(PaddingValues(top = 360.dp, start = 60.dp, end = 220.dp ))
        .background(color = Color.White, shape = RoundedCornerShape(40.dp))
        .height(45.dp)
        .width(400.dp)
        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(40.dp)),
      contentAlignment = Alignment.Center
    ) {
      Row(
        modifier.padding(horizontal = 1.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
        ) {
        Image(
          painter = painterResource(R.drawable.coins),
          contentDescription = null,
          contentScale = ContentScale.Crop,
          modifier = Modifier.size(40.dp).padding(6.dp)
        )
        Text(
          "Rp 20.000",
          fontWeight = FontWeight.Bold,
          fontSize = 14.sp
        )
      }
    }
    Box(
      Modifier
        .padding(PaddingValues(top = 360.dp, start = 220.dp, end = 60.dp ))
        .background(color = Color.White, shape = RoundedCornerShape(40.dp))
        .height(45.dp)
        .width(400.dp)
        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(40.dp)),
      contentAlignment = Alignment.Center
    ) {
      Row(
        modifier.padding(horizontal = 1.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
      ) {
        Image(
          painter = painterResource(R.drawable.garbage),
          contentDescription = null,
          contentScale = ContentScale.Crop,
          modifier = Modifier.size(40.dp).padding(6.dp)
        )
        Text(
          "Anggota",
          fontWeight = FontWeight.Bold,
          fontSize = 14.sp
        )
      }
    }
    Box(
      Modifier
        .padding(PaddingValues(top = 420.dp, start = 20.dp, end = 20.dp))
        .background(color = Color.White)
        .height(400.dp)
        .fillMaxWidth(),
      contentAlignment = Alignment.CenterStart
    ) {
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalAlignment = Alignment.Start
      ) {
        Text(
          "Menu Utama",
          modifier = Modifier.padding(start = 4.dp),
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold,
        )
        CardScreenUi()
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
  Home()
}



