package features.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
  private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

  // Sign Up dengan Email dan Password
  fun signUpWithEmail(
    email: String,
    password: String,
    onResult: (Boolean, String?) -> Unit
  ) {
    viewModelScope.launch {
      firebaseAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            onResult(true, null)
          } else {
            onResult(false, task.exception?.message)
          }
        }
    }
  }

  // Sign In dengan Email dan Password
  fun signInWithEmail(
    email: String,
    password: String,
    onResult: (Boolean, String?) -> Unit
  ) {
    viewModelScope.launch {
      firebaseAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            onResult(true, null)
          } else {
            onResult(false, task.exception?.message)
          }
        }
    }
  }

  // Google Sign-In
  fun signInWithGoogle(idToken: String, onResult: (Boolean, String?) -> Unit) {
    val credential = GoogleAuthProvider.getCredential(idToken, null)
    viewModelScope.launch {
      firebaseAuth.signInWithCredential(credential)
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            onResult(true, null)
          } else {
            onResult(false, task.exception?.message)
          }
        }
    }
  }
}
