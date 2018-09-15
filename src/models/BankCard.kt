package models

data class BankCard(
        val cardId: Int,
        val customerId: Int,
        val number: String,
        val pin: Int
)