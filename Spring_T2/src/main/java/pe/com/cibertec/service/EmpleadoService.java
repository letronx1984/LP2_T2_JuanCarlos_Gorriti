package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.EmpleadoEntity;

public interface EmpleadoService {
	
	List<EmpleadoEntity> listarEmpleado();
	void crearEmpleado(EmpleadoEntity empleadoEntity);
	EmpleadoEntity buscarPorDNI(String dni);
	void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity);
	void eliminar (String dni);
}
