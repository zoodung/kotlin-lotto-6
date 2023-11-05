package lotto.view

import lotto.model.Lotto
import lotto.utils.Constants.PRINT_ENTER
import lotto.utils.Constants.PRINT_PRODUCE_LOTTO_RESULT_MESSAGE

object OutPutView {
    fun printProduceLottoResult(produceLottoResult: List<Lotto>){
        println(PRINT_ENTER + "${produceLottoResult.size}" + PRINT_PRODUCE_LOTTO_RESULT_MESSAGE)
        produceLottoResult.forEach { lotto -> println(lotto) }
    }
}