<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:fo="http://www.w3.org/1999/XSL/Format"   
                version="1.0">

<xsl:import href="file:///d:/libraries/docbook/docbook-xsl-1.73.2/fo/docbook.xsl"/>

<xsl:param name="use.extensions">1</xsl:param>
<xsl:param name="fop1.extensions">1</xsl:param>

<xsl:param name="paper.type">A4</xsl:param>
<xsl:param name="page.margin.inner">0.75in</xsl:param>
<xsl:param name="page.margin.outer">0.50in</xsl:param>
<xsl:param name="page.margin.top">0.17in</xsl:param>
<xsl:param name="page.margin.bottom">0.50in</xsl:param>

<xsl:param name="body.font.family">sans-serif</xsl:param>
<xsl:param name="body.start.indent">
  <xsl:choose>
    <xsl:when test="$fop.extensions != 0">0pt</xsl:when>
    <xsl:when test="$passivetex.extensions != 0">0pt</xsl:when>
    <xsl:otherwise>0pt</xsl:otherwise>
  </xsl:choose>
</xsl:param>

<xsl:param name="section.autolabel" select="1"></xsl:param>
<xsl:param name="section.autolabel.max.depth">3</xsl:param>

<xsl:param name="variablelist.as.blocks" select="1"></xsl:param>

<xsl:attribute-set name="monospace.verbatim.properties">
    <xsl:attribute name="wrap-option">wrap</xsl:attribute>
    <xsl:attribute name="hyphenation-character">\</xsl:attribute>
</xsl:attribute-set>


</xsl:stylesheet>
