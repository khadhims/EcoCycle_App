package features.event

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import common.textfield.BackMain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TukarSaldo(navHostController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(color = Color(0xFF007843))
    ) {
        BackMain(navHostController = navHostController)

        Box(
            modifier
                .padding(top = 60.dp, bottom = 60.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White, shape = RoundedCornerShape(30.dp))
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(25.dp)
                            .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
                    ) {
                        Text(
                            "Rp 20.000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(vertical = 10.dp, horizontal = 20.dp)
                        )
                    }

                }
                Spacer(modifier = Modifier.height(50.dp))
                Text("Masukkan No Rek"
                    ,fontSize = 15.sp
                    ,fontWeight = FontWeight.Bold
                    ,modifier = Modifier.padding(start = 10.dp))

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .padding(start = 8.dp , end = 8.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(
                            color = Color.LightGray, // warna background abu-abu
                            shape = RoundedCornerShape(24.dp) // sudut melengkung
                        ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent, // border tidak terlihat saat fokus
                        unfocusedBorderColor = Color.Transparent // border tidak terlihat saat tidak fokus
                    ),
                    shape = RoundedCornerShape(24.dp) // sudut melengkung yang sama
                )
                Spacer(modifier = Modifier.height(100.dp))

                Text("Saldo yang ingin dicairkan"
                    ,fontSize = 15.sp
                    ,fontWeight = FontWeight.Bold
                    ,modifier = Modifier.padding(start = 10.dp))

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .padding(start = 8.dp , end = 8.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(
                            color = Color.LightGray, // warna background abu-abu
                            shape = RoundedCornerShape(24.dp) // sudut melengkung
                        ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent, // border tidak terlihat saat fokus
                        unfocusedBorderColor = Color.Transparent // border tidak terlihat saat tidak fokus
                    ),
                    shape = RoundedCornerShape(24.dp) // sudut melengkung yang sama
                )

                ElevatedButtonExample(
                    modifier = Modifier
                        .padding(start = 40.dp, end = 40.dp, top = 30.dp)
                        .fillMaxWidth()
                        .shadow(20.dp, shape = RoundedCornerShape(30.dp)),
                    text = R.string.submit,
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun TukarSaldoPagePreview() {
    TukarSaldo(navHostController = NavHostController(LocalContext.current))
}