package viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import data.JualSampahModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.NumberFormat
import java.time.LocalDate
import java.util.Locale

class JualSampahViewModel: ViewModel() {
  var jualState = mutableStateOf(JualSampahModel())
    private set
  val db = FirebaseFirestore.getInstance()
  var _isSuccess = MutableStateFlow<Boolean>(false)
  val isSuccess: StateFlow<Boolean> get() = _isSuccess
  private var _isLoading = MutableStateFlow<Boolean>(false)
  val isLoading: StateFlow<Boolean> get() = _isLoading

  fun makeOrder(email: String, name: String, category: String, weight: Int, pickupDate: String, address: String, phoneNumber: String, note: String){
    _isLoading.value = true
    val orderRef = db.collection("makeSell")
    val data = hashMapOf(
      "email" to email,
      "name" to name,
      "category" to category,
      "weight" to weight,
      "pickupdate" to pickupDate,
      "address" to address,
      "phoneNumber" to phoneNumber,
      "note" to note,
      "status" to "",
      "setAt" to Timestamp.now(),
    )

    orderRef.add(data).addOnSuccessListener {
      _isSuccess.value = true
    }.addOnFailureListener {
      _isSuccess.value = false
      _isLoading.value = false
    }

  }

  fun setUsername(name: String){
    jualState.value = jualState.value.copy(name = name)
  }

  fun setAddresse(address: String){
    jualState.value = jualState.value.copy(address = address)
  }

  fun addWeight(){
    jualState.value = jualState.value.copy(weight = jualState.value.weight + 1)
  }

  fun minWeight(){
    jualState.value = jualState.value.copy(weight = jualState.value.weight - 1)
  }

  fun setPickUpDate(date: LocalDate){
    jualState.value = jualState.value.copy(date = date)
  }

  fun setActivedPhoneNumber(phoneNumber: String){
    jualState.value = jualState.value.copy(activeNumber = phoneNumber)
  }

  fun setAdditionalNotes(note: String){
    jualState.value = jualState.value.copy(note = note)
  }

  fun convertWeightToRupiah(weight: Int): String{
    val amount = weight * 10000
    val formatter = NumberFormat.getNumberInstance(Locale("id", "ID"))
    return formatter.format(amount)
  }

  fun setBackToFalse(status: Boolean){
    _isSuccess.value = status
  }
}