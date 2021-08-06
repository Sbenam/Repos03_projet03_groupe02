package fr.eql.ai109.apptontapat.idao;

import fr.eql.ai109.apptontapat.entity.Herd;

public interface HerdIDao extends GenericIDao<Herd> {
	public void addHerd(Herd herd);
	public Herd getHerdById(int id);
}
