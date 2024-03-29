package eu.phamtheanh.gkg.repository

import eu.phamtheanh.gkg.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, String>