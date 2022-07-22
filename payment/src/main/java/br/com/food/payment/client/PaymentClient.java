package br.com.food.payment.client;

import br.com.food.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentClient extends JpaRepository<Payment, Long> {
}
