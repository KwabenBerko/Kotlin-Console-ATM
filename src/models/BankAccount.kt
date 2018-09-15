package models

data class BankAccount (
        val bankAccountId: Int,
        val customerId: Int,
        var balance: Double
)