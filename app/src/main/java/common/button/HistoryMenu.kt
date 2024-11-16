package common.button

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecocycleapp.ui.theme.EcoCycleAppTheme

data class TransaksiHistory(
    val name: String,
    val date: String,
    val type: String,
    val weight: String,
    val income: String,
    val status: String
)

@Composable
fun HistoryMain(modifier: Modifier = Modifier) {
    HistoryMenu()
}

fun HistoryMenu() {
    TODO("Not yet implemented")
}

@Composable
fun HistoryMenu(transaksiHistory: TransaksiHistory) {
    Column {
        Text(text = transaksiHistory.name)
        Text(text = transaksiHistory.date)
        Text(text = transaksiHistory.type)
        Text(text = transaksiHistory.weight)
        Text(text = transaksiHistory.income)
        Text(text = transaksiHistory.status)


    }

}

@Preview
@Composable
private fun HistoryMenuPreview() {
    EcoCycleAppTheme {
        HistoryMain()
    }
}