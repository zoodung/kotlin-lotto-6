package lotto

import lotto.model.Winning
import lotto.utils.Constants.MAX_LOTTO_NUMBER
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningTest {
    @Test
    fun `당첨 번호의 개수가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `당첨 번호의 개수가 5개면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `당첨 번호가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `보너스 번호가 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5, 6), 0)
        }
    }

    @Test
    fun `보너스 번호와 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Winning(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }
}