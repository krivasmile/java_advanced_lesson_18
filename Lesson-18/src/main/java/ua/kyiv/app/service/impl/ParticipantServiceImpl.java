package ua.kyiv.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.app.dao.ParticipantDao;
import ua.kyiv.app.model.Participant;
import ua.kyiv.app.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {
	
	@Autowired
	private ParticipantDao participantDao;

	@Override
	public void create(Participant participant) {
		participantDao.create(participant);		
	}

	@Override
	public Participant readById(Integer id) {
		return participantDao.readById(id);
	}

	@Override
	public void update(Participant participant) {
		participantDao.update(participant);		
	}

	@Override
	public void delete(Integer id) {
		participantDao.delete(id);
	}

	@Override
	public List<Participant> readAll() {
		return participantDao.readAll();
	}

}
