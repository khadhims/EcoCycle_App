package screens

import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import viewModel.JualSampahViewModel
import viewModel.logInViewModel
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JualSampah(jualSampahViewModel: JualSampahViewModel = viewModel(), logInViewModel: logInViewModel = viewModel(), navHostController: NavHostController) {
  val scrollState = rememberScrollState()
  var showDropdown by remember { mutableStateOf(false) }
  var dropdownOffset by remember { mutableStateOf(Offset(0f, 0f)) }
  var dropdownWidth by remember { mutableStateOf(0) }
  var optionSelected by remember {
    mutableStateOf("")
  }
  val context = LocalContext.current
  val selectedDate = remember { mutableStateOf("No Date Selected") }
  val today = LocalDate.now()
  val year = today.year
  val month = today.monthValue - 1
  val day = today.dayOfMonth
  val coroutine = rememberCoroutineScope()
  val isSuccess by jualSampahViewModel.isSuccess.collectAsState()
  val loading by jualSampahViewModel.isLoading.collectAsState()

  LaunchedEffect(isSuccess){
    if(isSuccess){
      navHostController.navigate("home")
      jualSampahViewModel.setBackToFalse(false)
    }
  }

  val datePickerDialog = remember {
    DatePickerDialog(context as Context, { _, selectedYear, selectedMonth, selectedDayOfMonth ->
      val selectedDate = LocalDate.of(selectedYear, selectedMonth + 1, selectedDayOfMonth)
      jualSampahViewModel.setPickUpDate(selectedDate)
      Log.d("Selected Date", selectedDate.toString())
    }, year, month, day)
  }

  Column(
    Modifier
      .fillMaxSize()
      .background(color = Color.White)
      .verticalScroll(scrollState),
  ) {
    Box(
      Modifier
        .fillMaxWidth()
        .height(120.dp), contentAlignment = Alignment.BottomStart
    ) {
      Row(
        Modifier
          .fillMaxWidth()
          .padding(PaddingValues(start = 20.dp, bottom = 20.dp)),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
          contentDescription = "",
          tint = Color(0xFF007843),
          modifier = Modifier
            .size(40.dp)
            .clickable { navHostController.navigate("home") }
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
          text = "Jual Sampah",
          fontWeight = FontWeight.W900,
          color = Color(0xFF007843),
          fontSize = 20.sp
        )
      }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Column(
      Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
    ) {
      Box(
        Modifier
          .fillMaxWidth()
          .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))
          .background(color = Color.White, shape = RoundedCornerShape(10.dp))
      ) {
        Column {
          Box(
            Modifier
              .fillMaxWidth()
              .height(60.dp)
              .background(
                color = Color(0xFF007843),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
              )
          ) {
            Row(
              Modifier.padding(
                PaddingValues(
                  start = 12.dp,
                  top = 20.dp,
                  bottom = 20.dp
                )
              ), verticalAlignment = Alignment.CenterVertically
            ) {
              Spacer(modifier = Modifier.width(10.dp))
              Text(
                text = "Mohon isi data di bawah ini dengan benar",
                color = Color.White,
                fontSize = 18.sp
              )
            }
          }
          Column(Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) {
            Text(
              text = "Full Name",
              color = Color(0xFF007843),
              fontWeight = FontWeight.Bold,
              fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
              Modifier
                .fillMaxWidth()
                .height(50.dp)
            ) {
              TextField(value = jualSampahViewModel.jualState.value.name, onValueChange = { jualSampahViewModel.setUsername(it) },
                modifier = Modifier
                  .fillMaxSize(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent, focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                ), textStyle = TextStyle(color = Color.Black, fontSize = 16.sp), placeholder = {
                  Text(text = "", color = Color.Gray, fontSize = 13.sp)
                })
            }
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF007843))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
              text = "Waste Category",
              color = Color(0XFF0A4635),
              fontWeight = FontWeight.Bold,
              fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
              Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(
                  width = 2.dp,
                  color = Color(0xFF007843),
                  shape = RoundedCornerShape(10.dp)
                )
                .onGloballyPositioned { coordinates ->
                  val position = coordinates.positionInWindow()
                  dropdownOffset =
                    Offset(position.x, position.y + coordinates.size.height)
                  dropdownWidth = coordinates.size.width
                }
                .background(
                  color = Color.Transparent,
                  shape = RoundedCornerShape(10.dp)
                )
                .clickable { showDropdown = !showDropdown }, contentAlignment = Alignment.Center) {
              Row(
                Modifier
                  .fillMaxWidth()
                  .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = if(optionSelected == "") "Pilih kategori sampah" else optionSelected, color =  if(optionSelected == "") Color.Gray else Color.Black)
                Icon(
                  imageVector = Icons.Filled.KeyboardArrowDown,
                  contentDescription = "",
                )
              }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(Modifier.fillMaxWidth()) {
              Column(Modifier.weight(1f)) {
                Text(text = "Berat sampah", color =  Color(0xFF007843), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Box(
                  Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                  , contentAlignment = Alignment.Center) {
                  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    if(jualSampahViewModel.jualState.value.weight == 1){
                      Box(modifier = Modifier)
                    } else {
                      Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "", tint = Color.Black, modifier = Modifier
                        .size(20.dp)
                        .clickable { jualSampahViewModel.minWeight() })

                    }
                    Text(text = jualSampahViewModel.jualState.value.weight.toString(), color = Color.Black, fontSize = 16.sp)
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "", tint = Color.Black, modifier = Modifier
                      .size(20.dp)
                      .clickable { jualSampahViewModel.addWeight() })
                  }

                }
                HorizontalDivider(
                  Modifier.fillMaxWidth(),
                  thickness = 2.dp,
                  color = Color(0XFF0A4635)
                )
              }
              Spacer(modifier = Modifier.width(20.dp))
              Column(Modifier.weight(1f)) {
                Text(text = "Rp/Kilogram", color =  Color(0xFF007843), fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Box(
                  Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                  contentAlignment = Alignment.CenterStart) {
                  Row(
                    Modifier
                      .fillMaxWidth()
                      .padding(PaddingValues(start = 10.dp)), verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Rp", color = Color(0xFF007843))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = jualSampahViewModel.convertWeightToRupiah(jualSampahViewModel.jualState.value.weight), color = Color(0XFF0A4635))
                  }
                }
                HorizontalDivider(
                  Modifier.fillMaxWidth(),
                  thickness = 2.dp,
                  color = Color(0XFF0A4635)
                )
              }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
              text = "Tanggal pengambilan",
              color = Color(0xFF007843),
              fontWeight = FontWeight.Bold,
              fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
              Modifier
                .fillMaxWidth()
                .height(40.dp), contentAlignment = Alignment.Center) {
              Row(
                Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 5.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = jualSampahViewModel.jualState.value.date.toString(), color = Color.Black)
                Box(
                  Modifier
                    .height(25.dp)
                    .clickable {
                      datePickerDialog.show()
                    }
                    .width(50.dp)
                    .border(
                      width = 2.dp,
                      color = Color(0xFF007843),
                      shape = RoundedCornerShape(7.dp)
                    ), contentAlignment = Alignment.Center) {
                  Text(text = "Select", color = Color(0xFF007843))
                }
              }
            }
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF007843))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
              text = "Alamat",
              color = Color(0xFF007843),
              fontWeight = FontWeight.Bold,
              fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
              Modifier
                .fillMaxWidth()
                .height(50.dp))
            {
              TextField(value = jualSampahViewModel.jualState.value.address, onValueChange = { jualSampahViewModel.setAddresse(it) },
                modifier = Modifier
                  .fillMaxSize(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent, focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                ), textStyle = TextStyle(color = Color.Black, fontSize = 16.sp), placeholder = {
                  Text(text = "", color = Color.Gray, fontSize = 13.sp)
                })
            }
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF007843))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
              text = "No HP yang Aktif",
              color = Color(0xFF007843),
              fontWeight = FontWeight.Bold,
              fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
              Modifier
                .fillMaxWidth()
                .height(50.dp))
            {
              TextField(value = jualSampahViewModel.jualState.value.activeNumber, onValueChange = { jualSampahViewModel.setActivedPhoneNumber(it) },
                modifier = Modifier
                  .fillMaxSize(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent, focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                ), textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), placeholder = {
                  Text(text = "", color = Color.Gray, fontSize = 13.sp)
                })
            }
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF007843))
            Spacer(modifier = Modifier.height(20.dp))
            Text(
              text = "Notes (Optional)",
              color = Color(0xFF007843),
              fontWeight = FontWeight.Bold,
              fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(
              Modifier
                .fillMaxWidth()
                .height(50.dp)
            ) {
              TextField(value = jualSampahViewModel.jualState.value.note, onValueChange = { jualSampahViewModel.setAdditionalNotes(it) },
                modifier = Modifier
                  .fillMaxSize(), colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent, focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                ), textStyle = TextStyle(color = Color.Black, fontSize = 16.sp), placeholder = {
                  Text(text = "", color = Color.Gray, fontSize = 13.sp)
                })
            }
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF007843))
          }
        }
      }
    }
    Spacer(modifier = Modifier.height(20.dp))
    if(loading){
      Box(
        Modifier
          .height(50.dp)
          .width(240.dp)
          .background(color = Color(0xFF007843), shape = RoundedCornerShape(40.dp))
          .padding(horizontal = 20.dp)
          .align(Alignment.CenterHorizontally)
        , contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = Color.White, strokeWidth = 5.dp, modifier = Modifier.size(30.dp))
      }
    } else {
      Box(
        Modifier
          .height(50.dp)
          .width(240.dp)
          .background(color = Color(0xFF007843), shape = RoundedCornerShape(40.dp))
          .padding(horizontal = 20.dp)
          .align(Alignment.CenterHorizontally)
          .clickable {
            coroutine.launch {
              if (jualSampahViewModel.jualState.value.name.isNotEmpty() && optionSelected.isNotEmpty() && jualSampahViewModel.jualState.value.address.isNotEmpty() && jualSampahViewModel.jualState.value.activeNumber.isNotEmpty()) {
                jualSampahViewModel.makeOrder(
                  email = logInViewModel.fetchData.value.email,
                  name = jualSampahViewModel.jualState.value.name,
                  category = optionSelected,
                  weight = jualSampahViewModel.jualState.value.weight,
                  pickupDate = jualSampahViewModel.jualState.value.date.toString(),
                  address = jualSampahViewModel.jualState.value.address,
                  phoneNumber = jualSampahViewModel.jualState.value.activeNumber,
                  note = jualSampahViewModel.jualState.value.note
                )
              } else {
                println("bleee")
              }
            }
          }, contentAlignment = Alignment.Center
      ) {
        Text(
          text = "Submit",
          fontWeight = FontWeight.Bold,
          color = Color.White,
          fontSize = 18.sp
        )
      }
    }
    Spacer(modifier = Modifier.height(40.dp))
  }
  if (showDropdown) {
    DropdownOverlay(
      options = listOf("Organik", "Logam", "Elektrikus", "Plastik", "Kertas"),
      onOptionSelected = { option ->
        optionSelected = option
        showDropdown = false
        println("Selected: $option")
      },
      modifier = Modifier
        .offset { IntOffset(dropdownOffset.x.toInt(), dropdownOffset.y.toInt()) }
        .width(with(LocalDensity.current) { dropdownWidth.toDp() })
        .zIndex(1f)
    )
  }
}

@Composable
fun DropdownOverlay(
  options: List<String>,
  onOptionSelected: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  Column {
    Spacer(modifier = Modifier.height(7.dp))
    Box(
      modifier
        .wrapContentSize()
        .background(Color.White, RoundedCornerShape(10.dp))
        .border(2.dp, Color(0xFF007843), RoundedCornerShape(10.dp))
    ) {
      Column(Modifier.padding(10.dp)) {
        options.forEach { option ->

          Text(
            text = option,
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 5.dp)
              .clickable { onOptionSelected(option) },
            color = Color(0xFF007843),
            fontSize = 16.sp
          )
        }
      }
    }
  }
}