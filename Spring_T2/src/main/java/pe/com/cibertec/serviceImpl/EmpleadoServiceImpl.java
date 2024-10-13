package pe.com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.repository.EmpleadoRepository;
import pe.com.cibertec.service.EmpleadoService;

@Service
@RequiredArgsConstructor

public class EmpleadoServiceImpl implements EmpleadoService {

	private final EmpleadoRepository empleadoRepository;	
	
	
	@Override
	public List<EmpleadoEntity> listarEmpleado() {
		// TODO Auto
		return empleadoRepository.findAll();
	}

	@Override
	public void crearEmpleado(EmpleadoEntity empleadoEntity) {
		
		empleadoRepository.save(empleadoEntity);
		
	}

	@Override
	public EmpleadoEntity buscarPorDNI(String dniEmpleado) {
		
		return empleadoRepository.findByDniEmpleado(dniEmpleado);
				
	}

	@Override
	public void actualizarEmpleado(String dniEmpleado, EmpleadoEntity empleadoEntity) {
		EmpleadoEntity empleadoEncontrado = buscarPorDNI(dniEmpleado);
		if (empleadoEncontrado== null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		try {
			empleadoEncontrado.setDniEmpleado(empleadoEncontrado.getDniEmpleado());
			empleadoEncontrado.setNomEmpleado(empleadoEncontrado.getNomEmpleado());
			empleadoEncontrado.setApeEmpleado(empleadoEncontrado.getApeEmpleado());
			empleadoEncontrado.setEmail(empleadoEncontrado.getEmail());
			empleadoEncontrado.setDireccion(empleadoEncontrado.getDireccion());
			empleadoEncontrado.setFecha_nacimiento(empleadoEncontrado.getFecha_nacimiento());
			empleadoEncontrado.setAreaEntity(empleadoEncontrado.getAreaEntity());
		} catch (Exception e) {
			throw new RuntimeException("Empleado no encontrado");
		}
		
	}

	@Override
	public void eliminar(String dni) {
		EmpleadoEntity empleadoEncontrado = buscarPorDNI(dni);
		
		if(empleadoEncontrado== null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		empleadoRepository.delete(empleadoEncontrado);
	}

}
