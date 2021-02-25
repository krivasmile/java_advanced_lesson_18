package ua.kyiv.app.dao;
import java.util.List;

import ua.kyiv.app.model.Participant;

public interface ParticipantDao {
	public void create(Participant participant);

	public Participant readById(Integer id);

	public void update(Participant participant);

	public void delete(Integer id);

	public List<Participant> readAll();
}
