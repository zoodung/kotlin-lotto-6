package lotto.model

import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Validate.validatePay


class Customer(private var pay : Int = INITIALIZE_NUMBER, private var lottoCollection : MutableList<Lotto> = mutableListOf()) {
    fun setPay(payment: Int) {
        validatePay(payment)
        this.pay = payment
    }

    fun setLottoCollection(newLottoCollection: MutableList<Lotto>) {
        this.lottoCollection = newLottoCollection
    }

    fun getPay(): Int {
        return pay
    }

    fun getlottoCollection(): List<Lotto> {
        return lottoCollection
    }
}

