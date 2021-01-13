package sandu.md.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sandu.md.demo.entity.Produs;
import sandu.md.demo.repository.ProdusRepository;

import java.util.List;

@RestController
@RequestMapping("/produs")
public class ProdusControler {

    @Autowired
    private ProdusRepository produsRepository;

    @GetMapping
    public List<Produs> findAll() {
        List<Produs> produsList = produsRepository.findAll();
        return produsList;
    }

    @GetMapping("/{id_produse}")
    public Produs findById(@PathVariable Long id_produse) {
        Produs produs = produsRepository.finfById(id_produse);
        return produs;
    }

    @GetMapping("/{id_produse}/{nume_produse}")
    public Produs findByIdAndName (@PathVariable Long id_produse, @PathVariable String nume_produse) {
        Produs produs = produsRepository.finfByIdAndName(id_produse, nume_produse);
        return produs;
    }
  /*  @GetMapping("/{id_produse}/{pret}")
    public Produs findByIdAndPrice (@PathVariable Long id_produse, @PathVariable Double pret) {
        Produs products = produsRepository.finfByIdAndPrice(id_produse, pret);
        return products;
    }*/

    @PostMapping("/{nume_produse}/{pret}/{brand}/{cantitatea}")
    public void savePathVariable(@PathVariable String nume_produse, @PathVariable Double pret, @PathVariable String brand,@PathVariable Integer cantitatea) {
        produsRepository.savePathVariable(nume_produse, pret, brand, cantitatea);
    }

    @PostMapping// (required = false )
    public void saveRequestParam(@RequestParam String nume_produse, @RequestParam Double pret, @RequestParam String brand,@RequestParam Integer cantitatea) {
        produsRepository.saveRequestParam(nume_produse, pret, brand, cantitatea);
   }

  /*  @PostMapping
    public void saveRequestBody(@RequestBody Produs produs) {
        produsRepository.saveRequestBody(produs);
    }
*/
    @PutMapping("/{id_produse}")
    public void updater(@PathVariable Long id_produse, @RequestBody Produs produs) {
        produsRepository.update(id_produse, produs);
    }

    @DeleteMapping("/{id_produse}")
    public void deleter(@PathVariable Long id_produse) {
        produsRepository.delete(id_produse);
    }

}
