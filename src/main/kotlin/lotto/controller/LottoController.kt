package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.Customer
import lotto.model.Lotto
import lotto.model.Store
import lotto.utils.Constants.ERROR_INPUT_STRING_OR_BLANK
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT
import lotto.view.InputView.printPayInputMessage
import lotto.view.OutPutView.printProduceLottoResult


class LottoController {
    private val customer: Customer = Customer()
    private val store: Store = Store()

    fun run() {
        customerPay()
        produceLotto()
        printLotto()

    }

    private fun customerPay() {
        printPayInputMessage()
        val payment = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_INPUT_STRING_OR_BLANK)
        customer.setPay(payment)
    }

    private fun produceLotto() {
        val piece = customer.getPay() / LOTTO_PURCHASE_UNIT
        val newLottoCollection: MutableList<Lotto> = store.produceLottoNumber(piece)
        customer.setLottoCollection(newLottoCollection)
    }

    private fun printLotto() {
        val produceLottoResult = customer.getlottoCollection()
        printProduceLottoResult(produceLottoResult)
    }
}