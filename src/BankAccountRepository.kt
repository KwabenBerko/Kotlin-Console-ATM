class BankAccountRepository (){

    private var BANK_ACCOUNTS = mutableListOf(
            BankAccount(1, 1, 600.0),
            BankAccount(2, 2, 0.0),
            BankAccount(3, 3, 20.75),
            BankAccount(4, 4, 17000.0)
    )

    fun findByCustomerId(customerId: Number): BankAccount{
        return BANK_ACCOUNTS.filter {
            it.customerId == customerId
        }[0]
    }



    fun getBalance(bankAccount: BankAccount): Double{
        return BANK_ACCOUNTS[getIndex(bankAccount)].balance
    }

    fun withdraw(bankAccount: BankAccount, amount: Double){
        val foundBalance = getBalance(bankAccount)
        if(foundBalance < amount){
            throw Exception("Insufficient balance")
        }

        BANK_ACCOUNTS[getIndex(bankAccount)].balance -= amount
    }

    fun deposit(bankAccount: BankAccount, amount: Double){
        BANK_ACCOUNTS[getIndex(bankAccount)].balance += amount
    }

    private fun getIndex(bankAccount: BankAccount):Int{
        return BANK_ACCOUNTS.indexOf(BANK_ACCOUNTS.find {
            it.bankAccountId == bankAccount.bankAccountId
        })
    }

}