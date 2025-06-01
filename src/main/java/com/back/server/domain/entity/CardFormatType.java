package com.back.server.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "card_format_types", schema = "acardnya_db")
public class CardFormatType {
    @Id
    @Size(max = 50)
    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

}