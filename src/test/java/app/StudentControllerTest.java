package app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class StudentControllerTest {

    @Test
    void testGetStudentById() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        Student student = new Student();
        student.setId(1L);
        student.setName("Aluno Teste");

        when(repository.findById(1L)).thenReturn(Optional.of(student));

        StudentController controller = new StudentController(repository);
        ResponseEntity<Student> response = controller.getById(1L);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Aluno teste", response.getBody().getName());
    }
}