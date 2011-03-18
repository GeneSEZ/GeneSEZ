<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<!-- xsl:import href="../lib/docbook-xsl-1.76.1/html/docbook.xsl" / -->
<xsl:import href="../lib/docbook-xsl-1.76.1/html/chunk.xsl" />

<xsl:param name="use.id.as.filename" select="1" />
<xsl:param name="chunk.first.sections" select="1" />
<xsl:param name="chunker.output.encoding" select="utf-8" />
<xsl:param name="toc.max.depth" select="2" />
<xsl:param name="chunk.separate.lots" select="1" />

<xsl:param name="section.autolabel" select="1"></xsl:param>
<xsl:param name="section.autolabel.max.depth">3</xsl:param>
<xsl:param name="section.label.includes.component.label" select="1"></xsl:param>

</xsl:stylesheet>
