package features.auth

import androidx.compose.foundation.layout.Arrangement
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
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.ecocycleapp.R
import common.button.ElevatedButtonExample
import common.button.FilledButtonExample
import common.form.LoginForm

@Composable
fun SignInPage(navHostController: NavHostController, modifier: Modifier = Modifier) {
  Scaffold(
    modifier = modifier.fillMaxSize(),  // Scaffold perlu Modifier yang sesuai
    content = {  contentPadding ->// Konten Scaffold harus berada di sini
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(contentPadding)
          .padding(16.dp)
          .padding(top = 200.dp, bottom = 40.dp)
      ) {
        Text(text = stringResource(R.string.signin), fontSize = 36.sp)
        Spacer(modifier = Modifier.height(64.dp))
        LoginForm()
        val annotatedString = buildAnnotatedString {
          append("Belum punya akun? ")
          pushStyle(SpanStyle(color = Color(0xFF007843)))
          append("Silahkan Mendaftar")
          pop()
        }

        ClickableText(
          modifier = Modifier.padding(top = 20.dp),
          text = annotatedString,
          onClick = {
            // Navigasi ke screen signup
            navHostController.navigate("signup")
          }
        )
        Spacer(modifier = Modifier.weight(1f))
        ElevatedButtonExample(
          modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxWidth()
            .width(280.dp)
            .shadow(20.dp, shape = RoundedCornerShape(30.dp)),
          text = R.string.masuk,
          onClick = {navHostController.navigate("home")}
        )
      }
    }
  )
}

@Preview
@Composable
fun SigninPagePreview() {
  SignInPage(navHostController = NavHostController(LocalContext.current))
}
