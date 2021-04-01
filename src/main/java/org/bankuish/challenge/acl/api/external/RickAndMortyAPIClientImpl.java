package org.bankuish.challenge.acl.api.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bankuish.challenge.rest.dto.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RyckAndMortyAPIClientImpl implements RyckAndMortyAPIClient {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Collection<Character> retrieveCharacter(List<Integer> ids) {
        Collection<Character> characters = new ArrayList<>();
        ids.forEach( id -> {
            ResponseEntity<String> response
                    = restTemplate.getForEntity("https://rickandmortyapi.com/api/character" + "/" + id , String.class);
            ObjectMapper mapper = new ObjectMapper();
            Character character = null;
            try {
                character = mapper.readValue(response.getBody(), Character.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            characters.add(character);
        });
        return characters;
    }
}
