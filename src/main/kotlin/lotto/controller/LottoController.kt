package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.Customer
import lotto.utils.Constants.ERROR_INPUT_STRING_OR_BLANK
import lotto.view.InputView.printPayInputMessage


class LottoController(private val customer : Customer = Customer()) {
    fun run(){
        customerPay()
    }

    private fun customerPay() {
        printPayInputMessage()
        val payment = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_INPUT_STRING_OR_BLANK)
        customer.setPay(payment)
    }
}