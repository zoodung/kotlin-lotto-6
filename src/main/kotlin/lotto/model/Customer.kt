package lotto.model

import lotto.utils.Constants
import lotto.utils.Constants.INITIALIZE_NUMBER
import lotto.utils.Constants.LOTTO_PURCHASE_UNIT


class Customer(
    private var pay: Int = LOTTO_PURCHASE_UNIT,
    private var lottoCollection: MutableList<Lotto> = mutableListOf()
) {
    init {
        require(pay % Constants.LOTTO_PURCHASE_UNIT == INITIALIZE_NUMBER) { Constants.ERROR_PAY_INPUT_UNIT }
        require(pay >= Constants.LOTTO_PURCHASE_UNIT) { Constants.ERROR_PAY_INPUT_MINIMUM }
        require(pay <= (Constants.LOTTO_PURCHASE_UNIT * Constants.MAX_PURCHASE_PIECE)) { Constants.ERROR_PAY_INPUT_MAXIMUM }
    }

    fun setPay(payment: Int) {
        this.pay = payment
    }

    fun setLottoCollection(newLottoCollection: MutableList<Lotto>) {
        this.lottoCollection = newLottoCollection
    }

    fun getPay(): Int {
        return pay
    }

    fun getLottoCollection(): List<Lotto> {
        return lottoCollection.toList()
    }
}

