package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import features.auth.SignInPage
import features.auth.SignUpPage
import features.event.TukarSaldo
import features.home.Home
import features.jemputsampah.HistoryPage
import features.jemputsampah.InputVCA
import features.jemputsampah.JemputSampah
import features.jemputsampah.JemputSampah_3
import features.jemputsampah.JualSampahPage


@Composable
fun Navigation(){
  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = "signin") {
    composable("signin") { SignInPage(navHostController = navController) }
    composable("signup") { SignUpPage(navHostController = navController) }
    composable("home") { Home(navHostController = navController) }
    composable("jemputsampah") { JemputSampah(navHostController = navController) }
    composable("jemputsampah_2") { JualSampahPage(navHostController = navController) }
    composable("historydeals") { HistoryPage(navHostController = navController) }
    composable("jemputsampah_3") { JemputSampah_3(navHostController = navController) }
    composable("tukar_saldo") { TukarSaldo(navHostController = navController) }
    composable("input_vca") { InputVCA(navHostController = navController) }
  }
}