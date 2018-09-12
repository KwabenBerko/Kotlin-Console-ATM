
class Atm {
    private lateinit var bankCard: BankCard
    private lateinit var customer: Customer
    private lateinit var bankAccount: BankAccount
    private val bankCardRepository = BankCardRepository()
    private val customerRepository = CustomerRepository()
    private val bankAccountRepository = BankAccountRepository()

    fun start(){
        println()
        println("---------------------------------------------------------------------")
        print("Welcome to the Kotlin Bank! \nKindly enter your card number to continue: ")
        val cardNumber = readLine()
        if(!cardNumber?.trim().equals("")){
            bankCard = bankCardRepository.findByCardNumber(cardNumber.toString())
            customer = customerRepository.findById(bankCard.customerId)
            bankAccount = bankAccountRepository.findByCustomerId(customer.customerId)
            println("Welcome back, ${customer.firstName} ${customer.lastName}!")
            showAtmOptionsToAccountHolder()
        }
    }

    private fun showAtmOptionsToAccountHolder() {
        println("---------------------------------------------------------------------")
        println("1.Check Balance \n2.Withdraw cash \n3.Deposit cash \n4.Exit\n")
        print("Select an option [1-4]: ")

        val option = readLine()

        when(option){
            "1" -> checkBalance()
            "2" -> withdraw()
            "3" -> deposit()
            "4" -> start()
        }
    }

    private fun deposit(){
        print("Enter amount to deposit: GHC ")
        val amountToDeposit = readLine()
        if(amountToDeposit != null){
            bankAccountRepository.deposit(bankAccount, amountToDeposit.toDouble())
        }

        if(isPinValid()){
            println("GHC $amountToDeposit successfully deposited")
            checkBalance()
        }
    }

    private fun withdraw(){
        print("Enter amount to withdraw: GHC ")
        val amountToWithdraw = readLine()
        if(amountToWithdraw != null){
            bankAccountRepository.withdraw(bankAccount, amountToWithdraw.toDouble())
        }

        if(isPinValid()){
            println("GHC $amountToWithdraw successfully withdrawn")
            checkBalance()
        }
    }

    private fun checkBalance(){
        val balance = bankAccountRepository.getBalance(bankAccount)
        if(isPinValid()){
            println("Your balance is GHC $balance")
            showAtmOptionsToAccountHolder()
        }
    }


    private fun isPinValid(): Boolean{
        print("Enter pin: ")
        val pin = readLine()
        if(pin != null){
            if(bankCard.pin == pin.toInt()){
                return true
            }
        }
        return false
    }



}