/*
 * mdx4j is Copyright Luc Boudreau 2010.
 * 
 * It is released under the Eclipse Public License 1.0.
 */

package org.mdx4j;

import org.olap4j.OlapConnection;
import org.olap4j.mdx.parser.MdxParser;
import org.olap4j.mdx.parser.MdxParserFactory;
import org.olap4j.mdx.parser.MdxValidator;
import org.olap4j.mdx.parser.impl.DefaultMdxParserImpl;

/**
 * <p>Utility class to obtain a {@link MdxParser}. It's default implementation
 * is backed by olap4j's parser.
 * <p>You can use it statically or as an olap4j's MdxParserFactory object.
 * @author Luc Boudreau
 */
public class Mdx4jParserFactory implements MdxParserFactory {

    private final static Mdx4jParserFactory instance = new Mdx4jParserFactory();

    public MdxParser createMdxParser(OlapConnection olapConnection) {
        return new DefaultMdxParserImpl();
    }

    /**
     * Obtain a MdxParser object.
     */
    public static MdxParser createMdxParser() {
        return instance.createMdxParser(null);
    }

    public MdxValidator createMdxValidator(OlapConnection olapConnection) {
        if (olapConnection == null) {
            throw new NullPointerException("olapConnection cannot be null.");
        }
        return olapConnection.getParserFactory().createMdxValidator(olapConnection);
    }
}