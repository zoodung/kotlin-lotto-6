package lotto

class Customer(private var pay : Int = NO_REMAINDER) {

    private val validate = Validate()

    fun setPay(payment: Int){
       validate.validatePay(payment)
            this.pay = payment
    }



    companion object {
        const val NO_REMAINDER = 0
    }
}

