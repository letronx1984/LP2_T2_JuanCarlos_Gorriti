package pe.com.cibertec.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_empleado")
public class EmpleadoEntity {

	@Id
	@Column(columnDefinition = "CHAR(8)",nullable= false, unique = true)
	private String dniEmpleado;
	
	@Column(name="nombre_empleado", nullable = false)
	private String nomEmpleado;
	
	@Column(name="apellido_empleado", nullable = false)
	private String apeEmpleado;
	
	@Column(name="fecha_nacimiento",  nullable = false)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate fecha_nacimiento;
	
	@Column(name="direccion", nullable = false)
	private String direccion;
	
	@Column(name="correo", nullable = false, unique = true )
	private String email;
	
	@ManyToOne
	@JoinColumn(name="area_id", nullable = false)
	private AreaEntity areaEntity;
}
