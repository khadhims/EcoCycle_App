package features.jemputsampah

import android.widget.Spinner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecocycleapp.R
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme
import common.button.ElevatedButtonExample
import common.button.SpinnerExample
import common.button.SpinnerExample2
import common.button.SpinnerExample3
import common.textfield.BackMain
import common.textfield.MyTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JemputSampah_3(navHostController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(color = Color(0xFF007843))
    ) {
        BackMain(
            navHostController = navHostController,
            modifier.padding(top = 40.dp)
            )

        Box(
            modifier
                .padding(top = 100.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .height(400.dp)
                .background(color = Color.White, shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        ) {
            Column {
                Box(
                    modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                        )
                ) {
                    Row(modifier = modifier
                        .padding(start = 20.dp, top = 12.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp
                            ,contentDescription = null
                        )

                        Text(text = "Mohon Isi Data di bawah ini dengan benar", fontWeight = FontWeight.Bold)
                    }
                }
                Text(text = "Lama Berlangganan", fontSize = 15.sp , fontWeight = FontWeight.Bold , modifier = Modifier.padding(start = 36.dp , top = 20.dp))
                Spacer(modifier = Modifier.height(20.dp))
                SpinnerExample3()
                Spacer(modifier = Modifier.height(20.dp))
                Text("Metode Pembayaran", fontSize = 15.sp , fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 36.dp))
                Spacer(modifier = Modifier.height(20.dp))
                SpinnerExample2()
                ElevatedButtonExample(
                    modifier = Modifier
                        .padding(start = 40.dp, end = 40.dp, top = 30.dp)
                        .fillMaxWidth()
                        .shadow(20.dp, shape = RoundedCornerShape(30.dp)),
                    text = R.string.submit,
                    onClick = {
                        navHostController.navigate("input_vca")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun JemputSampah_3Preview() {
    JemputSampah_3(navHostController = NavHostController(LocalContext.current))
}
