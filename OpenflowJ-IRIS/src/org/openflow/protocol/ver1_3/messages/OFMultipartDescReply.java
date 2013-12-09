package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFMultipartDescReply extends OFMultipartReply  {
    public static int MINIMUM_LENGTH = 1072;

    String  manufacturer_description;
	String  hardware_description;
	String  software_description;
	String  serial_number;
	String  datapath_description;

    public OFMultipartDescReply() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)19));
		setMultipartType(OFMultipartType.valueOf((short)0, getType()));
    }
    
    public OFMultipartDescReply(OFMultipartDescReply other) {
    	super(other);
		this.manufacturer_description = other.manufacturer_description;
		this.hardware_description = other.hardware_description;
		this.software_description = other.software_description;
		this.serial_number = other.serial_number;
		this.datapath_description = other.datapath_description;
    }

	public String getManufacturerDescription() {
		return this.manufacturer_description;
	}
	
	public OFMultipartDescReply setManufacturerDescription(String manufacturer_description) {
		this.manufacturer_description = manufacturer_description;
		return this;
	}
			
	public String getHardwareDescription() {
		return this.hardware_description;
	}
	
	public OFMultipartDescReply setHardwareDescription(String hardware_description) {
		this.hardware_description = hardware_description;
		return this;
	}
			
	public String getSoftwareDescription() {
		return this.software_description;
	}
	
	public OFMultipartDescReply setSoftwareDescription(String software_description) {
		this.software_description = software_description;
		return this;
	}
			
	public String getSerialNumber() {
		return this.serial_number;
	}
	
	public OFMultipartDescReply setSerialNumber(String serial_number) {
		this.serial_number = serial_number;
		return this;
	}
			
	public String getDatapathDescription() {
		return this.datapath_description;
	}
	
	public OFMultipartDescReply setDatapathDescription(String datapath_description) {
		this.datapath_description = datapath_description;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.manufacturer_description = StringByteSerializer.readFrom(data, 256);
		this.hardware_description = StringByteSerializer.readFrom(data, 256);
		this.software_description = StringByteSerializer.readFrom(data, 256);
		this.serial_number = StringByteSerializer.readFrom(data, 32);
		this.datapath_description = StringByteSerializer.readFrom(data, 256);
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        StringByteSerializer.writeTo(data, 256, manufacturer_description);
		StringByteSerializer.writeTo(data, 256, hardware_description);
		StringByteSerializer.writeTo(data, 256, software_description);
		StringByteSerializer.writeTo(data, 32, serial_number);
		StringByteSerializer.writeTo(data, 256, datapath_description);
    }

    public String toString() {
        return super.toString() +  ":OFMultipartDescReply-"+":manufacturer_description=" + manufacturer_description.toString() + 
		":hardware_description=" + hardware_description.toString() + 
		":software_description=" + software_description.toString() + 
		":serial_number=" + serial_number.toString() + 
		":datapath_description=" + datapath_description.toString();
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	
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
        		
		final int prime = 1871;
		int result = super.hashCode() * prime;
		result = prime * result + ((manufacturer_description == null)?0:manufacturer_description.hashCode());
		result = prime * result + ((hardware_description == null)?0:hardware_description.hashCode());
		result = prime * result + ((software_description == null)?0:software_description.hashCode());
		result = prime * result + ((serial_number == null)?0:serial_number.hashCode());
		result = prime * result + ((datapath_description == null)?0:datapath_description.hashCode());
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
        if (!(obj instanceof OFMultipartDescReply)) {
            return false;
        }
        OFMultipartDescReply other = (OFMultipartDescReply) obj;
		if ( manufacturer_description == null && other.manufacturer_description != null ) { return false; }
		else if ( !manufacturer_description.equals(other.manufacturer_description) ) { return false; }
		if ( hardware_description == null && other.hardware_description != null ) { return false; }
		else if ( !hardware_description.equals(other.hardware_description) ) { return false; }
		if ( software_description == null && other.software_description != null ) { return false; }
		else if ( !software_description.equals(other.software_description) ) { return false; }
		if ( serial_number == null && other.serial_number != null ) { return false; }
		else if ( !serial_number.equals(other.serial_number) ) { return false; }
		if ( datapath_description == null && other.datapath_description != null ) { return false; }
		else if ( !datapath_description.equals(other.datapath_description) ) { return false; }
        return true;
    }
}
