
/**
 * TestCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.etaoshi.spider.comm;

    /**
     *  TestCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TestCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TestCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TestCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getMessage method
            * override this method for handling normal response from getMessage operation
            */
           public void receiveResultgetMessage(
                    com.etaoshi.spider.comm.TestStub.GetMessageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMessage operation
           */
            public void receiveErrorgetMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for print method
            * override this method for handling normal response from print operation
            */
           public void receiveResultprint(
                    com.etaoshi.spider.comm.TestStub.PrintResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from print operation
           */
            public void receiveErrorprint(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for greeting method
            * override this method for handling normal response from greeting operation
            */
           public void receiveResultgreeting(
                    com.etaoshi.spider.comm.TestStub.GreetingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from greeting operation
           */
            public void receiveErrorgreeting(java.lang.Exception e) {
            }
                


    }
    