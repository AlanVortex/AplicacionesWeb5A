package mx.edu.utez.ExamenDiagnostico.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientesDto {
    private Integer id_cliente;
    private String nombre;
    private String apellidos;
    private String curp;
    private String fecha_nacimiento;
}
