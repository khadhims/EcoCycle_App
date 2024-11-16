package features.jemputsampah

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun TransactionScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        val transactions = listOf(
            Transaction("Joko", "10 Oktober 2024", "Sampah Logam", "2kg", "Rp 20.000", "Sukses"),
            Transaction("Joko", "8 Oktober 2024", "Sampah Daur Ulang", "1kg", "Rp 10.000", "Sukses")
        )

        LazyColumn {
            items(transactions) { transaction ->
                TransactionItem(transaction)
            }
        }
    }
}


@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors (containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = transaction.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = transaction.date, fontSize = 14.sp, color = Color.Black)
            Text(text = transaction.type, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Berat : ${transaction.weight}", fontSize = 14.sp)
                Text(text = "Pendapatan : ${transaction.income}", fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Status : ${transaction.status}",
                    fontSize = 14.sp,
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    modifier = Modifier.clickable { /* Aksi hapus */ }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun akjbakbwa() {
    EcoCycleAppTheme {
        TransactionScreen()
    }
}
