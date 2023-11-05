package lotto.utils

import lotto.utils.Constants.ERROR_INPUT_MAXIMUM
import lotto.utils.Constants.ERROR_INPUT_MINIMUM
import lotto.utils.Constants.ERROR_INPUT_UNIT
import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Constants.MAX_PAY
import lotto.utils.Constants.MIN_PAY

object Validate {
    fun validatePay(payment: Int) {
        checkPaymentUnit(payment)
        checkPaymentMinimum(payment)
        checkPaymentMaximum(payment)
    }

    private fun checkPaymentUnit(payment: Int) {
        require(payment % MIN_PAY == INITIALIZE_NUMBER) { ERROR_INPUT_UNIT }
    }

    private fun checkPaymentMinimum(payment: Int) {
        require(payment >= MIN_PAY) { ERROR_INPUT_MINIMUM }
    }

    private fun checkPaymentMaximum(payment: Int) {
        require(payment <= MAX_PAY) { ERROR_INPUT_MAXIMUM }
    }
}