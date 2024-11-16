package common.button

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecocycleapp.R

@Composable
fun OutlinedButtonExample(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  @StringRes text: Int
  ) {
  OutlinedButton(
    onClick = { onClick() },
    modifier = modifier,
    border = BorderStroke(2.dp, Color(0xFF007843)),
  ) {
    Text(stringResource(text), color = Color(0xFF007843))
  }
}

@Composable
fun FilledButtonExample(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  @StringRes text: Int
) {
  Button(
    onClick = { onClick() },
    colors = ButtonDefaults.buttonColors(Color(0xFF007843)),
    modifier = modifier,
    ) {
    Text(stringResource(text), fontSize = 16.sp, fontWeight = FontWeight.Bold)
  }
}

@Composable
fun ElevatedButtonExample(
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  @StringRes text: Int
) {
  ElevatedButton(
    onClick = { onClick() },
    colors = ButtonDefaults.buttonColors(Color(0xFF007843)),
    elevation = ButtonDefaults.elevatedButtonElevation(
      defaultElevation = 16.dp, // Default elevation
      pressedElevation = 20.dp, // Elevation when pressed
      disabledElevation = 0.dp // Elevation when disabled
    ),
    modifier = modifier
  ) {
    Text(stringResource(text), fontSize = 16.sp, fontWeight = FontWeight.Bold)
  }
}

@Preview(showBackground = true)
@Composable
fun OutlinedButtonPreview() {
//  OutlinedButtonExample(
//    onClick = {},
//    text = R.string.daftar
//  )

  FilledButtonExample(
    onClick = {},
    text = R.string.masuk,
  )
}