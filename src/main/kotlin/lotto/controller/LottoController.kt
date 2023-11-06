package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.Customer
import lotto.model.Lotto
import lotto.model.Store
import lotto.model.Winning
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT
import lotto.utils.Validate.validateBonusNumber
import lotto.utils.Validate.validatePay
import lotto.utils.Validate.validateWinningNumber
import lotto.view.InputView.printBonusNumberInputMessage
import lotto.view.InputView.printPayInputMessage
import lotto.view.InputView.printWinningNumberInputMessage
import lotto.view.OutPutView.printProduceLottoResult


class LottoController {
    private val customer: Customer = Customer()
    private val store: Store = Store()
    private val winning: Winning = Winning()

    fun run() {
        inputCustomerPay()
        produceLotto()
        printLotto()
        inputWinningNumber()
        inputBonusNumber()
    }

    private fun inputCustomerPay() {
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

    private fun inputWinningNumber(){
        printWinningNumberInputMessage()
        val newWinningNumber = Console.readLine()
        validateWinningNumber(newWinningNumber)
        winning.setWinningNumber(newWinningNumber.split(",").map { it.trim().toInt() })
    }

    private fun inputBonusNumber(){
        printBonusNumberInputMessage()
        val newBonusNumber = Console.readLine()
        val winningNumber = winning.getWinningNumber()
        validateBonusNumber(newBonusNumber, winningNumber)
        winning.setBonusNumber(newBonusNumber.toInt())
    }
}