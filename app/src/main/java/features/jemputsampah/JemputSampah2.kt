package features.jemputsampah
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecocycleapp.R
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme
import common.button.ElevatedButtonExample
import common.textfield.BackMain

@Composable
fun TukarSaldo(modifier: Modifier = Modifier) {
    val username by remember { mutableStateOf(TextFieldValue("")) }
    val phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    val address by remember { mutableStateOf(TextFieldValue("")) }


    Box(
        modifier
            .fillMaxSize()
            .background(color = Color(0xFF007843))
    ) {
        BackMain()

        Box(
            modifier
                .padding(top = 60.dp, bottom = 60.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White, shape = RoundedCornerShape(30.dp))
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
                    .padding(start = 8.dp, top = 12.dp)
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

                TextFieldWithUnderline(
                    label = "Nama Pengguna",
                    value = username,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextFieldWithUnderline(
                    label = "No HP",
                    value = phoneNumber,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextFieldWithUnderline(
                    label = "Alamat",
                    value = address,
                    onValueChange = {}
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithUnderline(
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp , end = 15.dp, top = 10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Color.Black,
        ),
        singleLine = true
    )
}


@Preview
@Composable
private fun TukarSaldoPreview() {
    EcoCycleAppTheme {
        TukarSaldo()
    }
}