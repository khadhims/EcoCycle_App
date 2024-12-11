package data

import java.time.LocalDate

data class JualSampahModel(
  val name: String = "",
  val weight: Int = 1,
  val date: LocalDate = LocalDate.now(),
  val address: String = "",
  val activeNumber: String = "",
  val note: String = ""
)
