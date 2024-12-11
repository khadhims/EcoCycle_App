package viewModel

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import data.SignUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await

class signUpViewModel : ViewModel(){
  var signUpState = mutableStateOf(SignUp())
    private set
  var allFieldvalid = mutableStateOf(false)
    private set
  val db = FirebaseFirestore.getInstance()
  val auth = FirebaseAuth.getInstance()
  private var _isLoading = MutableStateFlow<Boolean>(false)
  val isLoading: StateFlow<Boolean> get() = _isLoading
  private var _isSignUpSuccess = MutableStateFlow<Boolean>(false)
  val isSignUpSuccess: StateFlow<Boolean> get() = _isSignUpSuccess

  suspend fun signUp(name: String, email: String, password: String, contact: String) {
    try {
      _isLoading.value = true
      val snapShot = db.collection("user").whereEqualTo("email", email).limit(1).get().await()
      if (snapShot.isEmpty) {
        val authResult = auth.createUserWithEmailAndPassword(email, password).await()
        val uid = authResult.user?.uid

        if (uid != null) {
          val data = hashMapOf(
            "name" to name,
            "email" to email,
            "contact" to contact,
          )
          db.collection("user").document(uid).set(data).await()
          _isSignUpSuccess.value = true
        } else {
          println("UID null.")
          _isLoading.value = false
        }
      } else {
        println("Email already exists.")
        _isLoading.value = false
      }
    } catch (e: Exception) {
      println("Error: ${e.localizedMessage}")
      _isLoading.value = false
    }
  }



  fun setName(name: String){
    signUpState.value = signUpState.value.copy(name = name)
    validateName()
  }

  fun setEmail(email: String){
    signUpState.value = signUpState.value.copy(email = email)
    validateEmail()
  }

  fun setPassword(password: String){
    signUpState.value = signUpState.value.copy(password = password)
    validatePassword()
  }

  fun setConfirmPassword(confirmPassword: String){
    signUpState.value = signUpState.value.copy(confirmPassword = confirmPassword)
    validateConfirmPassword()
  }

  fun setContact(contact: String){
    signUpState.value = signUpState.value.copy(contact = contact)
    validateContact()
  }

  fun setNewAddress(address: String){
    signUpState.value = signUpState.value.copy(newAddress = address)
  }

  fun validateName(){
    val name = signUpState.value.name.trim()
    signUpState.value = signUpState.value.copy(
      nameError = if (name.isEmpty()){
        "Name can't be empty"
      } else {
        ""
      }
    )
  }

  fun validateContact(){
    val phoneNumber = signUpState.value.contact.trim()
    signUpState.value = signUpState.value.copy(
      phoneNumberError = if (phoneNumber.isEmpty()){
        "Phone Number can't be empty"
      } else {
        ""
      }
    )
  }

  fun validateEmail(){
    val email = signUpState.value.email.trim()
    signUpState.value = signUpState.value.copy(
      emailError = if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        "Invalid email error"
      } else {
        ""
      }
    )
  }

  fun validatePassword(){
    val password = signUpState.value.password
    signUpState.value = signUpState.value.copy(
      passwordError = if (password.length < 8){
        "Password must be at least 8 characters"
      } else {
        ""
      }
    )
  }

  fun validateConfirmPassword() {
    val confirmPassword = signUpState.value.confirmPassword
    signUpState.value = signUpState.value.copy(confirmPasswordError = if (confirmPassword != signUpState.value.password){
      "password does not match"
    } else {
      ""
    })
  }

  fun validateAllFields(): Boolean {
    validateName()
    validateEmail()
    validatePassword()
    validateConfirmPassword()
    validateContact()


    val isNameValid= signUpState.value.nameError.isEmpty()
    val isEmailValid = signUpState.value.emailError.isEmpty()
    val isPasswordValid = signUpState.value.passwordError.isEmpty()
    val isConfirmPasswordValid = signUpState.value.confirmPasswordError.isEmpty()
    val isContactValid= signUpState.value.phoneNumberError.isEmpty()

    if (isNameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid && isContactValid){
      allFieldvalid.value = true
    }
    return isNameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid && isContactValid
  }

}