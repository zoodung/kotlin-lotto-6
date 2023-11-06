package lotto.model

import lotto.utils.Constants.INITIALIZE_NUMBER

class Winning(private var winningNumber: List<Int> = listOf(), private var bonusNumber: Int = INITIALIZE_NUMBER) {
    fun setWinningNumber(newWinningNumber: List<Int>){
        this.winningNumber = newWinningNumber
    }

    fun setBonusNumber(newBonusNumber: Int){
        this.bonusNumber = newBonusNumber
    }

}