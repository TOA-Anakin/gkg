package eu.phamtheanh.gkg.entity

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import jakarta.persistence.*

@Entity
@Table(name = "student")
data class Student(
    @Id
    var id: String = UUID.randomUUID().toString(),

    var name: String? = null,
    var email: String? = null,
    var birthday: LocalDate? = null,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null,

    @OneToOne(mappedBy = "student", cascade = [CascadeType.ALL], orphanRemoval = true)
    var address: Address? = null
) {
    @PrePersist
    fun prePersist() {
        createdAt = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}