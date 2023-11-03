package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_LENGTH)
        require(numbers.toSet().size == LOTTO_NUMBER_LENGTH)
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER })
    }

    fun pickLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_LENGTH)
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_LENGTH = 6
    }
}
