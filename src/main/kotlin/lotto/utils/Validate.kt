package lotto.utils

import lotto.utils.Constants.ERROR_INPUT_BLANK
import lotto.utils.Constants.ERROR_INPUT_CHAR
import lotto.utils.Constants.ERROR_PAY_INPUT_MAXIMUM
import lotto.utils.Constants.ERROR_PAY_INPUT_MINIMUM
import lotto.utils.Constants.ERROR_PAY_INPUT_UNIT
import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT
import lotto.utils.Constants.MAX_PURCHASE_PIECE

object Validate {
    /* 구입 금액 입력 예외 처리 */
    fun validatePay(payment: String) {
        checkPaymentBlank(payment)
        checkPaymentChar(payment)
        checkPaymentUnit(payment.toInt())
        checkPaymentMinimum(payment.toInt())
        checkPaymentMaximum(payment.toInt())
    }

    private fun checkPaymentBlank(payment: String) {
        require(payment.isNotBlank()) { ERROR_INPUT_BLANK }
    }

    private fun checkPaymentChar(payment: String) {
        require(payment.toIntOrNull() != null) { ERROR_INPUT_CHAR }
    }

    private fun checkPaymentUnit(payment: Int) {
        require(payment % LOTTO_PURCHASE_UNIT == INITIALIZE_NUMBER) { ERROR_PAY_INPUT_UNIT }
    }

    private fun checkPaymentMinimum(payment: Int) {
        require(payment >= LOTTO_PURCHASE_UNIT) { ERROR_PAY_INPUT_MINIMUM }
    }

    private fun checkPaymentMaximum(payment: Int) {
        require(payment <= (LOTTO_PURCHASE_UNIT * MAX_PURCHASE_PIECE)) { ERROR_PAY_INPUT_MAXIMUM }
    }
}