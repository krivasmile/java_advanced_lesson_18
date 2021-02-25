package ua.kyiv.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.kyiv.app.model.Participant;
import ua.kyiv.app.service.ParticipantService;

@Controller
public class ParticipantsController {
	
	@Autowired
	private ParticipantService participantService;

	@GetMapping("/")
	public String init(Model model) {
		model.addAttribute("participants", participantService.readAll());
		model.addAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newParticipant(Model model) {
		model.addAttribute("mode", "PARTICIPANT_CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, Model model) {
		if (participant.getId() == null)
			participantService.create(participant);
		else
			participantService.update(participant);
		model.addAttribute("participants", participantService.readAll());
		model.addAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("participant", participantService.readById(id));
		model.addAttribute("mode", "PARTICIPANT_EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam int id, Model model) {
		participantService.delete(id);
		model.addAttribute("participants", participantService.readAll());
		model.addAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}
}
