package eu.phamtheanh.gkg.service

import org.springframework.stereotype.Service
import org.springframework.beans.BeanUtils
import eu.phamtheanh.gkg.entity.Student
import eu.phamtheanh.gkg.repository.AddressRepository
import eu.phamtheanh.gkg.repository.StudentRepository

@Service
class StudentService(
    private val addressRepository: AddressRepository,
    private val studentRepository: StudentRepository
) {
    fun findById(id: String): Student {
        return studentRepository.findById(id).orElseThrow { NoSuchElementException("Student not found") }
    }

    fun save(student: Student): Student {
        studentRepository.save(student)
        addressRepository.save(student.address!!)
        return student
    }

    fun update(id: String, student: Student): Student {
        val studentDatabase = findById(id)
        BeanUtils.copyProperties(student, studentDatabase, "id", "createdAt", "updatedAt", "address")
        val address = student.address
        val databaseAddress = studentDatabase.address
        if (address != null && databaseAddress != null) {
            BeanUtils.copyProperties(address, databaseAddress, "id", "createdAt", "updatedAt", "student")
        }
        return studentRepository.save(studentDatabase)
    }

    fun deleteById(id: String) {
        studentRepository.delete(findById(id))
    }
}