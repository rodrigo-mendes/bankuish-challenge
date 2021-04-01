package org.bankuish.challenge.orchestrator;

import org.bankuish.challenge.dto.Character;

import java.util.List;

public interface Orchestrator {

    public List<Character> retrieveCharacters(List<Integer> excludes);
}
