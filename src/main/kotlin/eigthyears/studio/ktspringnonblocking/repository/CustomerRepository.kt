package eigthyears.studio.ktspringnonblocking.repository

import eigthyears.studio.ktspringnonblocking.model.Customer
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface CustomerRepository: ReactiveCrudRepository<Customer, Long> {

    @Query("SELECT * FROM CUSTOMER c where c.age = :age")
    fun findByAge(age: Int): Flux<Customer>
}