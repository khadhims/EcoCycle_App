package common.card

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecocycleapp.R

@Composable
fun CardPrompt(
  modifier: Modifier = Modifier,
  @StringRes text: Int,
  @DrawableRes drawable: Int
) {
  Surface(
    shape = MaterialTheme.shapes.large,
    color = Color.White ,
    modifier = modifier
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.width(450.dp).height(150.dp),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
      ) {
        stringResource(text).split(" ").forEach { char ->
          Text(
            text = char.toString(),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
          )
        }
      }
      Spacer(modifier = Modifier.width(8.dp))
      Image(
        painter = painterResource(drawable),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(100.dp).padding(4.dp)
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun CardPromptPreview() {
  CardPrompt(
    modifier = Modifier.padding(8.dp),
    text = R.string.CardPrompt,
    drawable = R.drawable.trash_bin
  )
}