package common.appbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme

data class Transaction(
    val name: String,
    val date: String,
    val type: String,
    val weight: String,
    val income: String,
    val status: String
)

@Composable
fun HistoryPage(modifier: Modifier = Modifier) {

}

@Preview
@Composable
private fun HistoryPagePreview() {
    EcoCycleAppTheme {
        HistoryPage()
    }
}