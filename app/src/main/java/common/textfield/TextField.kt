package common.textfield

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecocycleapp.R

@Composable
fun MyTextField(@StringRes text: Int) {
  var textInput by remember { mutableStateOf("") }
  OutlinedTextField(
    value = textInput,
    onValueChange = { newText -> textInput = newText },
    label = { Text(text = stringResource(text)) },
    placeholder = { Text(stringResource(text)) },
    colors = OutlinedTextFieldDefaults.colors(Color.Black)
  )
}

@Composable
fun AnotherTextField(modifier: Modifier = Modifier, @StringRes text: Int) {
  var textInput by remember { mutableStateOf("") }
  TextField(
    value = textInput,
    onValueChange = { newText -> textInput = newText },
    placeholder = {
      Text(
        stringResource(text),
        textAlign = TextAlign.Start,
        fontSize = 12.sp
      )},
    colors = TextFieldDefaults.colors(
      focusedContainerColor = Color.Transparent,
      unfocusedContainerColor = Color.Transparent,
      disabledContainerColor = Color.Transparent,
      cursorColor = Color(0xFF007843),
      focusedIndicatorColor = Color(0xFF007843),
      unfocusedTextColor = Color.Gray
    ),
    modifier = modifier.fillMaxWidth()
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myOutlinedTextField() {
  var textInput by remember { mutableStateOf("") }

  OutlinedTextField(
    value = textInput,
    onValueChange = { newText -> textInput = newText },
    placeholder = { Text(text = "892xxxxxxxxxx421") },
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 20.dp, end = 20.dp, top = 10.dp),
    colors = TextFieldDefaults.outlinedTextFieldColors(
      cursorColor = Color.Black,
    ),
    singleLine = true
  )
}

@Composable
fun ShowHidePasswordTextField() {

  var password by remember { mutableStateOf(value = "") }
  var showPassword by remember { mutableStateOf(value = false) }

  OutlinedTextField(
    value = password,
    onValueChange = { newText -> password = newText },
    label = {
      Text(text = "Password")
    },
    placeholder = { Text(text = "Ketik Password di Sini") },
    visualTransformation = if (showPassword) {
      VisualTransformation.None
    } else {
      PasswordVisualTransformation()
    },
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    trailingIcon = {
      if (showPassword) {
        IconButton(onClick = { showPassword = false }) {
          Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "hide_password"
          )
        }
      } else {
        IconButton(
          onClick = { showPassword = true }) {
          Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "hide_password"
          )
        }
      }
    }
  )
}

@Preview(showBackground = true)
@Composable
fun MyTextFieldPreview() {
  Scaffold(
    content = { contentPadding ->
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(contentPadding)
          .padding(16.dp)
      ) {
        MyTextField(R.string.login)
        Spacer(modifier = Modifier.height(8.dp))
        ShowHidePasswordTextField()
        Spacer(modifier = Modifier.height(8.dp))
        AnotherTextField(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
          R.string.berat)
      }
    }
  )
}
