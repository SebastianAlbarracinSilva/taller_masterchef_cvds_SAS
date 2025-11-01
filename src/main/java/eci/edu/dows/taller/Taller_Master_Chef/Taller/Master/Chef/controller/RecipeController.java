package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.controller;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.dto.RecipeDTO;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model.Recipe;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @PostMapping
    public Recipe crearReceta(@RequestBody RecipeDTO dto) {
        return service.crearReceta(dto);
    }

    @GetMapping
    public List<Recipe> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Recipe obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Recipe> obtenerPorTipo(@PathVariable ChefType tipo) {
        return service.obtenerPorTipoChef(tipo);
    }

    @GetMapping("/temporada/{temporada}")
    public List<Recipe> obtenerPorTemporada(@PathVariable Integer temporada) {
        return service.obtenerPorTemporada(temporada);
    }

    @GetMapping("/buscar")
    public List<Recipe> buscarPorIngrediente(@RequestParam String ingrediente) {
        return service.buscarPorIngrediente(ingrediente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}")
    public Recipe actualizar(@PathVariable String id, @RequestBody RecipeDTO dto) {
        return service.actualizar(id, dto);
    }
}
