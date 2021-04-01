package org.bankuish.challenge.acl.api.simulator;

import org.bankuish.challenge.dto.Character;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class PopularityAPIClientImpl implements PopularityAPIClient {

        @Override
        public Character retrievePopularity(Character character) {
            Random random = new Random();
            character.setPopularity(random.nextInt(100));
            return character;
    }
}
