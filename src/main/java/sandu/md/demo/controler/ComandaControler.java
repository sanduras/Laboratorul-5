package sandu.md.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sandu.md.demo.entity.Comanda;
import sandu.md.demo.entity.Produs;
import sandu.md.demo.repository.ComandaRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comanda")

public class ComandaControler {

    @Autowired
    private ComandaRepository comandaRepository;

    @GetMapping
    public List<Comanda> findAll() {
        List<Comanda> comandaList = comandaRepository.findAll();
        return comandaList;
    }

    @GetMapping("/{id_comanda}/{suma}")
    public Comanda findByIdAndSumAndLogin(@PathVariable Long id_comanda, @PathVariable Double suma) {
        Comanda comanda = comandaRepository.finfByIdAndSum(id_comanda, suma);
        return comanda;
    }

   /* @PostMapping //(required = false )
    public void saveRequestParam(@RequestParam Date data_cumpararii, @RequestParam Integer cantitate, @RequestParam Double suma, @RequestParam Long id_users, @RequestParam Long id_produse) {
        comandaRepository.saveRequestParam(data_cumpararii, cantitate, suma, id_users, id_produse);
    }*/

   @PostMapping
   public void saveRequestBody(@RequestBody Comanda comanda) {
       comandaRepository.saveRequestBody(comanda);
   }

    @PutMapping("/{id_comanda}")
    public void updater(@PathVariable Long id_comanda, @RequestBody Comanda comanda) {
       comandaRepository.update(id_comanda, comanda);
    }

    @DeleteMapping("/{id_comanda}")
    public void deleter(@PathVariable Long id_comanda) {
        comandaRepository.delete(id_comanda);
    }
}
