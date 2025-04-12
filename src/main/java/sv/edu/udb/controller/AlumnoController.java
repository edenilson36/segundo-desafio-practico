package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.service.AlumnoService;

import java.util.List;


@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public Alumno findById(@PathVariable Long id) {
        return alumnoService.findById(id);
    }

    @PostMapping
    public Alumno save(@Valid @RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable Long id, @Valid @RequestBody Alumno alumno) {
        return alumnoService.update(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoService.delete(id);
    }
}
