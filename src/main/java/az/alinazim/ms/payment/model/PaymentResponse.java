package az.alinazim.ms.payment.model;

import lombok.Data;

@Data
public class PaymentResponse {
    private boolean isSuccess;
    private String message;
}

