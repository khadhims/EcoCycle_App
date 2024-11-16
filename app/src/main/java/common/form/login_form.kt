package common.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.ecocycleapp.R
import common.textfield.MyTextField
import common.textfield.ShowHidePasswordTextField

@Composable
fun LoginForm(){
  Column(
    verticalArrangement = Arrangement.spacedBy(12.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ){
    MyTextField(R.string.login)
    ShowHidePasswordTextField()
  }
}