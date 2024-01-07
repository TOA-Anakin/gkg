package eu.phamtheanh.gkg.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

interface IStudentDTO {
    @get:NotEmpty(message = "{NotEmpty.name}")
    val name: String

    @get:NotEmpty(message = "{NotEmpty.email}")
    val email: String

    @get:NotNull(message = "{NotNull.birthday}")
    @get:DateTimeFormat(pattern = "dd-MM-yyyy")
    val birthday: LocalDate?

    @get:NotEmpty(message = "{NotEmpty.street}")
    val street: String

    @get:NotEmpty(message = "{NotEmpty.number}")
    val number: String

    @get:NotEmpty(message = "{NotEmpty.district}")
    val district: String

    @get:NotEmpty(message = "{NotEmpty.city}")
    val city: String

    @get:NotEmpty(message = "{NotEmpty.state}")
    val state: String
}