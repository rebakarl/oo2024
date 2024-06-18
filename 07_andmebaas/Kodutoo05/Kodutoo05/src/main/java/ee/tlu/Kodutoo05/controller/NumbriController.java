package ee.tlu.Kodutoo05.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumbriController {
    List<Integer> numbrid = new ArrayList<>();

    // näe arvude listi
    @GetMapping("numbrid")
    public List<Integer> saaNumbrid(){
        return numbrid;
    }

    // lisa arv listi
    @PostMapping("numbrid/{number}")
    public List<Integer> lisaNumber(@PathVariable int number) {
        numbrid.add(number);
        return numbrid;
    }

    @DeleteMapping("numbrid/{index}")
    public List<Integer> kustutaNumber(@PathVariable int index) {
        numbrid.remove(index);
        return numbrid;
    }

//    @PutMapping("arvud/{index}/{newValue}")
//    public List<Integer> muudaArv(@PathVariable int index, @PathVariable int newValue) {
//        arvud.set(index, newValue);
//        return arvud;
//    }

    // leia listis olevate numbrite koguarv
    @GetMapping("numbrite-koguarv")
    public int numbriteKoguarv() {
        return numbrid.size();
    }

    // listis olevate numbrite kogusumma
    @GetMapping("kogusumma")
    public int numbriteKogusumma(){
        int summa = 0;
        for(int number : numbrid) {
            summa += number;
        }
        return summa;
    }

    // numbrite keskmine
    @GetMapping("keskmine")
    public double numbriteKeskmine() {
        double summa = 0.0;
        for (int number : numbrid) {
            summa += number;
        }
        return summa / numbrid.size();
    }
}
