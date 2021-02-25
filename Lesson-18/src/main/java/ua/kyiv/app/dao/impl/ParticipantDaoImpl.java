package ua.kyiv.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ua.kyiv.app.dao.ParticipantDao;
import ua.kyiv.app.model.Participant;
import ua.kyiv.app.model.enums.Level;

@Repository
public class ParticipantDaoImpl implements ParticipantDao {
	List<Participant> participants ;
	
	{
		participants = new ArrayList<>();
		participants.add(new Participant(1, "Participant-1", "participant-1@gmail.com", Level.L1, "Strong"));
		participants.add(new Participant(2, "Participant-2", "participant-2@gmail.com", Level.L2, "Stronger"));
		participants.add(new Participant(3, "Participant-3", "participant-3@gmail.com", Level.L3, "Strongest"));
		participants.add(new Participant(4, "Participant-4", "participant-4@gmail.com", Level.L4, "More stronger"));
		participants.add(new Participant(5, "Participant-5", "participant-5@gmail.com", Level.L5, "Powerfull"));
	}

	@Override
	public void create(Participant participant) {
		if (participant.getId() == null)
			participant.setId(participants.size() + 1);
		participants.add(participant);
	}

	@Override
	public Participant readById(Integer id) {
		return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
	}

	@Override
	public void update(Participant participant) {
		Participant participantFromList = participants.stream().filter(x -> x.getId() == participant.getId()).findFirst()
				.get();
		participants.set(participants.indexOf(participantFromList), participant);
	}

	@Override
	public void delete(Integer id) {
		participants.remove(participants.stream().filter(x -> x.getId() == id).findFirst().get());
		for (int i = 0; i < participants.size(); i++)
			participants.get(i).setId(i + 1);
	}

	@Override
	public List<Participant> readAll() {
		return participants;
	}
}
