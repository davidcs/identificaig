package br.com.identificaig.Idetificaig.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.identificaig.Idetificaig.dtos.PinDTO;
import br.com.identificaig.Idetificaig.models.Pin;
import br.com.identificaig.Idetificaig.repository.PinRepository;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PinController {

    @Autowired
    private PinRepository pinRepository;
    
    @PostMapping("/pin")
    public ResponseEntity<Pin> savePin(@RequestBody @Valid PinDTO pinDTO) {
        var pin = new Pin();
        BeanUtils.copyProperties(pinDTO, pin);
        return ResponseEntity.status(HttpStatus.CREATED).body(pinRepository.save(pin));
    }
    
    @GetMapping("/pin")
    public ResponseEntity<List<Pin>> getAllPin() {
        List<Pin> pinList = pinRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pinList);
    }
    
    @GetMapping("/pin/{id}")
    public ResponseEntity<Pin> getPinById(@PathVariable("id") UUID id) {
        Optional<Pin> pin = pinRepository.findById(id);
        return pin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @PutMapping("/pin/{id}")
    public ResponseEntity<Pin> updatePin(@PathVariable("id") UUID id, @RequestBody @Valid PinDTO pinDTO) {
        Optional<Pin> existingPinOptional = pinRepository.findById(id);
        if (existingPinOptional.isPresent()) {
            var existingPin = existingPinOptional.get();
            BeanUtils.copyProperties(pinDTO, existingPin, "id"); // Exclui o id para não sobrescrever
            return ResponseEntity.ok(pinRepository.save(existingPin));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/pin/{id}")
    public ResponseEntity<Void> deletePin(@PathVariable("id") UUID id) {
        if (pinRepository.existsById(id)) {
            pinRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
