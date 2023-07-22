package az.alinazim.ms.payment.controller;

import az.alinazim.ms.payment.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentResponse processPayment(Double amount, String orderNumber) {
        var paymentResponse = new PaymentResponse();
        paymentResponse.setSuccess(true);
        paymentResponse.setMessage("Payment successful with order number: " + orderNumber);
        return paymentResponse;
    }
}
