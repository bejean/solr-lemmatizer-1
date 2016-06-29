package com.nicholasding.search.lemmatization;

import com.nicholasding.search.lemmatization.impl.PackagedWordNetReader;
import com.nicholasding.search.lemmatization.impl.WordNetLemmatizer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nicholas Ding (nicholasdsj@gmail.com) on 2016-06-28
 */
public class LemmatizerTest {

    @Test
    public void testStemShouldGetResultFromExceptionList() {
        Lemmatizer lemmatizer = new WordNetLemmatizer(new WordNetReaderStub());
        Assert.assertEquals("radius", lemmatizer.stem("radii", POS.NOUN));
    }

    @Test
    public void testStemShouldGetResultFromTrie() {
        Lemmatizer lemmatizer = new WordNetLemmatizer(new WordNetReaderStub());
        Assert.assertEquals("toy", lemmatizer.stem("toys", POS.NOUN));
    }

    @Test
    public void testStemShouldReturnOriginalForm() {
        Lemmatizer lemmatizer = new WordNetLemmatizer(new WordNetReaderStub());
        Assert.assertEquals("toy", lemmatizer.stem("toy", POS.NOUN));
    }

    @Test
    public void testRealFilesFromResources() {
        Lemmatizer lemmatizer = new WordNetLemmatizer(new PackagedWordNetReader("wordnet.zip"));
        Assert.assertEquals("toy", lemmatizer.stem("toy", POS.NOUN));
        Assert.assertEquals("plant", lemmatizer.stem("plants", POS.NOUN));
        Assert.assertEquals("radius", lemmatizer.stem("radii", POS.NOUN));
    }

}