package br.com.food.payment.service;

import br.com.food.payment.client.PaymentClient;
import br.com.food.payment.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentClient paymentClient;

    public Payment getId(final Long id) {
        log.info("id={}", id);
        final Optional<Payment> payment = this.paymentClient.findById(id);
        log.debug("Payment={}", payment);
        return payment.orElseThrow(RuntimeException::new);
    }
}
