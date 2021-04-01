package org.bankuish.challenge.generator;

import java.util.List;

public interface CharacterIdGenerator {

    List<Integer> generateIds(int number, List<Integer> excludes);
}
