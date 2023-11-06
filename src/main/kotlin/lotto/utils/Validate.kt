package lotto.utils

import lotto.utils.Constants.ERROR_INPUT_BLANK
import lotto.utils.Constants.ERROR_INPUT_CHAR
import lotto.utils.Constants.ERROR_INPUT_DUPLICATE
import lotto.utils.Constants.ERROR_INPUT_LIST
import lotto.utils.Constants.ERROR_INPUT_RANGE
import lotto.utils.Constants.ERROR_INPUT_SIZE
import lotto.utils.Constants.ERROR_PAY_INPUT_MAXIMUM
import lotto.utils.Constants.ERROR_PAY_INPUT_MINIMUM
import lotto.utils.Constants.ERROR_PAY_INPUT_UNIT
import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Constants.LOTTO_NUMBER_SIZE
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT
import lotto.utils.Constants.MAX_LOTTO_NUMBER
import lotto.utils.Constants.MAX_PURCHASE_PIECE
import lotto.utils.Constants.MIN_LOTTO_NUMBER

object Validate {
    /* 구입 금액 입력 예외 처리 */
    fun validatePay(payment: String) {
        requirePaymentNotBlank(payment)
        requirePaymentOnlyDigits(payment)
        val alteredPayment = payment.toInt()
        requirePaymentUnit(alteredPayment)
        requirePaymentMinimum(alteredPayment)
        requirePaymentMaximum(alteredPayment)
    }

    private fun requirePaymentNotBlank(payment: String) {
        require(payment.isNotBlank()) { ERROR_INPUT_BLANK }
    }

    private fun requirePaymentOnlyDigits(payment: String) {
        require(payment.toIntOrNull() != null) { ERROR_INPUT_CHAR }
    }

    private fun requirePaymentUnit(payment: Int) {
        require(payment % LOTTO_PURCHASE_UNIT == INITIALIZE_NUMBER) { ERROR_PAY_INPUT_UNIT }
    }

    private fun requirePaymentMinimum(payment: Int) {
        require(payment >= LOTTO_PURCHASE_UNIT) { ERROR_PAY_INPUT_MINIMUM }
    }

    private fun requirePaymentMaximum(payment: Int) {
        require(payment <= (LOTTO_PURCHASE_UNIT * MAX_PURCHASE_PIECE)) { ERROR_PAY_INPUT_MAXIMUM }
    }

    /* 당첨 번호 입력 예외 처리 */
    fun validateWinningNumber(newWinningNumber: String) {
        val splitWinningNumbers = newWinningNumber.split(",").map { it.trim() }
        requireWinningNumbersNotBlank(splitWinningNumbers)
        requireWinningNumbersOnlyDigits(splitWinningNumbers)
        requireWinningNumbersSize(splitWinningNumbers)
        requireWinningNumbersNoDuplicates(splitWinningNumbers)
        requireWinningNumbersRange(splitWinningNumbers)
    }

    private fun requireWinningNumbersNotBlank(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.none { it.isBlank() }) { ERROR_INPUT_BLANK }
    }

    private fun requireWinningNumbersOnlyDigits(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.all { it.toIntOrNull() != null }) { ERROR_INPUT_CHAR }
    }

    private fun requireWinningNumbersSize(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_SIZE }
    }

    private fun requireWinningNumbersNoDuplicates(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.distinct().size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_DUPLICATE }
    }

    private fun requireWinningNumbersRange(splitWinningNumbers: List<String>) {
        require(splitWinningNumbers.all { it.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_INPUT_RANGE }
    }

    /* 보너스 번호 입력 예외 처리 */
    fun validateBonusNumber(newBonusNumber: String, winningNumber: List<Int>) {
        requireBonusNumberNotBlank(newBonusNumber)
        requireBonusNumberOnlyDigits(newBonusNumber)
        val alterBonusNumber = newBonusNumber.toInt()
        requireBonusNumberRange(alterBonusNumber)
        requireBonusNumberDuplicate(alterBonusNumber, winningNumber)
    }

    private fun requireBonusNumberNotBlank(newBonusNumber: String) {
        require(newBonusNumber.isNotBlank()) { ERROR_INPUT_BLANK }
    }

    private fun requireBonusNumberOnlyDigits(newBonusNumber: String) {
        require(newBonusNumber.toIntOrNull() != null) { ERROR_INPUT_CHAR }
    }

    private fun requireBonusNumberRange(alterBonusNumber: Int){
        require(alterBonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { ERROR_INPUT_RANGE }
    }

    private fun requireBonusNumberDuplicate(alterBonusNumber: Int, winningNumber:List<Int>){
        require(alterBonusNumber !in winningNumber) { ERROR_INPUT_DUPLICATE }
    }
}