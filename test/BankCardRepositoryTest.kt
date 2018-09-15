import models.BankCard
import org.junit.Test
import repositories.BankCardRepository

class BankCardRepositoryTest{
    @Test
    fun findByCardNumber(){
        val bankCardRepository = BankCardRepository()
        val cardNumber = "6231445"
        val givenBankCard = BankCard(2, 2, cardNumber, 2345)
        val foundBankCard = bankCardRepository.findByCardNumber(cardNumber)
        assert(foundBankCard.equals(givenBankCard))
    }
}