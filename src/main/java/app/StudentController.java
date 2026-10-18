package app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        if (student.getAddresses() != null) {
            student.getAddresses().forEach(a -> a.setPerson(student));
        }
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student updated) {
        return repository.findById(id).map(student -> {
            student.setName(updated.getName());
            student.setPhoneNumber(updated.getPhoneNumber());
            student.setEmailAddress(updated.getEmailAddress());
            student.setStatus(updated.getStatus());
            student.setStudentNumber(updated.getStudentNumber());
            student.setPhoto(updated.getPhoto());
            return ResponseEntity.ok(repository.save(student));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("Estudante removido com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }
}