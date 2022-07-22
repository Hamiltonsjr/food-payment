package br.com.food.payment.domain;

import br.com.food.payment.domain.status.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private BigDecimal value;
    private PaymentStatus status;
    private Long orderId;
    private Long paymentMethodId;
}
