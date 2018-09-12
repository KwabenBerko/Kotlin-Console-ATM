class BankCardRepository {

    private val BANK_CARDS = arrayListOf(
            BankCard(1, 1, "5789912", 1234),
            BankCard(2, 2, "6231445", 2345),
            BankCard(3, 3, "8709771", 3456),
            BankCard(4, 4, "3401255", 4567)
    )

    fun findByCardNumber(number: String): BankCard{
        return BANK_CARDS.filter {
            it.number == number
        }[0]
    }
}