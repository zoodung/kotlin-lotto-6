package lotto.model

import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Validate.validatePay


class Customer(private var pay : Int = INITIALIZE_NUMBER, private val lottoNumber : MutableList<Lotto> = mutableListOf()) {
    fun setPay(payment: Int){
        validatePay(payment)
        this.pay = payment
    }
}

