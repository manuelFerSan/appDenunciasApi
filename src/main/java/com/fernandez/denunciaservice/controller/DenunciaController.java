package com.fernandez.denunciaservice.controller;

import com.fernandez.denunciaservice.entity.Denuncia;
import com.fernandez.denunciaservice.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
@CrossOrigin(origins = "*")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @PostMapping("/")
    public ResponseEntity<Denuncia> registrar(@RequestBody Denuncia denuncia) {
        Denuncia nueva = denunciaService.registrar(denuncia);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping("/")
    public List<Denuncia> listar(@RequestParam(defaultValue = "0") int offset,
                                @RequestParam(defaultValue = "5") int limit) {
        return denunciaService.listar(offset, limit);
    }

    @GetMapping("/{id}")
    public Denuncia obtener(@PathVariable Integer id) {
        return denunciaService.obtenerPorId(id);
    }

    @GetMapping("/ciudadano/{dni}")
    public List<Denuncia> porCiudadano(@PathVariable String dni) {
        return denunciaService.obtenerPorCiudadano(dni);
    }

    @PutMapping("/{id}")
    public Denuncia atender(@PathVariable Integer id) {
        return denunciaService.atender(id);
    }
}
