package eu.phamtheanh.gkg.dto

import eu.phamtheanh.gkg.dto.IStudentDTO
import java.time.LocalDate

class CreateStudentDTO(
    override val name: String  = "",
    override val email: String  = "",
    override val birthday: LocalDate? = null,
    override val street: String  = "",
    override val number: String  = "",
    override val district: String  = "",
    override val city: String  = "",
    override val state: String  = ""
) : IStudentDTO