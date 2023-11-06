package lotto.model

import lotto.utils.Constants.FIFTH_PLACE
import lotto.utils.Constants.FIRST_PLACE
import lotto.utils.Constants.FOURTH_PLACE
import lotto.utils.Constants.LOSE_PLACE
import lotto.utils.Constants.MATCHED_FIVE
import lotto.utils.Constants.MATCHED_FOUR
import lotto.utils.Constants.MATCHED_SIX
import lotto.utils.Constants.MATCHED_THREE
import lotto.utils.Constants.SECOND_PLACE
import lotto.utils.Constants.THIRD_PLACE

class Rank(
    private var _rank: List<String> = listOf(),
    private var rankCount: List<Int> = listOf()
) {
    private fun setRank(rank: List<String>) {
        this._rank = rank
    }

    fun getRank(): List<String> {
        return _rank.toList()
    }

    fun setRankCount(rankCount: List<Int>) {
        this.rankCount = rankCount
    }

    fun getRankCount(): List<Int> {
        return rankCount.toList()
    }

    fun analyzeLottoRanking(lottoCollection: List<Lotto>, winning: Winning): List<Int> {
        val winningNumbers = winning.getWinningNumbers().toSet()
        val ranking: MutableList<String> = mutableListOf()

        for (lotto in lottoCollection) {
            ranking.add(recordRank(lotto.getNumbers(), winningNumbers, winning.getBonusNumber()))

        }

        setRank(ranking)

        return rankingCount(ranking)
    }

    private fun recordRank(lottoNumbers: List<Int>, winningNumbers: Set<Int>, bonusNumber: Int): String {
        val matchNumbers = compareNumbers(lottoNumbers, winningNumbers)

        when (matchNumbers) {
            MATCHED_THREE -> return FIFTH_PLACE
            MATCHED_FOUR -> return FOURTH_PLACE
            MATCHED_FIVE -> return compareBonusNumber(lottoNumbers, bonusNumber)
            MATCHED_SIX -> return FIRST_PLACE
        }

        return LOSE_PLACE
    }

    private fun compareNumbers(lottoNumbers: List<Int>, winningNumbers: Set<Int>): Int {
        return lottoNumbers.intersect(winningNumbers).count()
    }

    private fun compareBonusNumber(lottoNumbers: List<Int>, bonusNumber: Int): String {
        if (bonusNumber in lottoNumbers) return SECOND_PLACE

        return THIRD_PLACE
    }

    private fun rankingCount(ranking: List<String>): List<Int> {
        val countMap = mutableMapOf<String, Int>().withDefault { 0 }

        ranking.forEach { rank ->
            countMap[rank] = countMap.getValue(rank) + 1
        }

        return rankingPlaceCount(countMap)
    }

    private fun rankingPlaceCount(countMap: MutableMap<String, Int>): List<Int> {
        val rankingMatchCount: MutableList<Int> = mutableListOf()

        for (i in 1..5) {
            val rank = "${i}등"
            rankingMatchCount.add(countMap.getValue(rank))
        }

        return rankingMatchCount
    }
}