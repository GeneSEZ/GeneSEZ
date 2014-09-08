package org.genesez.adapter.magicdraw;

import java.io.IOException;
import net.ser1.stomp.Server;

/**
 * Server running in plugin. connected MD-client and client in the workflow
 */
public class MDServer extends Server
{
	public MDServer() throws IOException
	{
		super(12345);
	}
}
