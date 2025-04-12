package sv.edu.udb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.model.Materia;
import sv.edu.udb.repository.MateriaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements MateriaService{
    private final MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElseThrow();
    }

    @Override
    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public Materia update(Long id, Materia materia) {
        Materia actual = findById(id);
        actual.setNombre(materia.getNombre());
        return materiaRepository.save(actual);
    }

    @Override
    public void delete(Long id) {
        materiaRepository.deleteById(id);
    }
}
