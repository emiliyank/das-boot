package ek.pluralsight.dasboot.controller;

import ek.pluralsight.dasboot.model.Shipwreck;
import ek.pluralsight.dasboot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api/v1/shipwrecks")
public class ShipwreckController {
    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @GetMapping("api/v1/shipwrecks")
    public List<Shipwreck> list() {
        return shipwreckRepository.findAll();
    }

    @PostMapping("api/v1/shipwrecks")
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @GetMapping("api/v1/shipwrecks/{id}")
    public Shipwreck get(@PathVariable Long id) {
        Optional<Shipwreck> shipwreck = shipwreckRepository.findById(id);
        if(shipwreck != null) {
            return shipwreck.get();
        } else {
            return null;
        }
    }

    @PutMapping("api/v1/shipwrecks/{id}")
    public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck) {
        Optional<Shipwreck> optionalShipwreck = shipwreckRepository.findById(id);
        if(optionalShipwreck != null) {
            Shipwreck existingShipwreck = optionalShipwreck.get();
            BeanUtils.copyProperties(shipwreck, existingShipwreck);
            return shipwreckRepository.saveAndFlush(existingShipwreck);
        } else {
            return shipwreck;
        }
    }

    @DeleteMapping("api/v1/shipwrecks/{id}")
    public Shipwreck delete(@PathVariable long id) {
        Optional<Shipwreck> optionalShipwreck = shipwreckRepository.findById(id);
        Shipwreck shipwreck = null;
        if(optionalShipwreck != null) {
            shipwreck = optionalShipwreck.get();
        }
        shipwreckRepository.deleteById(id);

        return shipwreck;
    }
}
