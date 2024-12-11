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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import common.textfield.AnotherTextField
import common.textfield.BackMain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TukarSaldo(navHostController: NavHostController, modifier: Modifier = Modifier) {
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
                .padding(top = 110.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White, shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 40.dp, top = 30.dp)
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
                Spacer(modifier = Modifier.height(20.dp))
                Text("Masukkan No Rek"
                    ,fontSize = 15.sp
                    ,fontWeight = FontWeight.Bold
                    ,modifier = Modifier.padding(start = 44.dp)
                )
                AnotherTextField(
                    modifier = Modifier
                        .padding(start = 44.dp, end = 44.dp, bottom = 8.dp)
                    ,
                    R.string.addnote
                )
                Spacer(modifier = Modifier.height(36.dp))
                Text("Saldo yang ingin dicairkan"
                    ,fontSize = 15.sp
                    ,fontWeight = FontWeight.Bold
                    ,modifier = Modifier.padding(start = 44.dp)
                )
                AnotherTextField(
                    modifier = Modifier
                        .padding(start = 44.dp, end = 44.dp, bottom = 8.dp)
                    ,
                    R.string.addnote
                )
                Spacer(modifier = Modifier.height(380.dp))
                ElevatedButtonExample(
                    modifier = Modifier
                        .padding(start = 40.dp, end = 40.dp)
                        .fillMaxWidth()
                        .shadow(20.dp, shape = RoundedCornerShape(30.dp)),
                    text = R.string.submit,
                    onClick = {
                        navHostController.navigate("home")
                    }
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