package org.bankuish.challenge.acl.api.simulator;

import org.bankuish.challenge.dto.Character;

public interface PopularityAPIClient {
    Character retrievePopularity(Character character);
}
