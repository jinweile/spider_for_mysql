
/**
 * AcciInfServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.jt.webservice.dy;

    /**
     *  AcciInfServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AcciInfServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AcciInfServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AcciInfServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for applyExecute method
            * override this method for handling normal response from applyExecute operation
            */
           public void receiveResultapplyExecute(
                    com.jt.webservice.dy.AcciInfServiceStub.ApplyExecuteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from applyExecute operation
           */
            public void receiveErrorapplyExecute(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for endorExecute method
            * override this method for handling normal response from endorExecute operation
            */
           public void receiveResultendorExecute(
                    com.jt.webservice.dy.AcciInfServiceStub.EndorExecuteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from endorExecute operation
           */
            public void receiveErrorendorExecute(java.lang.Exception e) {
            }
                


    }
    