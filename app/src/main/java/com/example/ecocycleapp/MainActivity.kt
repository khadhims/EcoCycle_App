package com.example.ecocycleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme
import data.data_source.EcoCycleData
import features.auth.SignInPage
import features.home.Home
import navigation.Navigation

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      Navigation()
    }
  }
}
