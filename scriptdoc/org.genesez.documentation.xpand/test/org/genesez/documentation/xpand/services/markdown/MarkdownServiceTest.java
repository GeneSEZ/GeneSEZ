package org.genesez.documentation.xpand.services.markdown;

import static org.junit.Assert.*;

import org.genesez.documentation.xpand.service.markdown.MarkdownService;
import org.junit.Before;
import org.junit.Test;

public class MarkdownServiceTest {

	@Test
	public void testBoldConversion() {
		String output = MarkdownService.convertToHtml("This is a **bold** text");
		assert("<p>This is a <strong>bold</strong> text</p>".equals(output));
	}

}
