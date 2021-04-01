package org.bankuish.challenge.acl.api.external;


import org.bankuish.challenge.dto.Character;

import java.util.Collection;
import java.util.List;

public interface RickAndMortyAPIClient {

    public Collection<Character> retrieveCharacter(List<Integer> ids);
}
