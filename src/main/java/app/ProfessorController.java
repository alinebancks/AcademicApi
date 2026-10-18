package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorRepository.save(professor));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(professorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professorDetails) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setName(professorDetails.getName());
            professor.setPhoneNumber(professorDetails.getPhoneNumber());
            professor.setEmailAddress(professorDetails.getEmailAddress());
            professor.setStatus(professorDetails.getStatus());
            professor.setSalary(professorDetails.getSalary());
            return ResponseEntity.ok(professorRepository.save(professor));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            return ResponseEntity.ok("Professor removido com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }
}