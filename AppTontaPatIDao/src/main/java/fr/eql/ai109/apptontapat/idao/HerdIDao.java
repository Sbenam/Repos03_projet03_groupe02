package fr.eql.ai109.apptontapat.idao;

import java.util.List;

import fr.eql.ai109.apptontapat.entity.Herd;

public interface HerdIDao extends GenericIDao<Herd> {
	public void addHerd(Herd herd);
	public Herd getHerdById(int id);
	public Herd getHerdByIdAccount(int id);
	public List<Herd> getAllHerd();
	public List<Herd> getAllHerdByIdAccount(int id);
}
