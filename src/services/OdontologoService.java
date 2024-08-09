package services;

import dao.IDao;
import dao.impl.OdontologoCollectionImpl;
import dao.impl.OdontologoH2Impl;
import models.Odontologo;

import java.util.List;

public class OdontologoService {
  private IDao<Odontologo> idao;

  public OdontologoService(boolean usarDatabase) {
    this.idao = usarDatabase ? new OdontologoH2Impl() : new OdontologoCollectionImpl();
  }

  public Odontologo guardarOdontologo(Odontologo odontologo) {
    return idao.guardar(odontologo);
  }

  public List<Odontologo> obtenerOdontologos() {
    return idao.listarTodos();
  }

}
