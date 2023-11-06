package lotto.model

import lotto.utils.Constants.ERROR_INPUT_DUPLICATE
import lotto.utils.Constants.ERROR_INPUT_RANGE
import lotto.utils.Constants.ERROR_INPUT_SIZE
import lotto.utils.Constants.INITIALIZE_BONUS_NUMBER
import lotto.utils.Constants.INITIALIZE_WINNING_NUMBER
import lotto.utils.Constants.LOTTO_NUMBER_SIZE
import lotto.utils.Constants.MAX_LOTTO_NUMBER
import lotto.utils.Constants.MIN_LOTTO_NUMBER

class Winning(private var winningNumbers: List<Int> = INITIALIZE_WINNING_NUMBER, private var bonusNumber: Int = INITIALIZE_BONUS_NUMBER) {
    init {
        require(winningNumbers.size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_SIZE }
        require(winningNumbers.toSet().size == LOTTO_NUMBER_SIZE) { ERROR_INPUT_DUPLICATE }
        require(winningNumbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_INPUT_RANGE }
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { ERROR_INPUT_RANGE }
        require(bonusNumber !in winningNumbers) { ERROR_INPUT_DUPLICATE }
    }

    fun setWinningNumbers(newWinningNumber: List<Int>){
        this.winningNumbers = newWinningNumber
    }

    fun setBonusNumber(newBonusNumber: Int){
        this.bonusNumber = newBonusNumber
    }


}