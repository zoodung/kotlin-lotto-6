package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.Customer
import lotto.model.Lotto
import lotto.model.Store
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT
import lotto.utils.Validate.validatePay
import lotto.view.InputView.printPayInputMessage
import lotto.view.InputView.printWinningNumberInputMessage
import lotto.view.OutPutView.printProduceLottoResult


class LottoController {
    private val customer: Customer = Customer()
    private val store: Store = Store()

    fun run() {
        customerPayInput()
        produceLotto()
        printLotto()
        winningNumberInput()
    }

    private fun customerPayInput() {
        printPayInputMessage()
        val payment = Console.readLine()
        validatePay(payment)
        customer.setPay(payment.toInt())
    }

    private fun produceLotto() {
        val piece = customer.getPay() / LOTTO_PURCHASE_UNIT
        val newLottoCollection: MutableList<Lotto> = store.produceLottoNumber(piece)
        customer.setLottoCollection(newLottoCollection)
    }

    private fun printLotto() {
        val produceLottoResult = customer.getLottoCollection()
        printProduceLottoResult(produceLottoResult)
    }

    private fun winningNumberInput(){
        printWinningNumberInputMessage()
        val winningNumber = Console.readLine()

    }
}