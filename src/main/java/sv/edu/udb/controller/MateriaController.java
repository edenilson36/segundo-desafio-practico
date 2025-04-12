package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.Materia;
import sv.edu.udb.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService materiaService;

    @GetMapping
    public List<Materia> findAll() {
        return materiaService.findAll();
    }

    @GetMapping("/{id}")
    public Materia findById(@PathVariable Long id) {
        return materiaService.findById(id);
    }

    @PostMapping
    public Materia save(@Valid @RequestBody Materia materia) {
        return materiaService.save(materia);
    }

    @PutMapping("/{id}")
    public Materia update(@PathVariable Long id, @Valid @RequestBody Materia materia) {
        return materiaService.update(id, materia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        materiaService.delete(id);
    }
}
