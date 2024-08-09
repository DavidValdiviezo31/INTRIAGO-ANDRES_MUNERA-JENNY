package dao.impl;

import dao.IDao;
import models.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoCollectionImpl implements IDao<Odontologo> {
  private static final Logger logger = Logger.getLogger(OdontologoCollectionImpl.class);

  private static List<Odontologo> odontologos = new ArrayList<>();

  @Override
  public Odontologo guardar(Odontologo odontologo) {
    odontologos.add(odontologo);
    logger.info("Odontologo guardado en la lista: " + odontologo);

    return odontologo;
  }

  @Override
  public List<Odontologo> listarTodos() {
    odontologos.forEach(logger::info);

    return odontologos;
  }
}
