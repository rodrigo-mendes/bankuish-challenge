package org.bankuish.challenge.acl.api.external;


import org.bankuish.challenge.rest.dto.Character;

import java.util.Collection;
import java.util.List;

public interface RyckAndMortyAPIClient {

    public Collection<Character> retrieveCharacter(List<Integer> ids);
}
