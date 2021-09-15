package eigthyears.studio.ktspringnonblocking.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("customer")
data class Customer(
    @Id
    var id: Long = 0,
    var first_name: String = "",
    var last_name: String = "",
    var age: Int = 0
)