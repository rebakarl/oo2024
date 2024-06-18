package ee.tlu.Kodutoo05.controller;


import ee.tlu.Kodutoo05.repository.AutoRepository;
import ee.tlu.Kodutoo05.entity.AutoEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AutoEntityController {

    AutoRepository autoRepository;

    public AutoEntityController(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    // localhost:8080/api/autod
    @GetMapping("autod")
    public List<AutoEntity> saaAutod() {
        return autoRepository.findAll();
    }

    // localhost:8080/api/autod/Toyota/Avensis/2006/250321
    // localhost:8080/api/autod/Volvo/V70/2000/440123
    @PostMapping("autod")
    public List<AutoEntity> lisaAuto(@RequestBody AutoEntity autoEntity) {
        //AutoEntity auto = new AutoEntity(tootja, mudel, aasta, labisoit);
        autoRepository.save(autoEntity);
        return autoRepository.findAll();
    }

    @PostMapping("autod/{tootja}/{mudel}/{aasta}/{labisoit}")
    public List<AutoEntity> lisaAuto(
            @PathVariable String tootja,
            @PathVariable String mudel,
            @PathVariable int aasta,
            @PathVariable int labisoit
        ) {
        AutoEntity auto = new AutoEntity(tootja, mudel, aasta, labisoit);
        autoRepository.save(auto);
        return autoRepository.findAll();
    }

    // localhost:8080/api/autod/Honda
    @DeleteMapping("autod/{tootja}")
    public List<AutoEntity> kustutaAuto(@PathVariable String tootja) {
        autoRepository.deleteById(tootja);
        return autoRepository.findAll();
    }

    @PutMapping("autod")
    public List<AutoEntity> muudaAuto(
            @RequestBody int index,
            @RequestBody String tootja,
            @RequestBody String mudel,
            @RequestBody int aasta,
            @RequestBody int labisoit
    ) {
        AutoEntity auto = new AutoEntity(tootja, mudel, aasta, labisoit);
        autoRepository.save(auto);
        return autoRepository.findAll();
    }

    @GetMapping("autod/labisoitude-summa")
    public int labisoitudeSumma() {
        List<AutoEntity> autod = autoRepository.findAll();
        int summa = 0;
        for(AutoEntity auto : autod) {
            summa += auto.getLabisoit();
        }
        return summa;
    }
}
