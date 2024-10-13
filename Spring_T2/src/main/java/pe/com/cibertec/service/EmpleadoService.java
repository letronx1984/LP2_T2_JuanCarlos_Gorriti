package pe.com.cibertec.service;

import java.util.List;
import java.util.Optional;

import pe.com.cibertec.model.EmpleadoEntity;

public interface EmpleadoService {
	
	List<EmpleadoEntity> listarEmpleado();
	void crearEmpleado(EmpleadoEntity empleadoEntity);
	EmpleadoEntity buscarPorDNI(String dniEmpleado);
	void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity);
	void eliminar (String dni);
}
