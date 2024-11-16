package common.button

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpinnerExample2() {
    val parentOptions = listOf("BCA", "BNI", "BRI", "Mandiri")
    var expandedState by remember { mutableStateOf(false) }

    var selectedOption by remember { mutableStateOf<String?>(null) }
    val myContext = LocalContext.current

    ExposedDropdownMenuBox(
        expanded = expandedState,
        onExpandedChange = { expandedState = !expandedState }
    ) {
        OutlinedTextField(
            value = selectedOption ?: "Select a Bank", // Show placeholder if no option is selected
            onValueChange = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState) },
            readOnly = true,
            textStyle = TextStyle.Default.copy(fontSize = 12.sp),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(start = 10.dp, end = 200.dp)
                .height(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF007843),
                unfocusedBorderColor = Color.LightGray,
                disabledBorderColor = Color.LightGray,
                cursorColor = Color(0xFF007843)
            )
        )

        ExposedDropdownMenu(
            modifier = Modifier
                .padding(horizontal = 40.dp),
            expanded = expandedState,
            onDismissRequest = { expandedState = false }
        ) {
            parentOptions.forEach { eachOption ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = eachOption,
                            fontSize = 12.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )
                    },
                    onClick = {
                        selectedOption = eachOption
                        expandedState = false
                        Toast.makeText(myContext, "$selectedOption selected", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Preview
@Composable
fun SpinnerExamplePreview2() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpinnerExample2()
    }
}


