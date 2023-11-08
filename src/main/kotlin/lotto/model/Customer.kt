package lotto.model

import lotto.utils.Constants
import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT


class Customer(
    private var pay: Int = INITIALIZE_NUMBER,
    private var lottoCollection: MutableList<Lotto> = mutableListOf()
) {
    fun setPay(payment: Int) {
        this.pay = payment
    }

    fun setLottoCollection(newLottoCollection: MutableList<Lotto>) {
        this.lottoCollection = newLottoCollection
    }

    fun getPay(): Int = pay

    fun getLottoCollection(): List<Lotto> = lottoCollection.toList()
}

