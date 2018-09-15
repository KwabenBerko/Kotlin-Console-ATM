import models.Customer
import org.junit.Test
import repositories.CustomerRepository

class CustomerRepositoryTest{
    @Test
    fun findById(){
        val customerRepository = CustomerRepository()
        val givenCustomer = Customer(1, "Kwabena", "Berko")
        val foundCustomer = customerRepository.findById(1)
        assert(foundCustomer.equals(givenCustomer))
    }
}
