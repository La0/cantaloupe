package edu.illinois.library.cantaloupe.processor;

import edu.illinois.library.cantaloupe.image.Format;
import edu.illinois.library.cantaloupe.image.Info;
import edu.illinois.library.cantaloupe.operation.OperationList;
import edu.illinois.library.cantaloupe.resource.iiif.ProcessorFeature;
import edu.illinois.library.cantaloupe.resource.iiif.v1.Quality;

import java.io.File;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

public class MockFileProcessor implements FileProcessor {

    private Format sourceFormat;
    private File file;

    @Override
    public Set<Format> getAvailableOutputFormats() {
        return new HashSet<>();
    }

    @Override
    public Format getSourceFormat() {
        return sourceFormat;
    }

    @Override
    public File getSourceFile() {
        return file;
    }

    @Override
    public Set<ProcessorFeature> getSupportedFeatures() {
        return new HashSet<>();
    }

    @Override
    public Set<Quality> getSupportedIIIF1Qualities() {
        return new HashSet<>();
    }

    @Override
    public Set<edu.illinois.library.cantaloupe.resource.iiif.v2.Quality>
    getSupportedIIIF2Qualities() {
        return new HashSet<>();
    }

    @Override
    public void process(OperationList opList, Info sourceInfo,
                        OutputStream outputStream) throws ProcessorException {
        // no-op
    }

    @Override
    public Info readImageInfo() throws ProcessorException {
        return new Info();
    }

    @Override
    public void setSourceFormat(Format format)
            throws UnsupportedSourceFormatException {
        this.sourceFormat = format;
    }

    @Override
    public void setSourceFile(File file) {
        this.file = file;
    }

}
