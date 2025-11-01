package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model.Recipe;
import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    List<Recipe> findByTipoChef(ChefType tipoChef);
    List<Recipe> findByTemporada(Integer temporada);
    List<Recipe> findByIngredientesContainingIgnoreCase(String ingrediente);
}
