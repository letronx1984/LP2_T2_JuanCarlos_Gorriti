package pe.com.cibertec.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.model.AreaEntity;
import pe.com.cibertec.model.EmpleadoEntity;
import pe.com.cibertec.service.AreaService;
import pe.com.cibertec.service.EmpleadoService;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {

	
	
	private final EmpleadoService empleadoService;
	
	private final AreaService areaService;
	
	@GetMapping ("/")
	public String home(Model model) {
		
		List<EmpleadoEntity> listadoEmpleado = empleadoService.listarEmpleado();
		model.addAttribute("listaEmpleado", listadoEmpleado);
		return "listadoEmpleado";
	}
	@GetMapping("/agregar_empleado")
	public String registroEmpleado(Model model) {
		List<AreaEntity> listaArea = areaService.obtenerAreas();
		model.addAttribute("areas",listaArea);
		model.addAttribute("empleado", new EmpleadoEntity());
		
		return "registroEmpleado";
	}
	
	@PostMapping("/agregar_empleado")
	public String registroEmpleados(@ModelAttribute("empleado")EmpleadoEntity empleadoEntity, Model model) {
		empleadoService.crearEmpleado(empleadoEntity);
		return "redirect:/";
	}
	
	@GetMapping("/listarArea")
	public String Area(Model model) {
		List<AreaEntity> listarArea = areaService.obtenerAreas();
		model.addAttribute("listaArea",listarArea);
		return "listaArea";
	}
	@GetMapping("/agregar_area")
	public String agregarArea(Model model) {
		model.addAttribute("area", new AreaEntity());
		return "agregarArea";
	}
	
	@PostMapping("/agregar_area")
	public String agregarArea(@ModelAttribute("area") AreaEntity area, Model model) {
		areaService.crearArea(area);
		return "redirect:/";
		
	}
	
	@GetMapping("/eliminarEmpleado/{dni}")
	public String eliminarEmpleado(@PathVariable("dni")String dni) {
		empleadoService.eliminar(dni);
		
		return "redirect:/";
	}
	@GetMapping("/editarEmpleado/{dni}")
	public String editarEmpleado(@PathVariable("dni")String dni, Model model) {
		EmpleadoEntity empleadoEncontrado = empleadoService.buscarPorDNI(dni);
		List<AreaEntity> listaArea = areaService.obtenerAreas();
		model.addAttribute("areas",listaArea);
		model.addAttribute("empleado",empleadoEncontrado);
		return "editarEmpleado";
	}
	
	@PostMapping("/editarEmpleado/{dni}")
	public String editarEmpleado(@PathVariable("dni")String dni,
			@ModelAttribute("empleado") EmpleadoEntity empleado, Model model)
	{
		empleadoService.actualizarEmpleado(dni, empleado);
		return "redirect:/";
	}
}


