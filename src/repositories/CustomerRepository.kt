package repositories

import models.Customer

class CustomerRepository{

    private val CUSTOMERS = arrayListOf(
            Customer(1, "Kwabena", "Berko"),
            Customer(2, "Paul", "Appiah"),
            Customer(3, "Joshua", "Nkoom"),
            Customer(4, "Samuel", "Mensah")
    )

    fun findById(customerId: Number): Customer {
        return CUSTOMERS.filter {
            it.customerId == customerId
        }[0]
    }
}