<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<!-- xsl:import href="../lib/docbook-xsl-1.76.1/html/docbook.xsl" / -->
<xsl:import href="../lib/docbook-xsl-1.76.1/html/onechunk.xsl" />

<xsl:param name="html.stylesheet" select="'style.css'" />
<xsl:param name="root.filename" select="'all'" />

<xsl:param name="toc.max.depth" select="2" />
<xsl:param name="chunk.separate.lots" select="1" />

<xsl:param name="generate.toc">
appendix  nop
article   nop
book      toc,title,figure,table,example,equation
chapter   nop
part      nop
preface   nop
qandadiv  nop
qandaset  nop
reference nop
section   nop
set       nop
</xsl:param>

<xsl:param name="section.autolabel" select="1"></xsl:param>
<xsl:param name="section.autolabel.max.depth">3</xsl:param>
<xsl:param name="section.label.includes.component.label" select="1"></xsl:param>

</xsl:stylesheet>
