/**
 *
 * Our simplest representation of a Wikipedia Page is
 * a binary data array together with a set of properties.
 * 
 **/
package data.wikipedia.dump;

import data.ts.*;
import java.io.Serializable;
import java.util.Properties;

/**
 *
 * @author kamir
 */
public class WikiDumpDataMapper implements Serializable {
    
    public byte[] data;
    
    public WikiDumpDataMapper( byte[] _data ) {
        data = _data;
    }
    
    public Properties props = new Properties();

}
