package viewModel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import data.Users

class logInViewModel(context: Context) : ViewModel() {
  private var _fetchData = MutableStateFlow(Users())
  val fetchData: StateFlow<Users> get() = _fetchData
  val authDb = FirebaseAuth.getInstance()
  val db = FirebaseFirestore.getInstance()
  private var _isLoading = MutableStateFlow<Boolean>(false)
  val isLoading: StateFlow<Boolean> get() = _isLoading
  private var _isLoggedin = MutableStateFlow(false)
  val isLoggedin: StateFlow<Boolean> get() = _isLoggedin

  private val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

  init {
    _isLoggedin.value = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    val email = sharedPreferences.getString(KEY_EMAIL, null)
    if (email != null) {
      fetchUserDataByEmail(email)
    }
  }

  suspend fun logIn(email: String, password: String) {
    _isLoading.value = true
    try {
      val authResult = authDb.signInWithEmailAndPassword(email, password).await()
      val uid = authResult.user?.uid
      if (uid != null) {
        db.collection("user").document(uid).addSnapshotListener { docSnapshot, e ->
          if (e != null) {
            println("Failed to listen to document: ${e.message}")
            _isLoggedin.value = false
            return@addSnapshotListener
          }

          if (docSnapshot != null && docSnapshot.exists()) {
            val profile = docSnapshot.toObject(Users::class.java) ?: Users()
            _fetchData.value = profile
            _isLoggedin.value = true

            sharedPreferences.edit().apply {
              putBoolean(KEY_IS_LOGGED_IN, true)
              putString(KEY_EMAIL, profile.email)
              apply()
            }
          } else {
            println("Document does not exist")
            _isLoggedin.value = false
            _isLoading.value = false
          }
        }
      }
    } catch (e: Exception) {
      _isLoggedin.value = false
      _isLoading.value = false
      println("Failed to login: ${e.message}")
    } finally {
      _isLoading.value = false
    }
  }

  private fun fetchUserDataByEmail(email: String) {
    db.collection("users")
      .whereEqualTo("email", email)
      .addSnapshotListener { querySnapshot, e ->
        if (e != null) {
          println("Error fetching user data: ${e.message}")
          _isLoggedin.value = false
          return@addSnapshotListener
        }

        if (querySnapshot != null && !querySnapshot.isEmpty) {
          val user = querySnapshot.documents[0].toObject(Users::class.java)
          if (user != null) {
            _fetchData.value = user
            _isLoggedin.value = true
          }
        } else {
          println("No user found with this email")
          _isLoggedin.value = false
        }
      }
  }

  fun logout() {
    authDb.signOut()
    _isLoggedin.value = false
    sharedPreferences.edit().clear().apply()
  }

  companion object {
    private const val KEY_IS_LOGGED_IN = "is_logged_in"
    private const val KEY_EMAIL = "username"
  }

  suspend fun editData(email: String, name: String, contact: String, address: String) {
    val doc = db.collection("users").whereEqualTo("email", email)
    val snapshot = doc.get().await()

    if (!snapshot.isEmpty) {
      for (document in snapshot.documents) {
        db.collection("users").document(document.id).update(mapOf(
          "name" to name,
          "contact" to contact,
          "address" to address
        )).await()
      }
    } else {
      println("No document found with the email: $email")
    }
  }
}