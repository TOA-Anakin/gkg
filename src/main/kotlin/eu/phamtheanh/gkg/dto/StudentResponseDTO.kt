package eu.phamtheanh.gkg.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period

@JsonInclude(JsonInclude.Include.NON_NULL)
data class StudentResponseDTO(
    var id: String? = null,
    var name: String? = null,
    var email: String? = null,
    var birthday: LocalDate? = null,
    var street: String? = null,
    var number: String? = null,
    var district: String? = null,
    var city: String? = null,
    var state: String? = null,
    var createdAt: LocalDateTime? = null
) {
    @get:JsonProperty("age")
    val age: Int?
        get() = birthday?.let { Period.between(it, LocalDate.now()).years }
}