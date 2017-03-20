package elections.dao.service;

import java.util.List;

import elections.dao.entities.ListeElectorale;

public interface IElectionsDao {
	
public double getSeuilElectoral();

public int getNbSiegesAPourvoir();

public List<ListeElectorale> getListesElectorales();

public void setListesElectorales(List<ListeElectorale> listesElectorales);

public String getInFileName();



}
