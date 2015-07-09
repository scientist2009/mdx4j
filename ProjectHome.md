Provides a MDX query language parser to Java code.

Example usage:

```
final String query = "SELECT{} ON COLUMNS FROM CUBE";
final MdxParser parser = Mdx4jParserFactory.createMdxParser();
final ParseTreeNode tree = parser.parseSelect(query);
```