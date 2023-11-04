package lotto

import camp.nextstep.edu.missionutils.Console

class LottoController(private val customer : Customer) {
    fun run(){
        customerPay()
    }

    private fun customerPay() {
        CustomerInput.showPayInputMessage()
        val payment = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException(Message.ERROR_INPUT_STRING_OR_BLANK.messageText)
        customer.setPay(payment)
    }
}