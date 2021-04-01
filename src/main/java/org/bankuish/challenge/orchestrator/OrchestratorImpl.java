package org.bankuish.challenge.orchestrator;

import org.bankuish.challenge.acl.api.external.RickAndMortyAPIClient;
import org.bankuish.challenge.acl.api.simulator.PopularityAPIClient;
import org.bankuish.challenge.generator.CharacterIdGenerator;
import org.bankuish.challenge.dto.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrchestratorImpl implements Orchestrator {

    @Autowired
    private RickAndMortyAPIClient apiClient;
    @Autowired
    private PopularityAPIClient popularityAPIClient;

    @Autowired
    private CharacterIdGenerator idGenerator;

    public List<Character> retrieveCharacters(List<Integer> excludes){
        List<Integer> ids = idGenerator.generateIds(5, excludes);
        Collection<Character>  results = apiClient.retrieveCharacter(ids);
        // recovery Popularity
        results.forEach( character -> popularityAPIClient.retrievePopularity(character));
        return results.stream().collect(Collectors.toList());
    }
}
