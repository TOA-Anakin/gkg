package eu.phamtheanh.gkg.entity

import java.time.LocalDateTime
import java.util.UUID
import jakarta.persistence.*

@Entity
@Table(name = "address")
data class Address(
    @Id
    var id: String = UUID.randomUUID().toString(),

    var street: String? = null,
    var number: String? = null,
    var district: String? = null,
    var city: String? = null,
    var state: String? = null,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null,

    @OneToOne
    @JoinColumn(name = "fk_student")
    var student: Student? = null
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