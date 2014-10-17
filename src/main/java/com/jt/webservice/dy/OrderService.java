package com.jt.webservice.dy;

public interface OrderService {

	/**
	 * 出单
	 * @param xml
	 * @return
	 * @throws java.rmi.RemoteException
	 */
    public byte[] applyExecute(byte[] xml) throws Exception;
	
	/**
	 * 契撤
	 * @param xml
	 * @return
	 * @throws java.rmi.RemoteException
	 */
    public byte[] endorExecute(byte[] xml) throws Exception;
	
}
