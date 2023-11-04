package lotto

enum class Message(val messageText: String) {
    /* 입력 메세지 */
    REQUEST_PAY_INPUT_MESSAGE("구입금액을 입력해 주세요."),

    /* 에러 메세지 */
    ERROR_INPUT_STRING_OR_BLANK("[ERROR] 정수 값을 입력 하세요."),
}