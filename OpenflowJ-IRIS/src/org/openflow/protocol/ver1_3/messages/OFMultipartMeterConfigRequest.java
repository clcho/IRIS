package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFMultipartMeterConfigRequest extends OFMultipartRequest  {
    public static int MINIMUM_LENGTH = 24;

    int  meter_id;
	int pad_1th;

    public OFMultipartMeterConfigRequest() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)18));
		setMultipartType(OFMultipartType.valueOf((short)10, getType()));
    }
    
    public OFMultipartMeterConfigRequest(OFMultipartMeterConfigRequest other) {
    	super(other);
		this.meter_id = other.meter_id;
    }

	public int getMeterId() {
		return this.meter_id;
	}
	
	public OFMultipartMeterConfigRequest setMeterId(int meter_id) {
		this.meter_id = meter_id;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.meter_id = data.getInt();
		this.pad_1th = data.getInt();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putInt(this.meter_id);
		data.putInt(this.pad_1th);
    }

    public String toString() {
        return super.toString() +  ":OFMultipartMeterConfigRequest-"+":meter_id=" + U32.f(meter_id);
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
        		
		final int prime = 1559;
		int result = super.hashCode() * prime;
		result = prime * result + (int) meter_id;
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
        if (!(obj instanceof OFMultipartMeterConfigRequest)) {
            return false;
        }
        OFMultipartMeterConfigRequest other = (OFMultipartMeterConfigRequest) obj;
		if ( meter_id != other.meter_id ) return false;
        return true;
    }
}
