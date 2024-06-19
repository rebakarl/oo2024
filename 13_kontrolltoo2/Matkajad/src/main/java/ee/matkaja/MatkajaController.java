package ee.matkaja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/matkajad")
public class MatkajaController {

    private final MatkajaRepository matkajaRepository;

    @Autowired
    public MatkajaController(MatkajaRepository matkajaRepository) {
        this.matkajaRepository = matkajaRepository;
    }

    @GetMapping
    public List<Matkaja> koikMatkajad() {
        return matkajaRepository.findAll();
    }
// localhost:8080/matkajad/lisamatkaja
    //{
//  "nimi": "Juhan Juurikas",
//  "kilomeetraaz": 20000,
//  "riikideArv": 17,
//  "staatus": "active"
//}
    @PostMapping("/lisamatkaja")
    public ResponseEntity<Matkaja> lisaMatkaja(@RequestBody Matkaja matkaja) {
        Matkaja savedMatkaja = matkajaRepository.save(matkaja);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMatkaja);
    }
// localhost:8080/matkajad/2
    @DeleteMapping("/{id}")
    public ResponseEntity<?> kustutaMatkaja(@PathVariable Long id) {
        matkajaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}