package org.bankuish.challenge.rest;

import org.bankuish.challenge.dto.Character;
import org.bankuish.challenge.orchestrator.Orchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

@RestController
public class CharacterSelection {

    @Autowired
    private Orchestrator orchestrator;

    @GetMapping(value = "/characters",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Character> getCharacters(@RequestParam(required = false) List<Integer> excludes) {
        return orchestrator.retrieveCharacters(excludes).stream().collect(toCollection(ArrayList::new));
    }
}
