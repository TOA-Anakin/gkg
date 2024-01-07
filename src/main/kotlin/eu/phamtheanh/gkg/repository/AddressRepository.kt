package eu.phamtheanh.gkg.repository

import eu.phamtheanh.gkg.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<Address, String>