package sv.edu.udb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alumno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_materia") // Llave foránea hacia la tabla Materia
    private Materia materia;
}
