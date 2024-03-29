package com.edu.bbte.aaim2111.renewableenergy3layer.ui.api;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.services.interfaces.IEnergySourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/energy-sources")
public class EnergySourceController {
    private final IEnergySourceService energyService;

    @Autowired
    public EnergySourceController(IEnergySourceService energyService) {
        this.energyService = energyService;
    }

    @GetMapping
    public ResponseEntity<List<EnergySourceDisplayDTO>> getAllEnergySources() {
        List<EnergySourceDisplayDTO> sources = energyService.findAllAvailable();
        return ResponseEntity.ok(sources);
    }

    @PostMapping
    public ResponseEntity<EnergySourceDisplayDTO> addEnergySource(@Valid @RequestBody EnergySourceCreateUpdateDTO newSource) {
        EnergySourceDisplayDTO source = energyService.addNewEnergySource(newSource);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(source.getId())
                .toUri();

        return ResponseEntity.created(location).body(source);
    }

    @PostMapping("/{id}/increase-stock")
    public ResponseEntity<?> increaseEnergySourceStock(@PathVariable Long id, @RequestParam Double amount) {
        try {
            EnergySourceDisplayDTO source = energyService.increaseEnergySourceStock(id, amount);
            return ResponseEntity.ok(source);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<?> purchaseEnergySource(@PathVariable Long id, @RequestParam Double amount) {
        try {
            EnergySourceDisplayDTO source = energyService.purchaseEnergySource(id, amount);
            return ResponseEntity.ok(source);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
