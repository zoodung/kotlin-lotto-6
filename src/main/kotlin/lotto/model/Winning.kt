package lotto.model

import lotto.utils.Constants.INITIALIZE_NUMBER

class Winning(private var winningNumber: List<Int> = listOf(), private var bonusNumber: Int = INITIALIZE_NUMBER) {
    fun setWinningNumber(winningNumber: List<Int>){
        this.winningNumber = winningNumber
    }

}