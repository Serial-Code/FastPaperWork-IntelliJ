package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "seguimiento_envio")
@Getter
@Setter
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idseguimiento_envio", unique = true)
    private Integer id;
    @Column(name = "referencia_envio", length = 20, nullable = false)
    private int ref;
    @CreationTimestamp
    @Column(name = "fecha_inicio", updatable = false)
    private Date date_start;
    @UpdateTimestamp
    @Column(name = "fecha_fin")
    private Date date_end;
    @Column( name = "destino",length = 40)
    private String destination;

}
