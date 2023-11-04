package lotto

fun main() {
    val customer = Customer()
    val controller = LottoController(customer)

    controller.run()
}
