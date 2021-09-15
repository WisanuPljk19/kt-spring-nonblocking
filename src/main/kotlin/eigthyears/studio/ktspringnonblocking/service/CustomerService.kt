package eigthyears.studio.ktspringnonblocking.service

import eigthyears.studio.ktspringnonblocking.model.Customer
import eigthyears.studio.ktspringnonblocking.repository.CustomerRepository
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service

@Service
class CustomerService(private val repository: CustomerRepository) {

    suspend fun findAll() = repository.findAll().asFlow()
    suspend fun findById(id: Long) = repository.findById(id).awaitFirstOrNull()
    suspend fun findByAge(age: Int) = repository.findByAge(age).asFlow()
    suspend fun add(customer: Customer) = repository.save(customer).awaitFirstOrNull()
    suspend fun update(id: Long, customer: Customer) =
        repository.findById(id)
            .flatMap {
                customer.id = it.id
                repository.save(customer)
            }.awaitFirstOrNull()
    suspend fun delete(id: Long) = repository.deleteById(id).awaitFirstOrNull()
}