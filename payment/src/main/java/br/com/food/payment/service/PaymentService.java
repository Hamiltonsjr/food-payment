package br.com.food.payment.service;

import br.com.food.payment.client.PaymentClient;
import br.com.food.payment.domain.Payment;
import br.com.food.payment.domain.PaymentDTO;
import br.com.food.payment.domain.status.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentClient paymentClient;
    @Autowired
    private ModelMapper modelMapper;

    public PaymentDTO getPaymentId(final Long id) {
        log.info("id={}", id);
        final Optional<Payment> payment = Optional
                .ofNullable(this.paymentClient.findById(id).orElseThrow(RuntimeException::new));
        log.debug("Payment={}", payment);
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public PaymentDTO createPayment(final PaymentDTO paymentDTO) {
        log.debug("paymentDTO={}", paymentDTO);

        final Payment payment = modelMapper.map(paymentDTO, Payment.class);
        payment.setStatus(PaymentStatus.CRIADO);

        log.debug("payment={}", payment);

        this.paymentClient.save(payment);
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public List<PaymentDTO> getAllPayment() {
        return this.paymentClient
                .findAll()
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }

    public void deletePayment(final Long id) {
        this.paymentClient.deleteById(id);
    }

    public PaymentDTO updatePayment(final Long id, final PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO,Payment.class);
        payment.setId(id);
        payment = this.paymentClient.save(payment);
        return modelMapper.map(payment,PaymentDTO.class);
    }

}
