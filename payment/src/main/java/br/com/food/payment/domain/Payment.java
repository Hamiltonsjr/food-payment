package br.com.food.payment.domain;

import br.com.food.payment.domain.status.PaymentStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Builder
@Entity
@Table(name = "pagamentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    @Column(name = "valor")
    private BigDecimal value;

    @NotBlank
    @Size(max = 100)
    @Column(name = "nome")
    private String name;

    @NotBlank
    @Size(max = 19)
    @Column(name = "numero")
    private String number;

    @NotBlank
    @Size(max = 7)
    @Column(name = "expiracao")
    private String expiration;

    @NotBlank
    @Size(min = 3, max = 3)
    @Column(name = "codigo")
    private String cod;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatus status;

    @NotNull
    @Column(name = "pedido_Id")
    private Long orderId;

    @NotNull
    @Column(name = "meio_de_pagamento_id")
    private Long paymentMethodId;
}
