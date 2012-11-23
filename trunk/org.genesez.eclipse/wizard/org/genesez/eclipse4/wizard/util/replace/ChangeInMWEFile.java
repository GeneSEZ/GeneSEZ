/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse4.wizard.util.replace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.ReplaceEdit;

/**
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 *
 */
public class ChangeInMWEFile implements ChangeInFile {
	
	private ArrayList<Change> change;

	@Override
	public Change[] createChange(IFile file, Properties properties) {
		change = new ArrayList<Change>();
		String extension = file.getFileExtension();
		String oldfile = properties.getProperty(OLDNAME).replace(".generator", "");
		String newfile = properties.getProperty(NEWNAME).replace(".generator", "");
		if(file.exists() && (extension.equals("mwe") || extension.equals("mwe2"))){
			// Reads the file into memory
			StringBuffer sb = new StringBuffer(1000);
			{
				BufferedReader reader = null;
				try {
				char [] h = new char[2048];
				reader = new BufferedReader(new InputStreamReader(file.getContents()));
				int anz = 0;
				while((anz = reader.read(h)) >= 0)
					for(int i = 0; i < anz; i++)
						sb.append(h[i]);
				} catch (CoreException e) {
				} catch (IOException e){	
				} finally {
					if(reader != null){
						try {
							reader.close();
						} catch (IOException e) {
						}
					}
				}
			}
			int position, pos = sb.indexOf(oldfile);
			while(pos != -1){
				TextFileChange change = new TextFileChange("Rename " + oldfile + " to " + newfile + " in " + file.getName(), file);
				change.setEdit(new ReplaceEdit(pos, oldfile.length(), newfile));
				System.out.println(change.getParent());
				this.change.add(change);
				position = pos + oldfile.length();
				pos = sb.indexOf(oldfile,position);
			}
			
		}
		return change.toArray(new Change[change.size()]);
	}

	@Override
	public void executeChange(IProgressMonitor pm) {
		try {
			for(Change change : this.change)
				change.perform(pm);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
}
