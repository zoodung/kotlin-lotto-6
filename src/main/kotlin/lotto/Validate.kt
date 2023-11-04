package lotto

import lotto.Customer.Companion.NO_REMAINDER

class Validate {
    fun validatePay(payment: Int){
        checkPaymentUnit(payment)
        checkPaymentMinimum(payment)
        checkPaymentMaximum(payment)
    }

    private fun checkPaymentUnit(payment: Int){
        require(payment % MIN_PAY == NO_REMAINDER) { Message.ERROR_INPUT_UNIT.messageText }
    }

    private fun checkPaymentMinimum(payment: Int){
        require(payment >= MIN_PAY) { Message.ERROR_INPUT_MINIMUM.messageText }
    }

    private fun checkPaymentMaximum(payment: Int){
        require(payment <= MAX_PAY) { Message.ERROR_INPUT_MAXIMUM.messageText }
    }

    companion object {
        private const val MIN_PAY = 1000
        private const val MAX_PAY = 100000
    }
}