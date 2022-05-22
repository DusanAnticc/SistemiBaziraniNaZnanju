package com.sbnz.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private Long userId;
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private Part part;
}
