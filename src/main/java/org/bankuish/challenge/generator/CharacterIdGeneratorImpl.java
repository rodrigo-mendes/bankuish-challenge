package org.bankuish.challenge.generator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class CharacterIdGeneratorImpl implements CharacterIdGenerator{
    @Override
    public List<Integer> generateIds(int number, List<Integer> excludes) {

        List<Integer> ids = new ArrayList<>();
        Random random = new Random();
        int missingId = number;
        do {
            missingId = missingId - ids.size();
            IntStream.range(1, missingId).forEach( i  -> {
                ids.add(random.nextInt(671));
            });
            ids.removeAll(excludes);
        }while(ids.size() == number);

        return ids;
    }
}
