package edu.illinois.library.cantaloupe.processor;

import edu.illinois.library.cantaloupe.config.Configuration;
import edu.illinois.library.cantaloupe.image.Format;
import edu.illinois.library.cantaloupe.image.Scale;
import edu.illinois.library.cantaloupe.resource.iiif.ProcessorFeature;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static edu.illinois.library.cantaloupe.processor.OpenJpegProcessor.DOWNSCALE_FILTER_CONFIG_KEY;
import static edu.illinois.library.cantaloupe.processor.OpenJpegProcessor.UPSCALE_FILTER_CONFIG_KEY;
import static org.junit.Assert.*;

public class OpenJpegProcessorTest extends ProcessorTest {

    OpenJpegProcessor instance;

    @Before
    public void setUp() throws Exception {
        Configuration.getInstance().setProperty(
                OpenJpegProcessor.PATH_TO_BINARIES_CONFIG_KEY, "/usr/local/bin");

        instance = new OpenJpegProcessor();
        instance.setSourceFormat(Format.JP2);
    }

    protected Processor getProcessor() {
        return instance;
    }

    @Test
    public void testGetDownscaleFilter() {
        assertNull(instance.getDownscaleFilter());

        final Configuration config = Configuration.getInstance();
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "bell");
        assertEquals(Scale.Filter.BELL, instance.getDownscaleFilter());
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "bicubic");
        assertEquals(Scale.Filter.BICUBIC, instance.getDownscaleFilter());
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "bspline");
        assertEquals(Scale.Filter.BSPLINE, instance.getDownscaleFilter());
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "box");
        assertEquals(Scale.Filter.BOX, instance.getDownscaleFilter());
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "hermite");
        assertEquals(Scale.Filter.HERMITE, instance.getDownscaleFilter());
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "lanczos3");
        assertEquals(Scale.Filter.LANCZOS3, instance.getDownscaleFilter());
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "mitchell");
        assertEquals(Scale.Filter.MITCHELL, instance.getDownscaleFilter());
        config.setProperty(DOWNSCALE_FILTER_CONFIG_KEY, "triangle");
        assertEquals(Scale.Filter.TRIANGLE, instance.getDownscaleFilter());
    }

    @Test
    public void testGetUpscaleFilter() {
        assertNull(instance.getUpscaleFilter());

        final Configuration config = Configuration.getInstance();
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "bell");
        assertEquals(Scale.Filter.BELL, instance.getUpscaleFilter());
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "bicubic");
        assertEquals(Scale.Filter.BICUBIC, instance.getUpscaleFilter());
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "bspline");
        assertEquals(Scale.Filter.BSPLINE, instance.getUpscaleFilter());
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "box");
        assertEquals(Scale.Filter.BOX, instance.getUpscaleFilter());
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "hermite");
        assertEquals(Scale.Filter.HERMITE, instance.getUpscaleFilter());
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "lanczos3");
        assertEquals(Scale.Filter.LANCZOS3, instance.getUpscaleFilter());
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "mitchell");
        assertEquals(Scale.Filter.MITCHELL, instance.getUpscaleFilter());
        config.setProperty(UPSCALE_FILTER_CONFIG_KEY, "triangle");
        assertEquals(Scale.Filter.TRIANGLE, instance.getUpscaleFilter());
    }

    @Test
    public void testGetSupportedFeatures() throws Exception {
        Set<ProcessorFeature> expectedFeatures = new HashSet<>();
        expectedFeatures.add(ProcessorFeature.MIRRORING);
        expectedFeatures.add(ProcessorFeature.REGION_BY_PERCENT);
        expectedFeatures.add(ProcessorFeature.REGION_BY_PIXELS);
        expectedFeatures.add(ProcessorFeature.REGION_SQUARE);
        expectedFeatures.add(ProcessorFeature.ROTATION_ARBITRARY);
        expectedFeatures.add(ProcessorFeature.ROTATION_BY_90S);
        expectedFeatures.add(ProcessorFeature.SIZE_ABOVE_FULL);
        expectedFeatures.add(ProcessorFeature.SIZE_BY_DISTORTED_WIDTH_HEIGHT);
        expectedFeatures.add(ProcessorFeature.SIZE_BY_FORCED_WIDTH_HEIGHT);
        expectedFeatures.add(ProcessorFeature.SIZE_BY_HEIGHT);
        expectedFeatures.add(ProcessorFeature.SIZE_BY_PERCENT);
        expectedFeatures.add(ProcessorFeature.SIZE_BY_WIDTH);
        expectedFeatures.add(ProcessorFeature.SIZE_BY_WIDTH_HEIGHT);
        assertEquals(expectedFeatures, instance.getSupportedFeatures());
    }

}
