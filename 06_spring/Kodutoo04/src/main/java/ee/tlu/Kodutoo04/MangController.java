package ee.tlu.Kodutoo04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MangController {
    List<Mang> manguAndmed = new ArrayList<>();

    // saa mäng
    // localhost:8080/mangu-andmed
    @GetMapping("mangu-andmed")
    public List<Mang> saaManguAndmed() {
        return manguAndmed;
    }

    // lisa mäng
    // localhost:8080/api/lisamang/1/hoki/10/45/89
    // localhost:8080/api/lisamang/2/jalka/18/90/5
    @PostMapping("lisamang/{id}/{nimi}/{mangijateArv}/{kestus}/{punktiskoor}")
    public List<Mang> lisaMang(
            @PathVariable int id,
            @PathVariable String nimi,
            @PathVariable int mangijateArv,
            @PathVariable int kestus,
            @PathVariable int punktiskoor
    ) {
        Mang andmed = new Mang(id,nimi, mangijateArv, kestus, punktiskoor);
        manguAndmed.add(andmed);
        return manguAndmed;
    }

    // kustuta mäng
    // localhost:8080/api/kustutamang/0
    @DeleteMapping("kustutamang/{id}")
    public List<Mang> kustutaMang(@PathVariable int id) {
        manguAndmed.remove(id);
        return manguAndmed;
    }

    // muuda mängu
    // localhost:8080/api/muudamangu?index=0&nimi=UNO&mangijateArv=4&kestus=30&punktiskoor=123
    @PutMapping("muudamang")
    public List<Mang> muudaMangu(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam int mangijateArv,
            @RequestParam int kestus,
            @RequestParam int punktiskoor
    ) {
        Mang andmed = new Mang(id,nimi, mangijateArv, kestus, punktiskoor);
        manguAndmed.set(id, andmed);
        return manguAndmed;
    }

    // punktiskooride summa
    @GetMapping("punktisumma")
    public int punktiSumma() {
        int summa = 0;
        for(Mang andmed : manguAndmed) {
            summa += andmed.punktiskoor;
        }
        return summa;
    }

    // kõik mängu numbrilised väärtused
    @GetMapping("mangusumma")
    public int manguSumma() {
        int summa = 0;
        for(Mang andmed : manguAndmed) {
            summa += andmed.mangijateArv + andmed.kestus + andmed.punktiskoor;
        }
        return summa;
    }
}