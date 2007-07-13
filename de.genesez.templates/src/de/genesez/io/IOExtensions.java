package de.genesez.io;

/**
 * Helper Class for debug output. Methods are called from
 * the functions in io.ext
 */
public class IOExtensions {
    
    public final static String info(final Object s) {
        System.err.println(s);
        return s.toString();
    }

}