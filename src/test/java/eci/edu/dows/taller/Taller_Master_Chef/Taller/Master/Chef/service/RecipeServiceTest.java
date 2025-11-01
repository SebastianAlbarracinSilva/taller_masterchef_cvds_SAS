package eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.service;

import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.dto.RecipeDTO;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.enums.ChefType;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.exception.RecipeNotFoundException;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.model.Recipe;
import eci.edu.dows.taller.Taller_Master_Chef.Taller.Master.Chef.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {

    @Mock
    private RecipeRepository repository;

    @InjectMocks
    private RecipeService service;

    private Recipe recipe;
    private RecipeDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dto = new RecipeDTO();
        dto.setTitulo("Ceviche");
        dto.setIngredientes(Arrays.asList("Pescado", "Limón"));
        dto.setPasos(Arrays.asList("Cortar", "Marinar"));
        dto.setNombreChef("Gastón Acurio");
        dto.setTipoChef(ChefType.CHEF);
        dto.setTemporada(1);

        recipe = new Recipe("Ceviche", dto.getIngredientes(), dto.getPasos(), dto.getNombreChef(), dto.getTipoChef(), dto.getTemporada());
    }

    @Test
    @DisplayName("Caso exitoso - Crear receta correctamente")
    void testCrearReceta_Exitoso() {
        when(repository.save(any())).thenReturn(recipe);

        Recipe result = service.crearReceta(dto);

        assertAll("Validar receta creada",
                () -> assertEquals("Ceviche", result.getTitulo()),
                () -> assertEquals(dto.getTipoChef(), result.getTipoChef())
        );
    }

    @Test
    @DisplayName("Caso borde - Lanzar excepción si participante sin temporada")
    void testCrearReceta_ParticipanteSinTemporada_Borde() {
        dto.setTipoChef(ChefType.PARTICIPANTE);
        dto.setTemporada(null);

        assertThrows(IllegalArgumentException.class, () -> service.crearReceta(dto));
    }

    @Test
    @DisplayName("Caso exitoso - Obtener todas las recetas")
    void testObtenerTodas_Exitoso() {
        when(repository.findAll()).thenReturn(List.of(recipe));
        List<Recipe> result = service.obtenerTodas();

        assertAll("Validar lista de recetas",
                () -> assertNotNull(result),
                () -> assertEquals(1, result.size())
        );
    }

    @Test
    @DisplayName("Caso exitoso - Obtener receta por ID existente")
    void testObtenerPorId_Exitoso() {
        when(repository.findById("1")).thenReturn(Optional.of(recipe));
        Recipe result = service.obtenerPorId("1");

        assertEquals("Ceviche", result.getTitulo());
    }

    @Test
    @DisplayName("Caso borde - Lanzar excepción si no existe receta por ID")
    void testObtenerPorId_NoEncontrada_Borde() {
        when(repository.findById("99")).thenReturn(Optional.empty());
        assertThrows(RecipeNotFoundException.class, () -> service.obtenerPorId("99"));
    }

    @Test
    @DisplayName("Caso exitoso - Eliminar receta existente")
    void testEliminar_Exitoso() {
        when(repository.existsById("1")).thenReturn(true);
        service.eliminar("1");
        verify(repository).deleteById("1");
    }

    @Test
    @DisplayName("Caso borde - Eliminar receta inexistente lanza excepción")
    void testEliminar_NoExistente_Borde() {
        when(repository.existsById("1")).thenReturn(false);
        assertThrows(RecipeNotFoundException.class, () -> service.eliminar("1"));
    }

    @Test
    @DisplayName("Caso exitoso - Actualizar receta correctamente")
    void testActualizar_Exitoso() {
        when(repository.findById("1")).thenReturn(Optional.of(recipe));
        when(repository.save(any())).thenReturn(recipe);

        Recipe result = service.actualizar("1", dto);

        assertAll("Validar actualización",
                () -> assertEquals(dto.getTitulo(), result.getTitulo()),
                () -> assertEquals(dto.getNombreChef(), result.getNombreChef())
        );
    }
}
