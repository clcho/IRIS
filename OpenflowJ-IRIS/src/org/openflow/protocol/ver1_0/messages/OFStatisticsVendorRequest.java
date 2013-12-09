package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_0.types.*;

public class OFStatisticsVendorRequest extends OFStatisticsRequest  {
    public static int MINIMUM_LENGTH = 16;

    OFVendor  vendor;
	byte[]  data;

    public OFStatisticsVendorRequest() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)16));
		setStatisticsType(OFStatisticsType.valueOf((short)0xffff, getType()));
		this.vendor = new OFVendor();
    }
    
    public OFStatisticsVendorRequest(OFStatisticsVendorRequest other) {
    	super(other);
		this.vendor = new OFVendor(other.vendor);
		if (other.data != null) { this.data = java.util.Arrays.copyOf(other.data, other.data.length); }
    }

	public OFVendor getVendor() {
		return this.vendor;
	}
	
	public OFStatisticsVendorRequest setVendor(OFVendor vendor) {
		this.vendor = vendor;
		return this;
	}
			
	public byte[] getData() {
		return this.data;
	}
	
	public OFStatisticsVendorRequest setData(byte[] data) {
		this.data = data;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		super.readFrom(data);
		if (this.vendor == null) this.vendor = new OFVendor();
		this.vendor.readFrom(data);
		if ( this.data == null ) this.data = new byte[(getLength() - (data.position() - mark))];
		data.get(this.data);
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        vendor.writeTo(data);
		if ( this.data != null ) { data.put(this.data); }
    }

    public String toString() {
        return super.toString() +  ":OFStatisticsVendorRequest-"+":vendor=" + vendor.toString() + 
		":data=" + java.util.Arrays.toString(data);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	if ( this.data != null ) { len += this.data.length; } 
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(short req) {
    	if (req == 0) return 0;
    	short l = (short)(computeLength() % req);
    	if ( l == 0 ) { return 0; }
    	return (short)( req - l );
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	return (short)(computeLength() - (short)MINIMUM_LENGTH + alignment((short)0));
    }

    @Override
    public int hashCode() {
        		
		final int prime = 2539;
		int result = super.hashCode() * prime;
		result = prime * result + ((vendor == null)?0:vendor.hashCode());
		result = prime * result + ((data == null)?0:java.util.Arrays.hashCode(data));
		return result;
    }

    @Override
    public boolean equals(Object obj) {
        
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OFStatisticsVendorRequest)) {
            return false;
        }
        OFStatisticsVendorRequest other = (OFStatisticsVendorRequest) obj;
		if ( vendor == null && other.vendor != null ) { return false; }
		else if ( !vendor.equals(other.vendor) ) { return false; }
		if ( data == null && other.data != null ) { return false; }
		else if ( !java.util.Arrays.equals(data, other.data) ) { return false; }
        return true;
    }
}
