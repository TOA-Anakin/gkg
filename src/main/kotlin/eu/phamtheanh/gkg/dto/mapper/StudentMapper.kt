package eu.phamtheanh.gkg.dto.mapper

import eu.phamtheanh.gkg.dto.CreateStudentDTO
import eu.phamtheanh.gkg.dto.StudentResponseDTO
import eu.phamtheanh.gkg.dto.UpdateStudentDTO
import eu.phamtheanh.gkg.entity.Address
import eu.phamtheanh.gkg.entity.Student

object StudentMapper {
    fun toEntity(dto: CreateStudentDTO): Student {
        val student = Student().apply {
            name = dto.name
            email = dto.email
            birthday = dto.birthday
        }

        val address = Address().apply {
            street = dto.street
            number = dto.number
            district = dto.district
            city = dto.city
            state = dto.state
            this.student = student
        }

        student.address = address

        return student
    }

    fun toEntity(dto: UpdateStudentDTO): Student {
        val student = Student().apply {
            id = dto.id
            name = dto.name
            email = dto.email
            birthday = dto.birthday
        }

        val address = Address().apply {
            street = dto.street
            number = dto.number
            district = dto.district
            city = dto.city
            state = dto.state
            this.student = student
        }

        student.address = address

        return student
    }

    fun toDTO(student: Student): StudentResponseDTO {
        return StudentResponseDTO().apply {
            id = student.id
            name = student.name
            email = student.email
            birthday = student.birthday
            createdAt = student.createdAt
            street = student.address?.street
            number = student.address?.number
            district = student.address?.district
            city = student.address?.city
            state = student.address?.state
        }
    }

    fun toDTO(students: List<Student>): List<StudentResponseDTO> {
        return students.map { toDTO(it) }
    }
}
