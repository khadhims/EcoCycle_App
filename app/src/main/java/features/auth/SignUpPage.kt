package features.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecocycleapp.R
import common.button.ElevatedButtonExample
import common.form.SignUpForm

@Composable
fun SignUpPage(navHostController: NavHostController, modifier: Modifier = Modifier) {
  Scaffold(
    modifier = modifier.fillMaxSize(),  // Scaffold perlu Modifier yang sesuai
    content = {  contentPadding ->  // Konten Scaffold harus berada di sini
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(contentPadding)
          .padding(16.dp)
          .padding(vertical = 40.dp)
      ) {
        Text(text = stringResource(R.string.signup), fontSize = 36.sp)
        Spacer(modifier = Modifier.height(100.dp))
        SignUpForm()
        val annotatedString = buildAnnotatedString {
          append("Sudah punya akun? ")
          pushStyle(SpanStyle(color = Color(0xFF007843)))
          append("Silahkan Sign-In")
          pop()
        }
        ClickableText(
          modifier = Modifier.padding(top = 20.dp),
          text = annotatedString,
          onClick = {
            // Navigasi ke screen signup
            navHostController.navigate("signin")
          }
        )
        // Ini diasumsikan sebagai custom password text field
        Spacer(modifier = Modifier.weight(1f))
        ElevatedButtonExample(
          modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxWidth()
            .width(280.dp)
            .shadow(20.dp, shape = RoundedCornerShape(30.dp)),
          text = R.string.masuk,
          onClick = {
            navHostController.navigate("signin")
          }
        )
      }
    }
  )
}

@Preview
@Composable
fun SignUpPagePreview() {
  SignUpPage(navHostController = NavHostController(LocalContext.current))
}