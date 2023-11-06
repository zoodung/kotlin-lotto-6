package lotto.utils

import lotto.utils.Constants.ERROR_INPUT_BLANK
import lotto.utils.Constants.ERROR_INPUT_CHAR

object Validate {
    /* 구입 금액 입력 예외 처리 */
    fun validatePay(payment: String) {
        requirePaymentNotBlank(payment)
        requirePaymentOnlyDigits(payment)
    }

    private fun requirePaymentNotBlank(payment: String) {
        require(payment.isNotBlank()) { ERROR_INPUT_BLANK }
    }

    private fun requirePaymentOnlyDigits(payment: String) {
        require(payment.toIntOrNull() != null) { ERROR_INPUT_CHAR }
    }

    /* 당첨 번호 입력 예외 처리 */
    fun validateWinningNumber(newWinningNumbers: String) {
        requireWinningNumbersNotBlank(newWinningNumbers)
        requireWinningNumbersOnlyDigits(newWinningNumbers)
    }

    private fun requireWinningNumbersNotBlank(newWinningNumbers: String) {
        require(newWinningNumbers.isNotBlank()) { ERROR_INPUT_BLANK }
    }

    private fun requireWinningNumbersOnlyDigits(newWinningNumbers: String) {
        require(newWinningNumbers.toIntOrNull() != null) { ERROR_INPUT_CHAR }
    }

    /* 보너스 번호 입력 예외 처리 */
    fun validateBonusNumber(newBonusNumber: String) {
        requireBonusNumberNotBlank(newBonusNumber)
        requireBonusNumberOnlyDigits(newBonusNumber)
    }

    private fun requireBonusNumberNotBlank(newBonusNumber: String) {
        require(newBonusNumber.isNotBlank()) { ERROR_INPUT_BLANK }
    }

    private fun requireBonusNumberOnlyDigits(newBonusNumber: String) {
        require(newBonusNumber.toIntOrNull() != null) { ERROR_INPUT_CHAR }
    }
}