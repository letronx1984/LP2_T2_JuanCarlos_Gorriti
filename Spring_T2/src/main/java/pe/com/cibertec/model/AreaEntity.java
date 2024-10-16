package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name ="tb_area")

public class AreaEntity {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="area_id")
	private Integer idArea;
	
	@Column(name="nombre_area")
	private String nombreArea;
}
