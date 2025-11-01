package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.controller;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.dto.RecipeDTO;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model.Recipe;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecipeControllerTest {

    @Mock
    private RecipeService service;

    private RecipeController controller;
    private Recipe recipe;
    private RecipeDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new RecipeController(service);
        dto = new RecipeDTO();
        dto.setTitulo("Arepas");
        dto.setTipoChef(ChefType.CHEF);
        recipe = new Recipe("Arepas", List.of("Maíz"), List.of("Cocinar"), "Juan", ChefType.CHEF, 2);
    }

    @Test
    @DisplayName("Caso exitoso - Crear receta")
    void testCrearReceta_Exitoso() {
        when(service.crearReceta(dto)).thenReturn(recipe);
        assertEquals(recipe, controller.crearReceta(dto));
    }

    @Test
    @DisplayName("Caso exitoso - Obtener todas las recetas")
    void testObtenerTodas_Exitoso() {
        when(service.obtenerTodas()).thenReturn(List.of(recipe));
        assertEquals(1, controller.obtenerTodas().size());
    }

    @Test
    @DisplayName("Caso exitoso - Eliminar receta")
    void testEliminar_Exitoso() {
        controller.eliminar("1");
        verify(service).eliminar("1");
    }
}
