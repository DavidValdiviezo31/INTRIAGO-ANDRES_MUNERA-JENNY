package services;

import models.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

  @Test
  void obtenerOdontologosSinDB() {
    // Arrange
    OdontologoService service = new OdontologoService(false);

    Odontologo od1 = new Odontologo(35453, "Jenny", "Munera");
    Odontologo od2 = new Odontologo(65987, "Andres", "Intriago");

    // Act
    service.guardarOdontologo(od1);
    service.guardarOdontologo(od2);

    // Assert
    List<Odontologo> listaOdontologos = service.obtenerOdontologos();
    assertEquals(2, listaOdontologos.size());
  }

  @Test
  void obtenerOdontologosUsandoDB() {
    // Arrange
    OdontologoService service = new OdontologoService(true);

    Odontologo od1 = new Odontologo(35453, "Jenny", "Munera");
    Odontologo od2 = new Odontologo(65987, "Andres", "Intriago");

    // Act
    service.guardarOdontologo(od1);
    service.guardarOdontologo(od2);

    // Assert
    List<Odontologo> listaOdontologos = service.obtenerOdontologos();
    assertEquals(2, listaOdontologos.size());
  }

  @Test
  void verificarPrimerOdontologo(){
    OdontologoService service = new OdontologoService(false);

    Odontologo od1 = new Odontologo(35453, "Jenny", "Munera");
    Odontologo od2 = new Odontologo(65987, "Andres", "Intriago");

    // Act
    service.guardarOdontologo(od1);
    service.guardarOdontologo(od2);

    // Assert
    List<Odontologo> listaOdontologos = service.obtenerOdontologos();

    assertEquals("Jenny",listaOdontologos.get(0).getNombre());
  }


}