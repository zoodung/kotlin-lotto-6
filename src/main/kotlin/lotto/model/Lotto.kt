package lotto.model

import lotto.utils.Constants.ERROR_LOTTO_DUPLICATE
import lotto.utils.Constants.ERROR_LOTTO_LENGTH
import lotto.utils.Constants.ERROR_LOTTO_RANGE
import lotto.utils.Constants.LOTTO_NUMBER_LENGTH
import lotto.utils.Constants.MAX_LOTTO_NUMBER
import lotto.utils.Constants.MIN_LOTTO_NUMBER

class Lotto(private var numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_LENGTH) { ERROR_LOTTO_LENGTH }
        require(numbers.toSet().size == LOTTO_NUMBER_LENGTH) { ERROR_LOTTO_DUPLICATE }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_LOTTO_RANGE }
    }
}
