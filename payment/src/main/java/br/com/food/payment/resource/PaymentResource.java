package br.com.food.payment.resource;

import br.com.food.payment.domain.PaymentDTO;
import br.com.food.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getId")
    public ResponseEntity<Optional<PaymentDTO>> getPaymentId(@PageableDefault(size = 10) @PathParam("id") @NotNull final Long id) {
        log.debug("id={}", id);
        final Optional<PaymentDTO> payment = Optional.ofNullable(this.paymentService.getPaymentId(id));
        log.debug("payment={}", payment);
        return ResponseEntity.ok(payment);
    }
    @PostMapping("/create")
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody @NotNull @Valid final PaymentDTO paymentDTO) {
        final PaymentDTO createPayment = this.paymentService.createPayment(paymentDTO);
        log.debug("payment={}", createPayment);
        return ResponseEntity.ok(createPayment);
    }
    @GetMapping("/getAllPayment")
    public ResponseEntity<List<PaymentDTO>> getAllPayment(){
        final List<PaymentDTO> paymentDTOS = this.paymentService.getAllPayment();
        log.debug("paymentDTOS={}", paymentDTOS);
        return ResponseEntity.ok(paymentDTOS);
    }

    @PutMapping
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable @NotNull final Long id,
                                                    @RequestBody @Valid final PaymentDTO paymentDTO) {
        final PaymentDTO update = this.paymentService.updatePayment(id,paymentDTO);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDTO> remover(@PathVariable @NotNull final Long id) {
        this.paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

}
