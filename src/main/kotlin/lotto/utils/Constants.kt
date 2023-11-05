package lotto.utils

object Constants  {
    /* Lotto */
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_NUMBER_SIZE = 6

    /* Validate */
    const val LOTTO_PURCHASE_UNIT = 1000
    const val INITIALIZE_NUMBER = 0
    const val MAX_PURCHASE_PIECE = 100

    /* Input Message */
    const val REQUEST_PAY_INPUT_MESSAGE = "구입금액을 입력해 주세요."

    /* Output Message */
    const val ENTER = "\n"
    const val PRINT_PRODUCE_LOTTO_RESULT_MESSAGE = "개를 구매했습니다."

    /* Error Message */
    private const val ERROR_TEXT = "[ERROR] "
    const val ERROR_LOTTO_SIZE = ERROR_TEXT + "로또 번호가 6개가 아닙니다."
    const val ERROR_LOTTO_DUPLICATE = ERROR_TEXT + "로또 번호에 중복하는 숫자가 존재합니다."
    const val ERROR_LOTTO_RANGE = ERROR_TEXT + "로또 번호가 범위를 벗어났습니다."
    const val ERROR_INPUT_STRING_OR_BLANK = ERROR_TEXT + "정수 값을 입력 하세요."
    const val ERROR_INPUT_UNIT = ERROR_TEXT + "1000원 단위로 입력 하세요."
    const val ERROR_INPUT_MINIMUM = ERROR_TEXT + "최소 구입 금액은 1,000원 입니다."
    const val ERROR_INPUT_MAXIMUM = ERROR_TEXT + "최대 구입 금액은 100,000원 입니다."
}