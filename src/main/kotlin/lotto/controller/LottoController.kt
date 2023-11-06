package lotto.controller

import camp.nextstep.edu.missionutils.Console
import lotto.model.Customer
import lotto.model.Lotto
import lotto.model.Rank
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
    private val rank: Rank = Rank()

    fun run() {
        inputCustomerPay()
        produceLotto()
        printLotto()
        inputWinningNumbers()
        inputBonusNumber()
        ranksLotto()
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

    private fun inputWinningNumbers() {
        printWinningNumberInputMessage()
        val newWinningNumbers = Console.readLine()
        validateWinningNumber(newWinningNumbers)
        winning.setWinningNumbers(newWinningNumbers.split(",").map { it.trim().toInt() })
    }

    private fun inputBonusNumber() {
        printBonusNumberInputMessage()
        val newBonusNumber = Console.readLine()
        validateBonusNumber(newBonusNumber)
        winning.setBonusNumber(newBonusNumber.toInt())
    }

    private fun ranksLotto() {
        rank.analyzeLottoRanking(customer.getLottoCollection(), winning)
    }
}