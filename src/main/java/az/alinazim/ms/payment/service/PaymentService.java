package az.alinazim.ms.payment.service;

import az.alinazim.ms.payment.model.PaymentResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @RabbitListener(queues = "PAYMENT_Q")
    public void processPayment(String data) {
        var paymentResponse = new PaymentResponse();
        paymentResponse.setSuccess(true);
        paymentResponse.setMessage("Successful payment: " + data);
        System.out.println(paymentResponse);
    }
}
