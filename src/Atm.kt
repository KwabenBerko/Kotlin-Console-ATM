
class Atm {

    private lateinit var bankCard: BankCard
    private val cardRepository: CardRepository

    init {
        cardRepository = CardRepository()
    }

    fun start(){
        println()
        println("---------------------------------------------------------------------")
        println("Welcome to the Kotlin Bank! \nKindly enter your bankCard number to continue: ")
        val cardNumber = readLine()
        if(!cardNumber?.trim().equals("")){
            bankCard = cardRepository.findByCardNumber(cardNumber.toString())
            if(bankCard == null){
                //Find account from bankCard number
                //Find balance from account??
                return
            }
            val customer = CustomerRepository().findById(bankCard.customerId)
            if(customer == null){
                return
            }
            showAtmOptionsToAccountHolder(customer)
        }
    }

    private fun showAtmOptionsToAccountHolder(customer: Customer) {
        println("---------------------------------------------------------------------")
        println("Hello ${customer.firstName} ${customer.lastName}" +
                ", what would you like to do today?: \n1.Withdraw cash \n2.Deposit cash \n3.Exit")

        val option = readLine()

        when(option){
            "1" -> println("Withdrawing")
            "2" -> println("Depositing")
            "3" -> start()
        }
    }


}