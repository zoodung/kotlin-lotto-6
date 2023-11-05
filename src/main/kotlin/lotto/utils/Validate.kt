package lotto.utils

import lotto.utils.Constants.ERROR_INPUT_MAXIMUM
import lotto.utils.Constants.ERROR_INPUT_MINIMUM
import lotto.utils.Constants.ERROR_INPUT_UNIT
import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT
import lotto.utils.Constants.MAX_PURCHASE_PIECE

object Validate {
    fun validatePay(payment: Int) {
        checkPaymentUnit(payment)
        checkPaymentMinimum(payment)
        checkPaymentMaximum(payment)
    }

    private fun checkPaymentUnit(payment: Int) {
        require(payment % LOTTO_PURCHASE_UNIT == INITIALIZE_NUMBER) { ERROR_INPUT_UNIT } // 주문 단위
    }

    private fun checkPaymentMinimum(payment: Int) {
        require(payment >= LOTTO_PURCHASE_UNIT) { ERROR_INPUT_MINIMUM } // 주문 단위 보다 적은 금액은 구매할 수 없다.
    }

    private fun checkPaymentMaximum(payment: Int) {
        require(payment <= (LOTTO_PURCHASE_UNIT * MAX_PURCHASE_PIECE)) { ERROR_INPUT_MAXIMUM } // 주문 단위의 100배를 초과한 금액은 구매할 수 없다.
    }
}