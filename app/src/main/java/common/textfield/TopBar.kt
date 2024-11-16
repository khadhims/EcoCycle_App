package common.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
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

@Composable
fun BackMain(modifier: Modifier = Modifier) {
    Row( modifier = modifier.padding(start = 8.dp, top = 12.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically

        )
    {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier.size(40.dp)
    )
    Text(
        text = "Kembali",
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )

    }
}

@Preview
@Composable
private fun BackPreview() {
    EcoCycleAppTheme {
        BackMain()
    }
}