package ee.tlu.Kodutoo04;

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
    @PostMapping("lisanr/{number}")
    public List<Integer> lisaNr(@PathVariable int number) {
        numbrid.add(number);
        return numbrid;
    }

    @DeleteMapping("kustutanr/{index}")
    public List<Integer> kustutaNr(@PathVariable int index) {
        numbrid.remove(index);
        return numbrid;
    }


    // listis olevate numbrite koguarv
    @GetMapping("numbrite-koguarv")
    public int numbriteKoguarv() {
        return numbrid.size();
    }

    // listis olevate numbrite summa
    @GetMapping("summa")
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
