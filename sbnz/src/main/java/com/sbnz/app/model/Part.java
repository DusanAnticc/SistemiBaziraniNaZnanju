package com.sbnz.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parts")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "log_id")
    private List<Log> logs;

}
