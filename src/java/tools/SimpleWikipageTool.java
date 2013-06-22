package tools;


import data.io.adapter.HBaseTSAdapter;
import data.io.adapter.HBaseWikiAdapter;
import data.ts.TSDataMapper;
import data.wikipedia.dump.WikiDumpDataMapper;
import java.io.IOException;

/*
 *  Create some Wikipages and store them in HBase.
 */

/**
 *
 * @author kamir
 */
public class SimpleWikipageTool {
    
    public static void main( String[] args ) throws IOException, Exception {
        
        String defaultIP = "127.0.0.1";
        
        if ( args != null ) 
            defaultIP = args[0];
        
        System.out.println( defaultIP );
        
        boolean doCreate = true;
        boolean doLoad = true;
        int nrOfRows = 25;
        
        HBaseWikiAdapter.init( defaultIP );

        if ( doCreate ) {
            for( int i = 0; i < nrOfRows ; i++ ) {
                WikiDumpDataMapper mapper = new WikiDumpDataMapper( (i+") Meine Seite").getBytes() );
                HBaseWikiAdapter.putArticle( "wikipages", mapper , ""+i );
            }

            System.out.println( "Done ..." );
        }
        
        if ( doLoad ) {
            System.out.println( "Start loading ... ");
            // load all data from DB ...
            for( int i = 0; i < nrOfRows ; i++ ) {
                Object o = HBaseWikiAdapter.getArticle( "wikipages", ""+i );
                WikiDumpDataMapper mapper = (WikiDumpDataMapper)o;
                // System.out.println( mapper.data.length );
            }
        }
        
    }
    
}
