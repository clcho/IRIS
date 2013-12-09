package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import java.util.List;
import java.util.LinkedList;
import org.openflow.protocol.ver1_3.types.*;

public class OFGroupStatsEntry    {
    public static int MINIMUM_LENGTH = 40;

    short  length;
	short pad_1th;
	int  group_id;
	int  ref_count;
	int pad_2th;
	long  packet_count;
	long  byte_count;
	int  duration_sec;
	int  duration_nsec;
	List<OFBucketCounter>  bucket_stats;

    public OFGroupStatsEntry() {
        this.bucket_stats = new LinkedList<OFBucketCounter>();
    }
    
    public OFGroupStatsEntry(OFGroupStatsEntry other) {
    	this.length = other.length;
		this.group_id = other.group_id;
		this.ref_count = other.ref_count;
		this.packet_count = other.packet_count;
		this.byte_count = other.byte_count;
		this.duration_sec = other.duration_sec;
		this.duration_nsec = other.duration_nsec;
		this.bucket_stats = (other.bucket_stats == null)? null: new LinkedList<OFBucketCounter>();
		for ( OFBucketCounter i : other.bucket_stats ) { this.bucket_stats.add( new OFBucketCounter(i) ); }
    }

	public short getLength() {
		return this.length;
	}
	
	public OFGroupStatsEntry setLength(short length) {
		this.length = length;
		return this;
	}
			
	public int getGroupId() {
		return this.group_id;
	}
	
	public OFGroupStatsEntry setGroupId(int group_id) {
		this.group_id = group_id;
		return this;
	}
			
	public int getRefCount() {
		return this.ref_count;
	}
	
	public OFGroupStatsEntry setRefCount(int ref_count) {
		this.ref_count = ref_count;
		return this;
	}
			
	public long getPacketCount() {
		return this.packet_count;
	}
	
	public OFGroupStatsEntry setPacketCount(long packet_count) {
		this.packet_count = packet_count;
		return this;
	}
			
	public long getByteCount() {
		return this.byte_count;
	}
	
	public OFGroupStatsEntry setByteCount(long byte_count) {
		this.byte_count = byte_count;
		return this;
	}
			
	public int getDurationSec() {
		return this.duration_sec;
	}
	
	public OFGroupStatsEntry setDurationSec(int duration_sec) {
		this.duration_sec = duration_sec;
		return this;
	}
			
	public int getDurationNsec() {
		return this.duration_nsec;
	}
	
	public OFGroupStatsEntry setDurationNsec(int duration_nsec) {
		this.duration_nsec = duration_nsec;
		return this;
	}
			
	public List<OFBucketCounter> getBucketStats() {
		return this.bucket_stats;
	}
	
	public OFGroupStatsEntry setBucketStats(List<OFBucketCounter> bucket_stats) {
		this.bucket_stats = bucket_stats;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		this.length = data.getShort();
		this.pad_1th = data.getShort();
		this.group_id = data.getInt();
		this.ref_count = data.getInt();
		this.pad_2th = data.getInt();
		this.packet_count = data.getLong();
		this.byte_count = data.getLong();
		this.duration_sec = data.getInt();
		this.duration_nsec = data.getInt();
		if (this.bucket_stats == null) this.bucket_stats = new LinkedList<OFBucketCounter>();
		int __cnt = ((int)getLength() - (data.position() - mark));
		while (__cnt > 0) { OFBucketCounter t = new OFBucketCounter(); t.readFrom(data); this.bucket_stats.add(t); __cnt -= OFBucketCounter.MINIMUM_LENGTH; }
    }

    public void writeTo(ByteBuffer data) {
    	
        data.putShort(this.length);
		data.putShort(this.pad_1th);
		data.putInt(this.group_id);
		data.putInt(this.ref_count);
		data.putInt(this.pad_2th);
		data.putLong(this.packet_count);
		data.putLong(this.byte_count);
		data.putInt(this.duration_sec);
		data.putInt(this.duration_nsec);
		if (this.bucket_stats != null ) for (OFBucketCounter t: this.bucket_stats) { t.writeTo(data); }
    }

    public String toString() {
        return  ":OFGroupStatsEntry-"+":length=" + U16.f(length) + 
		":group_id=" + U32.f(group_id) + 
		":ref_count=" + U32.f(ref_count) + 
		":packet_count=" + U64.f(packet_count) + 
		":byte_count=" + U64.f(byte_count) + 
		":duration_sec=" + U32.f(duration_sec) + 
		":duration_nsec=" + U32.f(duration_nsec) + 
		":bucket_stats=" + bucket_stats.toString();
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	for ( OFBucketCounter i : this.bucket_stats ) { len += i.computeLength(); }
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
        		
		final int prime = 1907;
		int result = super.hashCode() * prime;
		result = prime * result + (int) length;
		result = prime * result + (int) group_id;
		result = prime * result + (int) ref_count;
		result = prime * result + (int) packet_count;
		result = prime * result + (int) byte_count;
		result = prime * result + (int) duration_sec;
		result = prime * result + (int) duration_nsec;
		result = prime * result + ((bucket_stats == null)?0:bucket_stats.hashCode());
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
        if (!(obj instanceof OFGroupStatsEntry)) {
            return false;
        }
        OFGroupStatsEntry other = (OFGroupStatsEntry) obj;
		if ( length != other.length ) return false;
		if ( group_id != other.group_id ) return false;
		if ( ref_count != other.ref_count ) return false;
		if ( packet_count != other.packet_count ) return false;
		if ( byte_count != other.byte_count ) return false;
		if ( duration_sec != other.duration_sec ) return false;
		if ( duration_nsec != other.duration_nsec ) return false;
		if ( bucket_stats == null && other.bucket_stats != null ) { return false; }
		else if ( !bucket_stats.equals(other.bucket_stats) ) { return false; }
        return true;
    }
}
