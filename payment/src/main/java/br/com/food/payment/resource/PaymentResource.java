package br.com.food.payment.resource;

import br.com.food.payment.domain.Payment;
import br.com.food.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getId")
    public ResponseEntity<Optional<Payment>> getId(
            @PageableDefault(size = 10)
            @PathParam("id")
            @NotNull final Long id) {
        log.debug("id={}", id);
        final Optional<Payment> payment = Optional.ofNullable(this.paymentService.getId(id));

        log.debug("payment={}", payment);
        return ResponseEntity.ok(payment);
    }
}
