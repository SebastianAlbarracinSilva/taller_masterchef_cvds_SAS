package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.service;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.dto.RecipeDTO;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.exception.RecipeNotFoundException;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model.Recipe;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe crearReceta(RecipeDTO dto) {
        if (dto.getTipoChef() == ChefType.PARTICIPANTE && dto.getTemporada() == null) {
            throw new IllegalArgumentException("Las recetas de participantes deben tener una temporada asociada");
        }
        Recipe recipe = new Recipe(
                dto.getTitulo(),
                dto.getIngredientes(),
                dto.getPasos(),
                dto.getNombreChef(),
                dto.getTipoChef(),
                dto.getTemporada()
        );
        return repository.save(recipe);
    }

    public List<Recipe> obtenerTodas() { return repository.findAll(); }

    public Recipe obtenerPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Receta no encontrada con id: " + id));
    }

    public List<Recipe> obtenerPorTipoChef(ChefType tipo) { return repository.findByTipoChef(tipo); }

    public List<Recipe> obtenerPorTemporada(Integer temporada) { return repository.findByTemporada(temporada); }

    public List<Recipe> buscarPorIngrediente(String ingrediente) {
        return repository.findByIngredientesContainingIgnoreCase(ingrediente);
    }

    public void eliminar(String id) {
        if (!repository.existsById(id)) {
            throw new RecipeNotFoundException("No existe una receta con id: " + id);
        }
        repository.deleteById(id);
    }

    public Recipe actualizar(String id, RecipeDTO dto) {
        Recipe existente = obtenerPorId(id);
        existente.setTitulo(dto.getTitulo());
        existente.setIngredientes(dto.getIngredientes());
        existente.setPasos(dto.getPasos());
        existente.setNombreChef(dto.getNombreChef());
        existente.setTipoChef(dto.getTipoChef());
        existente.setTemporada(dto.getTemporada());
        return repository.save(existente);
    }
}
