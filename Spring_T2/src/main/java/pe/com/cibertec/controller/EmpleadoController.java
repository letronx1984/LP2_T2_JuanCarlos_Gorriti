package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	
	private EmpleadoService empleadoService;
	
	
	@GetMapping ("/")
	public String home(Model model) {
		List<EmpleadoEntity> listadoEmpleado = empleadoService.listarEmpleado();
		model.addAttribute("listaEmpleado", listadoEmpleado);
		
		return "listadoEmpleado";
		
	}
}
