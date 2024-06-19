package ee.karl.matkaja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matkajad")
public class MatkajaController {

    private final MatkajaRepository matkajaRepository;

    @Autowired
    public MatkajaController(MatkajaRepository matkajaRepository) {
        this.matkajaRepository = matkajaRepository;
    }

    @GetMapping
    public List<Matkaja> kõikMatkajad() {
        return matkajaRepository.findAll();
    }

    @PostMapping("/lisamatkaja")
    public ResponseEntity<Matkaja> lisaMatkaja(@RequestBody Matkaja matkaja) {
        Matkaja savedMatkaja = matkajaRepository.save(matkaja);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMatkaja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> kustutaMatkaja(@PathVariable Long id) {
        matkajaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

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

    @PutMapping("/{id}/lisa-kulastatud-riik")
    public ResponseEntity<Matkaja> lisaKulastatudRiik(@PathVariable String id, @RequestBody String uusRiik) {
        Optional<Matkaja> matkajaOptional = matkajaRepository.findById(Long.valueOf(id));
        if (matkajaOptional.isPresent()) {
            Matkaja matkaja = matkajaOptional.get();
            matkaja.setRiikideArv(matkaja.getRiikideArv() + 1);
            matkajaRepository.save(matkaja);
            return ResponseEntity.ok(matkaja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/kõik-riigid")
    public List<String> kysiKoikRiigid() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://restcountries.com/v3.1/all?fields=name";
        String[] response = restTemplate.getForObject(url, String[].class);
        return Arrays.asList(response);
    }

    @GetMapping("/riigid-tähega")
    public List<String> kysiRiigidTähega(@RequestParam String täht) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://restcountries.com/v3.1/all?fields=name";
        String[] response = restTemplate.getForObject(url, String[].class);
        return Arrays.stream(response)
                .filter(riik -> riik.startsWith(täht))
                .collect(Collectors.toList());
    }

}
