package navigation

import LogInViewModelFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clothloop.screens.signUp
import screens.logIn
import features.event.TukarSaldo
import features.home.Home
import features.jemputsampah.HistoryPage
import features.jemputsampah.InputVCA
import features.jemputsampah.JemputSampah
import features.jemputsampah.JemputSampah_3
import features.jemputsampah.JualSampahPage
import screens.History
import screens.JualSampah
import viewModel.JualSampahViewModel
import viewModel.logInViewModel
import viewModel.signUpViewModel


@Composable
fun Navigation(){
  val navController = rememberNavController()
  val context = LocalContext.current
  val logInViewModel: logInViewModel = viewModel(factory = LogInViewModelFactory(context))
  val signUpViewModel: signUpViewModel = viewModel()
  val JualSampahViewModel: JualSampahViewModel = viewModel()

  NavHost(navController = navController, startDestination = "signin") {
    composable("signin") {
      logIn(
        navHostController = navController,
        logInViewModel = logInViewModel,
        signUpViewModel = signUpViewModel
      )
    }
    composable("signup") {
      signUp(
        navHostController = navController,
        logInViewModel = logInViewModel,
        signUpViewModel = signUpViewModel
      )
    }
    composable("home") {
      Home(
        navHostController = navController,
        logInViewModel = logInViewModel,
        jualSampahViewModel = JualSampahViewModel
      )
    }
    composable("jualsampah") {
      JualSampah(
        navHostController = navController,
        logInViewModel = logInViewModel
      )
    }

    composable("historiPenjualan") {
      History(
        navController = navController,
        logInViewModel = logInViewModel
      )
    }
    composable("jemputsampah") { JemputSampah(navHostController = navController) }
    composable("jemputsampah_2") { JualSampahPage(navHostController = navController) }
    composable("historydeals") { HistoryPage(navHostController = navController) }
    composable("jemputsampah_3") { JemputSampah_3(navHostController = navController) }
    composable("tukar_saldo") { TukarSaldo(navHostController = navController) }
    composable("input_vca") { InputVCA(navHostController = navController) }
  }
}