package application.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jogos")
@Getter
@Setter
@NoArgsConstructor
public class Jogo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String titulo;

    @ManyToAny
    @JoinTable(name = "jogos_possuem_plataformas", joinColumns = @JoinColumn(name = "id_jogo"), inverseJoinColumns = @JoinColumn(name = "id_plataforma"))
    private Set<Plataforma> plataformas;
}
