package net.flexmojos.oss.plugin.flexbuilder.sdk;

public enum Kind {
	DIR( 1 ), UNKNOWN( 2 ), FILE( 3 ), GROUP ( 4 ), PACKAGE ( 5 ) ;
	
	private int id;

    private Kind( int id )
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
    
    public static Kind getDefaultKind() {
    	return FILE;
    }
}
