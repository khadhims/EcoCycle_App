package common.cardScreen

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
import com.example.ecocycleapp.R
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme
import common.card.MainFeatureCardsUi

@Composable
fun CardScreenUi(modifier: Modifier = Modifier) {
  val cardItems = listOf(
    R.drawable.street_sweeper to R.string.NamaFitur1,
    R.drawable.garbage to  R.string.NamaFitur2,
    R.drawable.money_bag to R.string.NamaFitur3,
    R.drawable.data_cleaning to R.string.NamaFitur4
  ).map { DrawebleStringPair(it.first, it.second) }

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
              text = item.text,
              modifier = modifier
                .padding(vertical = 4.dp)
                .weight(1f) // Distribute equally between the two items
                .fillMaxWidth()

            )
          }
        }
      }
    }
  )
}

data class DrawebleStringPair(
  val drawable: Int,
  val text: Int
)

@Preview(showBackground = true)
@Composable
fun MainFeaturesCardPreview() {
  EcoCycleAppTheme {
    CardScreenUi()
  }
}