package az.alinazim.ms.payment.controller;

import az.alinazim.ms.payment.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping()
    PaymentResponse processPayment(@RequestParam Double amount, @RequestParam String orderNumber) {
        return paymentService.processPayment(amount, orderNumber);
    }
}
