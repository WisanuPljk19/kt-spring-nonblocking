package eigthyears.studio.ktspringnonblocking.presentation

import eigthyears.studio.ktspringnonblocking.model.Customer
import eigthyears.studio.ktspringnonblocking.service.CustomerService
import kotlinx.coroutines.FlowPreview
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.Flow

@RestController
@RequestMapping("customers")
class CustomerController {

    @Autowired lateinit var service: CustomerService

    @FlowPreview
    @GetMapping
    suspend fun findAll() = service.findAll()

    @GetMapping("/{id}")
    suspend fun findById(@PathVariable id: Long): Customer? {
        return service.findById(id)
    }

    @FlowPreview
    @GetMapping(params = ["age"])
    suspend fun findById(@RequestParam("age") age: Int) = service.findByAge(age)

    @PostMapping
    suspend fun add(@RequestBody customer: Customer) = service.add(customer)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Long,
                       @RequestBody customer: Customer) = service.update(id, customer)

    @DeleteMapping("/{id}")
    suspend fun update(@PathVariable id: Long) = service.delete(id)
}