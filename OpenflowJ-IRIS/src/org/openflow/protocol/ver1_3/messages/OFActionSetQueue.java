package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFActionSetQueue extends OFAction  {
    public static int MINIMUM_LENGTH = 8;

    int  queue_id;

    public OFActionSetQueue() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFActionType.valueOf((short)21));
    }
    
    public OFActionSetQueue(OFActionSetQueue other) {
    	super(other);
		this.queue_id = other.queue_id;
    }

	public int getQueueId() {
		return this.queue_id;
	}
	
	public OFActionSetQueue setQueueId(int queue_id) {
		this.queue_id = queue_id;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.queue_id = data.getInt();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putInt(this.queue_id);
    }

    public String toString() {
        return super.toString() +  ":OFActionSetQueue-"+":queue_id=" + U32.f(queue_id);
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
        		
		final int prime = 2213;
		int result = super.hashCode() * prime;
		result = prime * result + (int) queue_id;
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
        if (!(obj instanceof OFActionSetQueue)) {
            return false;
        }
        OFActionSetQueue other = (OFActionSetQueue) obj;
		if ( queue_id != other.queue_id ) return false;
        return true;
    }
}
