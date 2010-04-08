/*
 * mdx4j is Copyright Luc Boudreau 2010.
 * 
 * It is released under the Eclipse Public License 1.0.
 */

package org.mdx4j;

import org.junit.Assert;
import org.junit.Test;
import org.olap4j.mdx.ParseTreeNode;
import org.olap4j.mdx.parser.MdxParser;

public class Mdx4jParserFactoryTest {

    @Test
    public void testGetParser() {
        Assert.assertNotNull(Mdx4jParserFactory.createMdxParser());
    }

    @Test
    public void testParse() {

        final String query = "SELECT\r\n{} ON COLUMNS,\r\n{} ON ROWS\r\nFROM CUBE";

        final MdxParser parser = Mdx4jParserFactory.createMdxParser();
        Assert.assertNotNull(parser);

        final ParseTreeNode tree = parser.parseSelect(query);
        Assert.assertNotNull(tree);

        final String parsedQuery = tree.toString();
        Assert.assertEquals(query, parsedQuery);
    }
}
