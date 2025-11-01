package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.repository;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeRepositoryTest {

    @Mock
    private RecipeRepository repository;

    private Recipe recipe;

    @BeforeEach
    void setup() {
        recipe = new Recipe(
                "Tarta de Chocolate",
                List.of("Chocolate", "Harina", "Huevos"),
                List.of("Mezclar", "Hornear"),
                "Sofía",
                ChefType.CHEF,
                2
        );
    }

    @Test
    @DisplayName("Buscar por tipo de chef devuelve recetas correctas")
    void testFindByTipoChef() {
        when(repository.findByTipoChef(ChefType.CHEF)).thenReturn(List.of(recipe));

        List<Recipe> result = repository.findByTipoChef(ChefType.CHEF);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Tarta de Chocolate", result.get(0).getTitulo());
        verify(repository).findByTipoChef(ChefType.CHEF);
    }

    @Test
    @DisplayName("Buscar por temporada devuelve recetas correctas")
    void testFindByTemporada() {
        when(repository.findByTemporada(2)).thenReturn(List.of(recipe));

        List<Recipe> result = repository.findByTemporada(2);

        assertFalse(result.isEmpty());
        assertEquals(2, result.get(0).getTemporada());
        verify(repository).findByTemporada(2);
    }

    @Test
    @DisplayName("Buscar por ingrediente ignora mayúsculas/minúsculas")
    void testFindByIngrediente() {
        when(repository.findByIngredientesContainingIgnoreCase("chocolate")).thenReturn(List.of(recipe));

        List<Recipe> result = repository.findByIngredientesContainingIgnoreCase("chocolate");

        assertEquals(1, result.size());
        assertTrue(result.get(0).getIngredientes().contains("Chocolate"));
        verify(repository).findByIngredientesContainingIgnoreCase("chocolate");
    }
}
