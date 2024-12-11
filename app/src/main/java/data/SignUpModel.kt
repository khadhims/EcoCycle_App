package data

data class SignUp(
  val name: String = "",
  val email: String = "",
  val password: String = "",
  val confirmPassword: String = "",
  val contact: String = "",
  val newAddress: String = "",
  val emailError: String = "",
  val passwordError: String = "",
  val confirmPasswordError: String = "",
  val nameError: String = "",
  val phoneNumberError: String = "",
  val isEmailExists: Boolean = false
)
