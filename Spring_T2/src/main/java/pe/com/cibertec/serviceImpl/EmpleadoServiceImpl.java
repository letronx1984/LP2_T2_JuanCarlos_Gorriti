package pe.com.cibertec.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
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
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public void crearEmpleado(EmpleadoEntity empleadoEntity) {
		
		empleadoRepository.save(empleadoEntity);
		
	}

	@Override
	public EmpleadoEntity buscarPorDNI(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(String dni) {
		// TODO Auto-generated method stub
		
	}

}
