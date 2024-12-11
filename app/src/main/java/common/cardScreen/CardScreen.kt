package common.cardScreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecocycleapp.R
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme
import common.card.MainFeatureCardsUi

@Composable
fun CardScreenUi(navHostController: NavHostController, modifier: Modifier = Modifier) {
  val cardItems = listOf(
    DrawebleStringPair (
      drawable = R.drawable.street_sweeper,
      title = R.string.NamaFitur2,
      description = "Hubungi kami untuk mengambil sampah anda",
      destination = "jemputsampah_2"
    ),
    DrawebleStringPair (
      drawable = R.drawable.trash,
      title = R.string.NamaFitur1,
      description = "Menjual sampah anda dengan harga yang sesuai dengan kualitasnya",
      destination = "jemputsampah"
    ),
    DrawebleStringPair (
      drawable = R.drawable.money_bag,
      title = R.string.NamaFitur3,
      description = "Tukarkan poin dari sampah yang anda jual",
      destination = "tukar_saldo"
    ),
    DrawebleStringPair (
      drawable = R.drawable.data_cleaning,
      title = R.string.NamaFitur4,
      description = "Menjual sampah anda dengan harga yang sesuai dengan kualitasnya",
      destination = "historydeals"
    ),
  )

  LazyColumn(
    modifier = modifier
      .padding(2.dp)
      .fillMaxWidth(),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    content = {
      // Group items into pairs of two
      items(cardItems.chunked(1)) { rowItems ->
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .shadow(50.dp, shape = RoundedCornerShape(10.dp)),
          horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
          rowItems.forEach { item ->
            MainFeatureCardsUi(
              drawable = item.drawable,
              title = item.title,
              description = item.description,
              destination = item.destination,
              modifier = modifier
                .padding(vertical = 4.dp)
                .weight(1f) // Distribute equally between the two items
                .fillMaxWidth()
                .clickable {
                  navHostController.navigate(item.destination)
                }

            )
          }
        }
      }
    }
  )
}

data class DrawebleStringPair(
  @DrawableRes val drawable: Int,
  @StringRes val title: Int,
  val description: String,
  val destination: String
)

@Preview(showBackground = true)
@Composable
fun MainFeaturesCardPreview() {
  EcoCycleAppTheme {
    CardScreenUi(
      navHostController = rememberNavController(),
    )
  }
}