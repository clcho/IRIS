package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_0.types.*;

public class OFPortDesc    {
    public static int MINIMUM_LENGTH = 48;

    short  port;
	byte[]  hw_addr;
	byte[]  name;
	int  config;
	int  state;
	int  current_features;
	int  advertised_features;
	int  supported_features;
	int  peer_features;

    public OFPortDesc() {
        hw_addr = new byte[6];
		name = new byte[16];
    }
    
    public OFPortDesc(OFPortDesc other) {
    	this.port = other.port;
		if (other.hw_addr != null) { this.hw_addr = java.util.Arrays.copyOf(other.hw_addr, other.hw_addr.length); }
		if (other.name != null) { this.name = java.util.Arrays.copyOf(other.name, other.name.length); }
		this.config = other.config;
		this.state = other.state;
		this.current_features = other.current_features;
		this.advertised_features = other.advertised_features;
		this.supported_features = other.supported_features;
		this.peer_features = other.peer_features;
    }

	public short getPort() {
		return this.port;
	}
	
	public OFPortDesc setPort(short port) {
		this.port = port;
		return this;
	}
			
	public byte[] getHwAddr() {
		return this.hw_addr;
	}
	
	public OFPortDesc setHwAddr(byte[] hw_addr) {
		this.hw_addr = hw_addr;
		return this;
	}
			
	public byte[] getName() {
		return this.name;
	}
	
	public OFPortDesc setName(byte[] name) {
		this.name = name;
		return this;
	}
			
	public int getConfig() {
		return this.config;
	}
	
	public OFPortDesc setConfig(int config) {
		this.config = config;
		return this;
	}
			
	public int getState() {
		return this.state;
	}
	
	public OFPortDesc setState(int state) {
		this.state = state;
		return this;
	}
			
	public int getCurrentFeatures() {
		return this.current_features;
	}
	
	public OFPortDesc setCurrentFeatures(int current_features) {
		this.current_features = current_features;
		return this;
	}
			
	public int getAdvertisedFeatures() {
		return this.advertised_features;
	}
	
	public OFPortDesc setAdvertisedFeatures(int advertised_features) {
		this.advertised_features = advertised_features;
		return this;
	}
			
	public int getSupportedFeatures() {
		return this.supported_features;
	}
	
	public OFPortDesc setSupportedFeatures(int supported_features) {
		this.supported_features = supported_features;
		return this;
	}
			
	public int getPeerFeatures() {
		return this.peer_features;
	}
	
	public OFPortDesc setPeerFeatures(int peer_features) {
		this.peer_features = peer_features;
		return this;
	}
			

    public void readFrom(ByteBuffer data) {
        this.port = data.getShort();
		if ( this.hw_addr == null ) this.hw_addr = new byte[6];
		data.get(this.hw_addr);
		if ( this.name == null ) this.name = new byte[16];
		data.get(this.name);
		this.config = data.getInt();
		this.state = data.getInt();
		this.current_features = data.getInt();
		this.advertised_features = data.getInt();
		this.supported_features = data.getInt();
		this.peer_features = data.getInt();
    }

    public void writeTo(ByteBuffer data) {
    	
        data.putShort(this.port);
		if ( this.hw_addr != null ) { data.put(this.hw_addr); }
		if ( this.name != null ) { data.put(this.name); }
		data.putInt(this.config);
		data.putInt(this.state);
		data.putInt(this.current_features);
		data.putInt(this.advertised_features);
		data.putInt(this.supported_features);
		data.putInt(this.peer_features);
    }

    public String toString() {
        return  ":OFPortDesc-"+":port=" + U16.f(port) + 
		":hw_addr=" + java.util.Arrays.toString(hw_addr) + 
		":name=" + java.util.Arrays.toString(name) + 
		":config=" + U32.f(config) + 
		":state=" + U32.f(state) + 
		":current_features=" + U32.f(current_features) + 
		":advertised_features=" + U32.f(advertised_features) + 
		":supported_features=" + U32.f(supported_features) + 
		":peer_features=" + U32.f(peer_features);
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
        		
		final int prime = 2903;
		int result = super.hashCode() * prime;
		result = prime * result + (int) port;
		result = prime * result + ((hw_addr == null)?0:java.util.Arrays.hashCode(hw_addr));
		result = prime * result + ((name == null)?0:java.util.Arrays.hashCode(name));
		result = prime * result + (int) config;
		result = prime * result + (int) state;
		result = prime * result + (int) current_features;
		result = prime * result + (int) advertised_features;
		result = prime * result + (int) supported_features;
		result = prime * result + (int) peer_features;
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
        if (!(obj instanceof OFPortDesc)) {
            return false;
        }
        OFPortDesc other = (OFPortDesc) obj;
		if ( port != other.port ) return false;
		if ( hw_addr == null && other.hw_addr != null ) { return false; }
		else if ( !java.util.Arrays.equals(hw_addr, other.hw_addr) ) { return false; }
		if ( name == null && other.name != null ) { return false; }
		else if ( !java.util.Arrays.equals(name, other.name) ) { return false; }
		if ( config != other.config ) return false;
		if ( state != other.state ) return false;
		if ( current_features != other.current_features ) return false;
		if ( advertised_features != other.advertised_features ) return false;
		if ( supported_features != other.supported_features ) return false;
		if ( peer_features != other.peer_features ) return false;
        return true;
    }
}
