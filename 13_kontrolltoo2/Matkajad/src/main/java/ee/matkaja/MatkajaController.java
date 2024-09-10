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
    // localhost:8080/5/suurenda-kilometraazi/35
    @PutMapping("/{id}/suurenda-kilomeetraazi/{lisatudKilomeetraaz}")
    public ResponseEntity<Matkaja> suurendaKilomeetraazi(@PathVariable Long id, @PathVariable double lisatudKilomeetraaz) {
        Optional<Matkaja> matkajaOptional = matkajaRepository.findById(id);
        if (matkajaOptional.isPresent()) {
            Matkaja matkaja = matkajaOptional.get();
            double uusKilomeetraaz = matkaja.getKilomeetraaz() + lisatudKilomeetraaz;
            matkaja.setKilomeetraaz(uusKilomeetraaz);
            matkajaRepository.save(matkaja);
            return ResponseEntity.ok(matkaja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/suurima-kilomeetraaziga-matkaja")
    public ResponseEntity<Matkaja> suurimaKilomeetraazigaMatkaja() {
        List<Matkaja> matkajad = matkajaRepository.findAll();
        if (matkajad.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Matkaja suurimaKilomeetraazigaMatkaja = matkajad.stream()
                .max(Comparator.comparingDouble(Matkaja::getKilomeetraaz))
                .orElseThrow();
        return ResponseEntity.ok(suurimaKilomeetraazigaMatkaja);
    }
}