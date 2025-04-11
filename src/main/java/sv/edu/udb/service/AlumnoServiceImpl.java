package sv.edu.udb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.repository.AlumnoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElseThrow();
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Long id, Alumno alumno) {
        Alumno actual = findById(id);
        actual.setNombre(alumno.getNombre());
        actual.setApellido(alumno.getApellido());
        actual.setMateria(alumno.getMateria());
        return alumnoRepository.save(actual);
    }

    @Override
    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }
}
