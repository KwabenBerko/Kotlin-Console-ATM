import org.junit.Test

import org.junit.Assert.*

class BankAccountRepositoryTest {


    @Test
    fun shouldFindByCustomerId(){
        val bankAccountRepository = BankAccountRepository()
        val givenBankAccount = BankAccount(4, 4, 17000.0);
        val foundBankAccount = bankAccountRepository.findByCustomerId(4)
        assert(foundBankAccount.equals(givenBankAccount))
    }

    @Test()
    fun shouldWithdrawFromBankAccount() {
        val amountToWithdraw = 200.0
        val bankAccountRepository = BankAccountRepository()
        val bankAccount = BankAccount(1, 1, 600.0)
        bankAccountRepository.withdraw(bankAccount, amountToWithdraw)
        val currentBalance = bankAccountRepository.getBalance(bankAccount)
        assert(currentBalance == 400.0)
    }

    @Test(expected = Exception::class)
    fun shouldThrowExceptionWhenWithdrawingFromAccountWithInsufficientFunds(){
        val amountToWithdraw = 500.0
        val bankAccountRepository = BankAccountRepository()
        val bankAccount = BankAccount(2, 2, 0.0)
        bankAccountRepository.withdraw(bankAccount, amountToWithdraw)
    }

    @Test()
    fun shouldDepositIntoBankAccount(){
        val amountToDeposit = 500.0
        val bankAccountRepository = BankAccountRepository()
        val bankAccount = BankAccount(1, 1, 600.0)
        bankAccountRepository.deposit(bankAccount, amountToDeposit)
        val currentBalance = bankAccountRepository.getBalance(bankAccount)
        assert(currentBalance == 1100.0)
    }
}