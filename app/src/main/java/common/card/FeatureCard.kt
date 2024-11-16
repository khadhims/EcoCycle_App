package common.card
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecocycleapp.R
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme

@Composable
fun MainFeatureCardsUi (
  @DrawableRes drawable: Int,
  @StringRes text: Int,
  modifier: Modifier = Modifier
) {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 16.dp, // Default elevation
      pressedElevation = 20.dp, // Elevation when pressed
      disabledElevation = 0.dp
    ),
    modifier = modifier
      .fillMaxWidth()
      .height(80.dp),
    colors = CardDefaults.elevatedCardColors(
      containerColor = Color(0xFF007843),
      contentColor = Color.White
    ),
    shape = RoundedCornerShape(10.dp)
  ) {
    Row(
      modifier.padding(horizontal = 4.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceAround
    ){
      Image(
        painter = painterResource(drawable),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .size(60.dp)
          .padding(4.dp)

      )
      Spacer(modifier = Modifier.width(10.dp))
      Column(
        modifier.padding(vertical = 0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ){
        Text(
          text = "Jual Sampah",
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = "Silahkan jual sampah anda dengan harga yang sesuai dengan kualitasnya",
          fontSize = 12.sp,
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MainFeaturesCardPreview() {
  EcoCycleAppTheme {
    MainFeatureCardsUi(
      text = R.string.NamaFitur1,
      drawable = R.drawable.trash,
      modifier = Modifier.padding(8.dp)
    )
  }
}
