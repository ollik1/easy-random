/**
 * The MIT License
 *
 *   Copyright (c) 2019, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package org.jeasy.random.randomizers;

import static org.jeasy.random.randomizers.GenericStringRandomizer.aNewGenericStringRandomizer;
import static java.util.Arrays.asList;
import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenericStringRandomizerTest extends AbstractRandomizerTest<String> {

    private String[] words;

    @BeforeEach
    public void setUp() {
        words = new String[]{"foo", "bar"};
    }

    @Test
    public void randomValueShouldBeGeneratedFromTheGivenWords() {
        // given
        randomizer = aNewGenericStringRandomizer(words);

        // when
        String randomWord = randomizer.getRandomValue();

        then(randomWord).isIn(asList(words));
    }

    @Test
    public void randomValueShouldBeAlwaysTheSameForTheSameSeed() {
        // given
        randomizer = aNewGenericStringRandomizer(words, SEED);

        // when
        String randomWord = randomizer.getRandomValue();

        then(randomWord).isEqualTo("bar");
    }
}